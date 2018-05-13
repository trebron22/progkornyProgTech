package com.unideb.beadando.model;

/**
 * CartElement model class.
 * @author gagyi.norbert
 *
 */
public class CartElement {

	/**
	 *  quantity of cartElement.
	 */
	private int quantity;

	/**
	 * product object.
	 */
	private Product product;
	
	/**
	 * this construct set CartElement with quantity 1 and product.
	 * @param product product object.
	 */
	public CartElement(Product product) {
		this.quantity = 1;
		this.product = product;
	}

	/**
	 * quantity getter.
	 * @return quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * quantity setter.
	 * @param quantity quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * product getter.
	 * @return product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * product setter.
	 * @param product product.
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * function increment quantity with +1.
	 */
	public void incrementQuantity() {
		this.quantity++;
	}

	@Override
	public String toString() {
		return "CartElement [quantity=" + quantity + ", product=" + product + "]";
	}
	
	

}
