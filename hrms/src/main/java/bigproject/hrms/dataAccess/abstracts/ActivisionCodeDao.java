package bigproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bigproject.hrms.entities.concretes.ActivisionCode;
@Repository
public interface ActivisionCodeDao extends JpaRepository<ActivisionCode, Integer>{
	
	ActivisionCode findByIdAndActivisionCode(int id ,String activisionCode);
	
}
