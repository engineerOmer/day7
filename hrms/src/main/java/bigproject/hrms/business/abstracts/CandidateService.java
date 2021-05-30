package bigproject.hrms.business.abstracts;

import java.util.List;

import bigproject.hrms.core.utilities.results.DataResult;
import bigproject.hrms.core.utilities.results.Result;
import bigproject.hrms.entities.concretes.Candidate;

public interface CandidateService {
	DataResult<Candidate> getByNationalIdentity(String nationalIdentity);
	DataResult<Candidate> getByEmail(String email);
	Result add(Candidate candidate);
	DataResult<List<Candidate>> getAll();
	
}
