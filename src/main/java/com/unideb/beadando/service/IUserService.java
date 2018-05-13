package com.unideb.beadando.service;

import org.springframework.dao.EmptyResultDataAccessException;

import com.unideb.beadando.model.User;

/**
 * user servcice interface.
 * 
 * @author gagyi.norbert
 *
 */
public interface IUserService {

	/**
	 * test correct username and password for log in.
	 * 
	 * @param username
	 *            username.
	 * @param password
	 *            password.
	 * @return true is username and password exist any way false.
	 * @throws EmptyResultDataAccessException if authentication is falsed
	 */
	public boolean userLogInWithUsernameAndPassowrd(String username, String password)
			throws EmptyResultDataAccessException;

	/**
	 * create user.
	 * @param username is username.
	 * @param password is password.
	 */
	public void createUser(String username, String password);

	/**
	 * password encoder.
	 * @param password is password.
	 * @return encoded password.
	 */
	String encodePassword(String password);
	
	/**
	 * get user by username.
	 * @param username is username.
	 * @return the user.
	 */
	public User getUserByUsername(String username);
}
