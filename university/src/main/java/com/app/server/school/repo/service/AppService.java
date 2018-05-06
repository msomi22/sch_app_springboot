/**
 * 
 */
package com.app.server.school.repo.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.server.school.bean.Presentation;
import com.app.server.school.bean.Role;
import com.app.server.school.bean.User;
import com.app.server.school.repo.PresentationRepo;
import com.app.server.school.repo.RoleRepository;
import com.app.server.school.repo.UserRepo;

/**
 * @author peter
 *
 */

@Service("userService")
public class AppService implements UserServiceDAO, PresentationServiceDAO {

	@Autowired
	private UserRepo userRepo;
	@Autowired
    private PresentationRepo presentationRepo;
	@Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	/**
	 * @see com.app.server.school.repo.service.UserServiceDAO#findUserByEmail(java.lang.String)
	 */
	@Override
	public User findUserByEmail(String email) {
		return userRepo.findByEmail(email); 
	}

	/**
	 * @see com.app.server.school.repo.service.UserServiceDAO#addUser(com.app.server.school.bean.User)
	 */
	@Override
	public void addUser(User user) {
		
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setIsActive(1); 
		Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		
		userRepo.save(user); 
		
	}

	/**
	 * @see com.app.server.school.repo.service.PresentationServiceDAO#addPresentation(com.app.server.school.bean.Presentation)
	 */
	@Override
	public void addPresentation(Presentation presentation) {
		
		Presentation pre = presentationRepo.save(presentation); 
	}

	/**
	 * @see com.app.server.school.repo.service.PresentationServiceDAO#findPresentationByTopic(java.lang.String)
	 */
	@Override
	public List<Presentation> findPresentationByTopic(String topic) {
		return presentationRepo.findByTopic(topic); 
	}

	/**
	 * @see com.app.server.school.repo.service.PresentationServiceDAO#findPresentationBySubject(java.lang.String)
	 */
	@Override
	public List<Presentation> findPresentationBySubject(String subject) {
		return presentationRepo.findBySubject(subject); 
	}

	/**
	 * @see com.app.server.school.repo.service.PresentationServiceDAO#findPresentationBySupervisor(java.lang.String)
	 */
	@Override
	public List<Presentation> findPresentationBySupervisor(String supervisor) {
		return presentationRepo.findBySupervisor(supervisor);
	} 

}
