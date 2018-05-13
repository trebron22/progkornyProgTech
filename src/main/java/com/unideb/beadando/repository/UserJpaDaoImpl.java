package com.unideb.beadando.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.unideb.beadando.model.User;

/**
 * user jpa dao implementation.
 * 
 * @author gagyi.norbert
 *
 */
@Repository
@Transactional
public class UserJpaDaoImpl implements UserJpaDao {

	/**
	 * static log4j logger for this class.
	 */
	static Logger logger = Logger.getLogger(UserJpaDaoImpl.class.getName());

	/**
	 * entity manager for one request one antitymanager.
	 */
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<User> getUsers() {
		logger.info("Start getUser UserRepo");
		logger.info(entityManager.getClass());
		TypedQuery<User> users = entityManager.createNamedQuery("find_all_users", User.class);
		return users.getResultList();
	}

	@Override
	public User getUser(String username, String password) throws NoResultException {
		TypedQuery<User> query = entityManager
				.createQuery("SELECT u FROM User u WHERE u.userName = ?1 and u.password = ?2", User.class);

		return query.setParameter(1, username).setParameter(2, password).getSingleResult();
	}

	@Override
	public void insertUser(String username, String password) {
		Query query = entityManager.createNativeQuery("INSERT INTO user (username, password) VALUES (?, ?)");
		query.setParameter(1, username);
		query.setParameter(2, password);
		query.executeUpdate();

	}

	@Override
	public User getUserByUsername(String username) {
		
		return entityManager.createQuery("SELECT u FROM User u WHERE u.userName = ?1", User.class).setParameter(1, username).getSingleResult();
	}

}
