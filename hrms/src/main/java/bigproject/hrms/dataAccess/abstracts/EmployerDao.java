package bigproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bigproject.hrms.entities.concretes.Employer;
@Repository
public interface EmployerDao extends JpaRepository<Employer, Integer>{
	Employer findByEmail(String email);
}
