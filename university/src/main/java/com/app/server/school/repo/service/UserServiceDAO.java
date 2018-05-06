package com.app.server.school.repo.service;

import com.app.server.school.bean.User;

public interface UserServiceDAO {
	
	/**
	 * @param email
	 * @return
	 */
	public User findUserByEmail(String email);
	
	/**
	 * @param user
	 * @return
	 */
	public void addUser(User user);
	
}
