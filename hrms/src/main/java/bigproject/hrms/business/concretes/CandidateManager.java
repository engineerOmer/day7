package bigproject.hrms.business.concretes;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bigproject.hrms.business.abstracts.CandidateService;
import bigproject.hrms.core.Adapters.UserCheckService;
import bigproject.hrms.core.utilities.results.DataResult;
import bigproject.hrms.core.utilities.results.ErrorResult;
import bigproject.hrms.core.utilities.results.Result;
import bigproject.hrms.core.utilities.results.SuccessDataResult;
import bigproject.hrms.core.utilities.results.SuccessResult;
import bigproject.hrms.dataAccess.abstracts.CandidateDao;
import bigproject.hrms.entities.concretes.Candidate;
@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private UserCheckService userCheckService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, UserCheckService userCheckService) {

		super();
		this.candidateDao = candidateDao;
		this.userCheckService = userCheckService;

	}

	@Override
	public DataResult<Candidate> getByNationalIdentity(String nationalIdentity) {

		return new SuccessDataResult<Candidate>(this.candidateDao.findBynationalIdentity(nationalIdentity));
	}

	@Override
	public DataResult<Candidate> getByEmail(String email) {

		return new SuccessDataResult<Candidate>(this.candidateDao.findByEmail(email));
	}

	@Override
	public DataResult<List<Candidate>> getAll() {

		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"Is basvurusu yapanlar listelendi");
	}

	private boolean checkIfEmailExists(String email) {
		if (this.candidateDao.findByEmail(email) != null) {
			return false;
		}
		return true;

	}

	private boolean checkIfnationalIdentity(String nationalIdentity) {
		if (this.candidateDao.findBynationalIdentity(nationalIdentity) != null) {
			return false;
		}
		return true;
	}

	private boolean checkIfRealPerson(Candidate candidate) {
		if (!this.userCheckService.checkIfRealPerson(Long.parseLong(candidate.getNationalIdentity()),
				candidate.getFirstName().toUpperCase(new Locale("tr")),
				candidate.getLastName().toLowerCase(new Locale("tr")), candidate.getDateOfBirth())) {

			return false;
		}
		return true;

	}

	private boolean validationForCandidate(Candidate candidate) {

		if (candidate.getFirstName() == null && candidate.getLastName() == null && candidate.getPassword() == null
				&& candidate.getPasswordRepeat() == null && candidate.getNationalIdentity() == null
				&& candidate.getDateOfBirth() == null && candidate.getEmail() == null) {
			return false;

		}
		return true;
	}

	@Override
	public Result add(Candidate candidate) {

		if (!validationForCandidate(candidate)) {
			return new ErrorResult("Bilgilerinizi eksiksiz giriniz");
		}

		if (!checkIfRealPerson(candidate)) {
			return new ErrorResult("gecersiz kullanici");
		}
		if (!checkIfEmailExists(candidate.getEmail())) {
			return new ErrorResult("bu email kullaniliyor");
		}
		if (!checkIfnationalIdentity(candidate.getNationalIdentity())) {
			return new ErrorResult("Kimlik bilgilerinizi dogru giriniz");
		}

		this.candidateDao.save(candidate);
		return new SuccessResult("Yeni eleman alindi");

	}

}
