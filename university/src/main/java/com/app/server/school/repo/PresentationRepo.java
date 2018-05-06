package com.app.server.school.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.server.school.bean.Presentation;


@Repository("presentationRepo")
public interface PresentationRepo extends JpaRepository<Presentation, Integer>{

	/**
	 * @param topic
	 * @return
	 */
	List<Presentation> findByTopic(String topic);
	/**
	 * @param subject
	 * @return
	 */
	List<Presentation> findBySubject(String subject);
	/**
	 * @param supervisor
	 * @return
	 */
	List<Presentation> findBySupervisor(String supervisor);
	
}
