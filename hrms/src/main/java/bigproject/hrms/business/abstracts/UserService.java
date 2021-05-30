package bigproject.hrms.business.abstracts;

import java.util.List;

import bigproject.hrms.core.utilities.results.DataResult;
import bigproject.hrms.core.utilities.results.Result;
import bigproject.hrms.entities.concretes.User;



public interface UserService {
	DataResult<List<User>>  getAll();
		
	Result add(User user);	
	
}
