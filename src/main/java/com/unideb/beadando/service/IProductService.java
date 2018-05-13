package com.unideb.beadando.service;

import java.util.List;

import com.unideb.beadando.model.Cart;
import com.unideb.beadando.model.Product;

/**
 * product service interface.
 * @author gagyi.norbert
 *
 */
public interface IProductService {

	/**
	 * all products getter.
	 * @return products list.
	 */
	public List<Product> getProducts();
	/**
	 * product getter which is test correct id.
	 * @param id id.
	 * @return product by id.
	 */

	public Product getProductById(int id);
	
	/**
	 * test how you buy enough how to get a discount.
	 * @param carts carts list.
	 * @return true is a price is greater than 3000 any way false.
	 */
	public boolean hasOffer(List<Cart> carts);
	
	/**
	 * this function calculate a finally price.
	 * @param carts carts list.
	 * @return price.
	 */
	
	public int finallyPrice(List<Cart> carts);
	
	/**
	 * this function get summary price.
	 * @param carts all of carts.
	 * @return price of carts of product.
	 */
	public int getPrice(List<Cart> carts);
	
	/**
	 * this function analyze exist woman things in carts.
	 * @param carts carts.	
	 * @return true if has at least one woman thing any way return false.
	 */
	public boolean hasWomanThings(List<Cart> carts);
}
