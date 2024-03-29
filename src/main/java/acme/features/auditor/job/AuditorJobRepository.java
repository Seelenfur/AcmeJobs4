
package acme.features.auditor.job;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.jobs.Job;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuditorJobRepository extends AbstractRepository {

	@Query("select j from Job j where j.id = ?1")
	Job findOneJobById(int id);

	@Query("select a.job from Audit a where a.auditor.id = ?1 and a.job.status = acme.entities.jobs.JobStatus.PUBLISHED and a.job.deadline > current_date()")
	Collection<Job> findManyByAuditorId(int auditorId);

	@Query("select j from Job j where j.id not in (select a.job.id from Audit a where a.auditor.id = ?1) and j.status = acme.entities.jobs.JobStatus.PUBLISHED and j.deadline > current_date()")
	Collection<Job> findOthersByAuditorId(int auditorId);
}
