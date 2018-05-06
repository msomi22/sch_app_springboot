/**
 * 
 */
package com.app.server.school.bean;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;

/**
 * @author peter
 *
 */
@Entity
@Table(name = "presentation")
public class Presentation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pre_no")
	private int preNo;
	
	@Column(name = "topic")
	@Email(message = "*Please provide a valid topic")
	@NotEmpty(message = "*Please provide an topic")
	private String topic;
	
	@Column(name = "subject")
	@Length(min = 50, message = "*Your subject must have at least 50 characters")
	@NotEmpty(message = "*Please provide your subject")
	@Transient
	private String subject;
	
	@Column(name = "supervisor")
	@NotEmpty(message = "*Please provide your supervisor")
	private String supervisor;
	
	@Column(name = "add_date")
	private Date add_date;
	


	/**
	 * @return the preNo
	 */
	public int getPreNo() {
		return preNo;
	}


	/**
	 * @param preNo the preNo to set
	 */
	public void setPreNo(int preNo) {
		this.preNo = preNo;
	}


	/**
	 * @return the topic
	 */
	public String getTopic() {
		return topic;
	}


	/**
	 * @param topic the topic to set
	 */
	public void setTopic(String topic) {
		this.topic = topic;
	}


	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}


	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}


	/**
	 * @return the supervisor
	 */
	public String getSupervisor() {
		return supervisor;
	}


	/**
	 * @param supervisor the supervisor to set
	 */
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}


	/**
	 * @return the add_date
	 */
	public Date getAdd_date() {
		return add_date;
	}


	/**
	 * @param add_date the add_date to set
	 */
	public void setAdd_date(Date add_date) {
		this.add_date = add_date;
	}

}
