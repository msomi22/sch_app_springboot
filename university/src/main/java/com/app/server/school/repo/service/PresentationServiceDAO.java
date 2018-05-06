/**
 * 
 */
package com.app.server.school.repo.service;

import java.util.List;

import com.app.server.school.bean.Presentation;

/**
 * @author peter
 *
 */
public interface PresentationServiceDAO {
	
	/**
	 * @param presentation
	 * @return
	 */
	public void addPresentation(Presentation presentation);  
	
	/**
	 * @param topic
	 * @return
	 */
	List<Presentation> findPresentationByTopic(String topic);
	/**
	 * @param subject
	 * @return
	 */
	List<Presentation> findPresentationBySubject(String subject);
	/**
	 * @param supervisor
	 * @return
	 */
	List<Presentation> findPresentationBySupervisor(String supervisor);

}
