package bigproject.hrms.business.abstracts;

import java.util.List;

import bigproject.hrms.core.utilities.results.DataResult;
import bigproject.hrms.core.utilities.results.Result;
import bigproject.hrms.entities.concretes.Employer;

public interface EmployerService {
	DataResult<Employer> getByEmail(String email);
	Result add(Employer employer);
	DataResult<List<Employer>> getAll();
}
