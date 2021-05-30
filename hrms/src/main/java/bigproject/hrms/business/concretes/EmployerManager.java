package bigproject.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import org.springframework.stereotype.Service;

import bigproject.hrms.business.abstracts.EmployerService;
import bigproject.hrms.core.utilities.results.DataResult;
import bigproject.hrms.core.utilities.results.ErrorResult;
import bigproject.hrms.core.utilities.results.Result;
import bigproject.hrms.core.utilities.results.SuccessDataResult;
import bigproject.hrms.core.utilities.results.SuccessResult;
import bigproject.hrms.dataAccess.abstracts.EmployerDao;
import bigproject.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerdao;

	@Autowired
	public EmployerManager(EmployerDao employerdao) {
		super();
		this.employerdao = employerdao;
	}

	@Override
	public DataResult<Employer> getByEmail(String email) {

		return new SuccessDataResult<Employer>(this.employerdao.findByEmail(email));

	}

	@Override
	public SuccessDataResult<List<Employer>> getAll() {

		return new SuccessDataResult<List<Employer>>(this.employerdao.findAll(), "Tum is verenler listelendi");

	}

	private boolean validationForEmployer(Employer employer) {

		if (employer.getCompanyName() == null && employer.getEmail() == null && employer.getPassword() == null
				&& employer.getPasswordRepeat() == null && employer.getPhoneNumber() == null
				&& employer.getWebAddress() == null) {
			return false;

		}
		return true;
	}

	private boolean checkIfEmailExists(String email) {
		if (this.employerdao.findByEmail(email) != null) {
			return false;
		}
		return true;

	}

	// Birisinden alindi arastir
	private boolean checkIfEqualEmailAndDomain(String email, String website) {
		String[] emailArr = email.split("@", 2);
		String domain = website.substring(4, website.length());

		if (emailArr[1].equals(domain)) {

			return true;
		}

		return false;
	}

	@Override
	public Result add(Employer employer) {
		if (!checkIfEmailExists(employer.getEmail())) {
			return new ErrorResult("Bu email baskasi tarafindan kullaniliyor!");
		}
		if (!validationForEmployer(employer)) {
			return new ErrorResult("Bilgilerinizi eksiksiz giriniz!");
		}
		if (!this.checkIfEqualEmailAndDomain(employer.getEmail(), employer.getWebAddress())) {
			return new ErrorResult("Gecersiz mail adresi!");

		}

		this.employerdao.save(employer);
		return new SuccessResult("Yeni eleman alindi");

	}
}
