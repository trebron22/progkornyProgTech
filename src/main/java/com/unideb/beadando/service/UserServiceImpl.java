package com.unideb.beadando.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.unideb.beadando.model.User;
import com.unideb.beadando.repository.UserJpaDao;

/**
 * user service implemantation.
 * 
 * @author gagyi.norbert
 *
 */
@Service
public class UserServiceImpl implements IUserService {

	/**
	 * userjpaDao with inject.
	 */
	@Autowired
	UserJpaDao userJpaDao;

	@Override
	public boolean userLogInWithUsernameAndPassowrd(String username, String password)
			throws EmptyResultDataAccessException {
		try {
			if (userJpaDao.getUser(username, encodePassword(password) ) != null) {
				return true;
			} else {
				throw new EmptyResultDataAccessException(1);
			}

		} catch (EmptyResultDataAccessException e) {

			return false;
		}

	}

	@Override
	public String encodePassword(String password) {
		return new BCryptPasswordEncoder().encode(password);
	}

	@Override
	public void createUser(String username, String password) {
		userJpaDao.insertUser(username, encodePassword(password) );

	}

	@Override
	public User getUserByUsername(String username) {
		return userJpaDao.getUserByUsername(username);
	}

}
