package bigproject.hrms.business.abstracts;

import java.util.List;

import bigproject.hrms.core.utilities.results.DataResult;
import bigproject.hrms.core.utilities.results.Result;
import bigproject.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	Result add(JobPosition jobPosition);
	DataResult<List<JobPosition>> getAll();
}
