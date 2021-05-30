package bigproject.hrms.dataAccess.abstracts;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bigproject.hrms.entities.concretes.User;
@Repository
public interface UserDao extends JpaRepository<User, Integer>{

	User findByEmail(String email);

}
