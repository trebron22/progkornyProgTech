package com.unideb.beadando.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.unideb.beadando.model.Cart;
import com.unideb.beadando.model.Product;
import com.unideb.beadando.model.User;

/**
 * this is a session handler class.
 * @author gagyi.norbert
 *
 */
public final class SessionUtil {

	/**
	 * static product string.
	 */
	private static final String PRODUCTS = "products";
	
	
	/**
	 * log4j logger for this class.
	 */
	private static Logger logger = Logger.getLogger(SessionUtil.class.getName());

	/**
	 * static user string.
	 */
	private static final String USER = "user";
	
	/**
	 * static cart string.
	 */
	private static final String CART = "cart";

	/**
	 * static elementsize.
	 */
	private static final String ELEMENTSIZE = "elementSize";

	/**
	 * static list reference type for arrayList Cart object type.
	 */
	static private List<Cart> carts = new ArrayList<Cart>();

	/**
	 * set user in session.
	 * @param session httpSession
	 * @param user user.
	 */
	public static final void setUserName(HttpSession session, User user) {
		session.setAttribute(USER, user);
	}

	/**
	 * session userGetter.
	 * @param session HttpSession
	 */
	public static final void getUserName(HttpSession session) {
		session.getAttribute(USER);
	}

	/**
	 * add product to cart.
	 * @param session HttpSession.
	 * @param productId product identity.
	 */
	public static final void setProductToCart(HttpSession session, int productId) {
		logger.info("Set product to Cart");

		logger.info("product to Cart - getProducts(session)");
		Product productIndeed = null;

		logger.info("session product size: " + getProducts(session).size());

		for (Product product : getProducts(session)) {
			logger.info("<<< ide belép >>>");
			if (product.getId() == productId) {
				productIndeed = product;
				logger.info("product to Cart - find product");
				break;
			}
		}

		if (getCart(session) == null) {
			logger.info("product to Cart - getCart was null ");

			carts.add(new Cart(productIndeed));
			setCart(session, carts);
		} else {

			logger.info("product to cart else branch sessionGetCart size: " + getCart(session).size());

			boolean support = true;
			for (Cart cart : getCart(session)) {

				if (cart.equalsProductId(productIndeed)) {
					cart.incrementQuantity();
					logger.info("product to Cart - cartList has indeedProduct ");
					support = false;
					break;
				}
			}

			if (support) {
				carts.add(new Cart(productIndeed));
				setCart(session, carts);
				logger.info("product to Cart - cartList has not indeedProduct ");
			}

		}

	}

	/**
	 * this function refresh cart with a new product value.
	 * @param productId product identity.
	 * @param value new value.
	 * @param session HttpSession.
	 */
	public static final void refreshCart(int productId, int value, HttpSession session) {

		if (value > 0) {
			List<Cart> carts = getCart(session);

			for (Cart cart : carts) {
				if (cart.getCartElement().getProduct().getId() == productId) {
					cart.getCartElement().setQuantity(value);
				}
			}

			setCart(session, carts);
		} else {
			deleteCartElement(session, productId);
		}

	}

	/**
	 * this function return all carts.
	 * @param session Httpsession
	 * @return all carts from session.
	 * @throws NullPointerException if empty cart session.
	 */
	public static final List<Cart> getCart(HttpSession session) throws NullPointerException {
		logger.info("Get cart from session.");
		return (List<Cart>) session.getAttribute(CART);

	}

	/**
	 * product setter in session.
	 * @param session HttpSession.
	 * @param products product.
	 */
	public static final void setProducts(HttpSession session, List<Product> products) {
		logger.info("Set products to session.");
		session.setAttribute(PRODUCTS, products);
	}

	/**
	 * this function return all product in list from  product session.
	 * @param session HttpSession.
	 * @return all products from session.
	 */
	public static final List<Product> getProducts(HttpSession session) {
		logger.info("Get products from session.");
		return (List<Product>) session.getAttribute(PRODUCTS);
	}

	/** cart session setter.
	 * @param session 	HttpSession.
	 * @param carts Carts.
	 */
	public static final void setCart(HttpSession session, List<Cart> carts) {
		session.setAttribute(CART, carts);
	}

	/**
	 * delete elem from cart.
	 * @param session HttpSession
	 * @param productId product identity.
	 */
	public static final void deleteCartElement(HttpSession session, int productId) {
		logger.info("start remove product from Cart");

		List<Cart> sessionCarts = getCart(session);
		logger.info("product to Cart - getProducts(session)");

		for (Cart cart : sessionCarts) {
			logger.info("product to Cart - in foreach");
			if (cart.getCartElement().getProduct().getId() == productId) {
				sessionCarts.remove(cart);
				logger.info("product to Cart - find product");
				break;
			}
		}

		setCart(session, sessionCarts);

	}

	/**
	 * cart elements size getter.
	 * @param session HttpSession.
	 * @return cartsElementSize.
	 */
	public static final int getCartsElementSize(HttpSession session) {

		List<Cart> carts = getCart(session);
		int result = 0;

		for (Cart cart : carts) {
			result += cart.getQuantity();
		}

		return result;

	}

	/**
	 * set cart element size.
	 * @param session HttpSession
	 */
	public static final void setCartsElementSize(HttpSession session) {
		session.setAttribute(ELEMENTSIZE, getCartsElementSize(session));
	}

}
