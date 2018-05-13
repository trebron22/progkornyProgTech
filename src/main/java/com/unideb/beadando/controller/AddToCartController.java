package com.unideb.beadando.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.unideb.beadando.model.Cart;
import com.unideb.beadando.service.IProductService;
import com.unideb.beadando.util.SessionUtil;

/**
 * this is a cart rest controller.
 * @author gagyi.norbert
 *
 */
@RestController
public class AddToCartController {

	/**
	 * this is a static log4j-s logger.
	 */
	static Logger logger = Logger.getLogger(AddToCartController.class.getName());
	/**
	 * this is the product service interface which is integrated its implementation.
	 */
	@Autowired
	IProductService productService;

	/**
	 * this function add to product to basket.
	 * @param productId this is the product identity.
	 * @param session this is the httpsession.
	 * @return carts element size
	 */
	@RequestMapping(value = "/addItemToBasket")
	public String addItemToBasket(@RequestParam int productId, HttpSession session) {
		logger.info("< < < Add item to basket > > >");
		logger.info("Session id: " + session.getId() + ", productId: " + productId);

		SessionUtil.setProductToCart(session, productId);
		SessionUtil.setCartsElementSize(session);

		return String.valueOf(SessionUtil.getCartsElementSize(session));
	}

	/**
	 * this function delete item from carts.
	 * @param productId product identity.
	 * @param session http session.
	 * @return the new carts which from delete @param productId.
	 */
	@RequestMapping(value = "/deleteItem")
	public List<Cart> deleteItemToBasket(int productId, HttpSession session) {
		SessionUtil.deleteCartElement(session, productId);
		SessionUtil.setCartsElementSize(session);

		return SessionUtil.getCart(session);
	}

	/**
	 * this function load a listbasket jsp with some models.
	 * @param session httpsession
	 * @return ModelAndView some model basket, offer, (int)fullPrice with listBasket view
	 */
	@RequestMapping(value = "/listBasket")
	public ModelAndView listBasket(HttpSession session) {

		ModelAndView mv = new ModelAndView("listBasket");

		if (SessionUtil.getCart(session) != null) {
			mv.addObject("basket", SessionUtil.getCart(session));

			mv.addObject("offer", productService.hasOffer(SessionUtil.getCart(session)));

			int fullPrice = productService.getPrice(SessionUtil.getCart(session));

			mv.addObject("fullPrice", fullPrice);
			mv.addObject("discountPrice", productService.finallyPrice( SessionUtil.getCart(session) ) );
		}
		return mv;

	}

	/**
	 * This function set a latest three viewed items in latestThreeProductCookie.
	 * @param productId product identity
	 * @param response HttpServletResponse for addCookie
	 * @return null because of processing.
	 */
	@RequestMapping(value = "/latestThreeProduct")
	public String latestThreeProduct(@RequestParam int productId, HttpServletResponse response) {
		logger.info("Add productId to cookie for view");

		response.addCookie(new Cookie("latestThreeProduct", String.valueOf(productId)));

		return null;
	}

	/**
	 * this function provide how you can change your items quantity.
	 * @param productId product identity
	 * @param value the new value.
	 * @param session httpsession.
	 * @return the new modified cart
	 */
	@RequestMapping(value = "/refreshBasket")
	public List<Cart> refreshBasket(@RequestParam int productId, @RequestParam int value, HttpSession session) {
		logger.info("< < < Add item to basket > > >");
		logger.info("Session id: " + session.getId() + ", productId: " + productId + " value " + value);

		SessionUtil.refreshCart(productId, value, session);
		SessionUtil.setCartsElementSize(session);

		return SessionUtil.getCart(session);
	}

}
