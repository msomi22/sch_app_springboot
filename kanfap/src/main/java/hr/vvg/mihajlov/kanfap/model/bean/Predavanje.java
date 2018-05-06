package hr.vvg.mihajlov.kanfap.model.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "predavanje")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"datumUpisa"}, 
        allowGetters = true)

public class Predavanje  implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String tema;
	
	@NotBlank
	private String sadrzaj;
	
	@NotBlank
	private String vrsta;
	
	@NotBlank
	private boolean objavljeno;
	
	@Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
	@CreatedDate 
	private Date datumUpisa;
	
	
	
	

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
	 * @return the tema
	 */
	public String getTema() {
		return tema;
	}

	/**
	 * @param tema the tema to set
	 */
	public void setTema(String tema) {
		this.tema = tema;
	}

	/**
	 * @return the sadrzaj
	 */
	public String getSadrzaj() {
		return sadrzaj;
	}

	/**
	 * @param sadrzaj the sadrzaj to set
	 */
	public void setSadrzaj(String sadrzaj) {
		this.sadrzaj = sadrzaj;
	}

	/**
	 * @return the vrsta
	 */
	public String getVrsta() {
		return vrsta;
	}

	/**
	 * @param vrsta the vrsta to set
	 */
	public void setVrsta(String vrsta) {
		this.vrsta = vrsta;
	}

	/**
	 * @return the objavljeno
	 */
	public boolean isObjavljeno() {
		return objavljeno;
	}

	/**
	 * @param objavljeno the objavljeno to set
	 */
	public void setObjavljeno(boolean objavljeno) {
		this.objavljeno = objavljeno;
	}

	/**
	 * @return the datumUpisa
	 */
	public Date getDatumUpisa() {
		return datumUpisa;
	}

	/**
	 * @param datumUpisa the datumUpisa to set
	 */
	public void setDatumUpisa(Date datumUpisa) {
		this.datumUpisa = datumUpisa;
	}
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8865604503432262066L;

}
