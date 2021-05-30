package bigproject.hrms.business.concretes;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import bigproject.hrms.business.abstracts.JobPositionService;
import bigproject.hrms.core.utilities.results.DataResult;
import bigproject.hrms.core.utilities.results.ErrorResult;
import bigproject.hrms.core.utilities.results.Result;
import bigproject.hrms.core.utilities.results.SuccessDataResult;
import bigproject.hrms.core.utilities.results.SuccessResult;
import bigproject.hrms.dataAccess.abstracts.JobPositionDao;
import bigproject.hrms.entities.concretes.JobPosition;


@Service()
public class JobPositionManager implements JobPositionService{
	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(@Lazy JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao; 
		
	}
	
	@Override
	public Result add(JobPosition jobPosition) {
		if(!this.checkPositionNameControl(jobPosition.getTitle())) {
			return new ErrorResult("Bu pozisyon daha once kelendi");
		}
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("Pozisyon basiriyla eklendi");
		
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		
		return new SuccessDataResult<List<JobPosition>> (this.jobPositionDao.findAll(), "Tum is pozsiyonlari listelendi");
	}
	
	
	private boolean checkPositionNameControl(String title) {
		if(this.jobPositionDao.findByTitle(title) != null) {
			return false;
		}
		return true;
	}

}
