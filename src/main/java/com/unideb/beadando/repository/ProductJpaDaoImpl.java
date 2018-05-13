package com.unideb.beadando.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.unideb.beadando.model.Product;

/**
 * java persistence api repository layer which is depends on ProductJpaDao Interface.
 * @author gagyi.norbert
 *
 */
@Repository
public class ProductJpaDaoImpl implements ProductJpaDao {

	/**
	 * log4j static logger for this class.
	 */
	static Logger logger = Logger.getLogger(UserJpaDaoImpl.class.getName());

	/**
	 * entity manager with persistenc context which is support for one request one  entitymanager and after response throw it.
	 */
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Product> getAllProduct() {

		return (List<Product>) entityManager.createQuery("select p from Product p", Product.class).getResultList();
	}

	@Override
	public Product getProductById(int id) {
		TypedQuery<Product> query = entityManager.createQuery("SELECT p FROM Product p WHERE p.id = ?1 ",
				Product.class);

		return query.setParameter(1, id).getSingleResult();
	}

}
