
package acme.features.auditor;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.jobs.Job;
import acme.entities.roles.Auditor;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuditorJobRepository extends AbstractRepository {

	@Query("select j from Job j where j.id = ?1")
	Job findOneJobById(int id);

	@Query("select j from Job j where j.reference = ?1")
	Job findOneJobByReference(String reference);

	@Query("select a.job from AuditorRecord a where a.auditor.id = ?1")
	Collection<Job> findManyByAuditorId(int auditorId);

	@Query("select a.job from AuditorRecord a where a.auditor.id != ?1")
	Collection<Job> findNotManyByAuditorId(int auditorId);

	@Query("select e from Auditor e where e.id = ?1")
	Auditor findOneAuditorById(int id);
}
