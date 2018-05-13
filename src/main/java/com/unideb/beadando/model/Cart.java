package com.unideb.beadando.model;

/**
 * this is a Cart model.
 * @author gagyi.norbert
 *
 */
public class Cart {

	/**
	 * price int attribute. 
	 */
	private int price;

	/**
	 * cartElement cartElement.
	 */
	private CartElement cartElement;

	/**
	 * this function create a new cartElement with a product.
	 * @param product is a product object.
	 */
	public Cart(Product product) {
		cartElement = new CartElement(product);
	}

	/**
	 * this is a cartElement getter function.
	 * @return cartElement object.
	 */
	public CartElement getCartElement() {
		return cartElement;
	}

	/**
	 * set CartElement with cartElement.
	 * @param cartElement is a cartElement object.
	 */
	public void setCartElement(CartElement cartElement) {
		this.cartElement = cartElement;
	}

	/**
	 * set price.
	 * @param price price value.
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * construct is set Cart object with price and CartElement.
	 * @param price int price.
	 * @param cartElement CartElement object.
	 */
	public Cart(int price, CartElement cartElement) {
		super();
		this.price = price;
		this.cartElement = cartElement;
	}

	/**
	 * this function calculate price.
	 * @return actual price.
	 */
	public int getPrice() {

		this.price = (cartElement.getQuantity() * cartElement.getProduct().getPrice());

		return this.price;

	}

	/**
	 * this function test how product existing cartElement.
	 * @param product product object.
	 * @return true if product id of cart element is equal product's product id any way return false.
	 */
	public boolean equalsProductId(Product product) {

		return cartElement.getProduct().getId() == product.getId();
	}

	/**
	 * this function increment quantity for cartElement.
	 */
	public void incrementQuantity() {
		cartElement.incrementQuantity();
	}

	/**
	 * Quantity getter.
	 * @return cartElement's quantity.
	 */
	public int getQuantity() {
		return cartElement.getQuantity();
	}

	@Override
	public String toString() {
		return "Cart [price=" + price + ", cartElement=" + cartElement + "]";
	}

	
}
