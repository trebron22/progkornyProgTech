package com.unideb.beadando.repository;

import java.util.List;

import javax.persistence.NoResultException;

import com.unideb.beadando.model.User;

/**
 * User Data acces object interface.
 * @author gagyi.norbert
 *
 */
public interface UserJpaDao {

	/**
	 * user getter which is test correct username and password.
	 * @param username username.
	 * @param password password.
	 * @return user.
	 * @throws NoResultException if no result.
	 */
	public User getUser(String username, String password) throws NoResultException;
	/**
	 * get all users.
	 * @return users list.
	 */
	public List<User> getUsers();
	
	/**
	 * insertUser with username and password.
	 * @param username is username
	 * @param password is password.
	 */
	public void insertUser(String username, String password);
	
	/**
	 * get user by username.	
	 * @param username is username.	
	 * @return the user.
	 */
	public User getUserByUsername(String username);

}
