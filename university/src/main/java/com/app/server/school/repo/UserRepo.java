/**
 * 
 */
package com.app.server.school.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.server.school.bean.User;


/**
 * @author peter
 *
 */

@Repository("userRepo")
public interface UserRepo extends JpaRepository<User, Integer>{

	/**
	 * @param email
	 * @return
	 */
	User findByEmail(String email); 
}
