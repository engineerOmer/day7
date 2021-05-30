package bigproject.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "candidates")
@Entity
@EqualsAndHashCode(callSuper = false)
public class Candidate extends User{
	
	
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "nationail_identity")
	private String nationalIdentity;
	
	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;

	
	@Column(name = "password_repeat")
	private String PasswordRepeat;
	
	
	
}
