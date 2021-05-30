package bigproject.hrms.core.Adapters;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import bigproject.hrms.MernisService.FakeMernisService;

@Service
public class MernisServiceAdapter implements UserCheckService{

	@Override
	public boolean checkIfRealPerson(long nationalityId, String firstName, String lastName, LocalDate dateOfBirth) {

		FakeMernisService service = new FakeMernisService();
		
		boolean result = service.TCKimlikDogrula(nationalityId, firstName, lastName, dateOfBirth);
		
		return result;
	}

}
