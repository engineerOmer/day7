package bigproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bigproject.hrms.entities.concretes.Candidate;
@Repository
public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	Candidate findBynationalIdentity(String nationalIdentity);
	Candidate findByEmail(String email);
}
