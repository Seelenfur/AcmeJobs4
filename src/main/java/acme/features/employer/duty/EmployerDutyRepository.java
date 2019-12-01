
package acme.features.employer.duty;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.jobs.Duty;
import acme.entities.jobs.Job;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerDutyRepository extends AbstractRepository {

	@Query("select j from Job j where j.id = ?1")
	Job findOneJobById(int id);

	@Query("select j.descriptor.duties from Job j where j.id = ?1")
	Collection<Duty> findManyByJobId(int jobId);

	@Query("select j from Job j where j.descriptor.id = ?1")
	Job findOneJobByDescriptorId(int descriptorId);

	@Query("select d from Duty d where d.id = ?1")
	Duty findOneDutyById(int id);
}
