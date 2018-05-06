package hr.vvg.mihajlov.kanfap.model.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "predavanje_predavac")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(allowGetters = true) 
public class Predavanje_Predavac implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private long predavanje;
	
	@NotBlank
	private long predavac;
	
	
	
	
	
	
	

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the predavanje
	 */
	public long getPredavanje() {
		return predavanje;
	}

	/**
	 * @param predavanje the predavanje to set
	 */
	public void setPredavanje(long predavanje) {
		this.predavanje = predavanje;
	}

	/**
	 * @return the predavac
	 */
	public long getPredavac() {
		return predavac;
	}

	/**
	 * @param predavac the predavac to set
	 */
	public void setPredavac(long predavac) {
		this.predavac = predavac;
	}

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8865604503432262066L;
}
