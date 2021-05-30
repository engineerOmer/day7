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
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "activision_codes")
@Entity
public class ActivisionCode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id ;
	
	
	@Column(name = "activision_code")
	private String activisionCode;
	
	
	@Column(name = "is_conformed")
	private boolean isConformed;
	
	
	@Column(name = "confirm_date")
	private LocalDate confirmDate;
	
}
