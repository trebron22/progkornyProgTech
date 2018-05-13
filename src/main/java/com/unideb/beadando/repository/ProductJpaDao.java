package com.unideb.beadando.repository;

import java.util.List;

import com.unideb.beadando.model.Product;

/**
 * Product Data AccesObject interface.
 * @author gagyi.norbert
 *
 */
public interface ProductJpaDao {

	/**
	 * this function will be a getter which is return all products.
	 * @return all products in a list.
	 */
	public List<Product> getAllProduct();
	/**
	 * this function is a getter which is get the product by id equalization.
	 * @param id id tag.
	 * @return product.
	 */
	public Product getProductById(int id);
}
