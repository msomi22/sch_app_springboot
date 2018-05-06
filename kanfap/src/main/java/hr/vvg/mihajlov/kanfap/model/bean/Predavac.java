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
@Table(name = "predavac")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"datumUpisa"}, 
allowGetters = true)

public class Predavac implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String pozicija;
	
	@NotBlank
	private String ime;
	
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
	 * @return the pozicija
	 */
	public String getPozicija() {
		return pozicija;
	}

	/**
	 * @param pozicija the pozicija to set
	 */
	public void setPozicija(String pozicija) {
		this.pozicija = pozicija;
	}

	/**
	 * @return the ime
	 */
	public String getIme() {
		return ime;
	}

	/**
	 * @param ime the ime to set
	 */
	public void setIme(String ime) {
		this.ime = ime;
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
