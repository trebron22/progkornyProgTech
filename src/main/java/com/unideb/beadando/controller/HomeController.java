package com.unideb.beadando.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.unideb.beadando.jsps.JSPS;
import com.unideb.beadando.model.Product;
import com.unideb.beadando.model.User;
import com.unideb.beadando.service.IProductService;
import com.unideb.beadando.service.IUserService;
import com.unideb.beadando.util.SessionUtil;

/**
 * this is a rest home controller.
 * @author gagyi.norbert
 *
 */
@RestController
public class HomeController {

	/**
	 * this is a static log4j for this controller.
	 */
	static Logger logger = Logger.getLogger(HomeController.class.getName());

	/**
	 * this is a productservice interface interface.
	 */
	@Autowired
	IProductService productService;
	
	/**
	 * userService is injected.
	 */
	@Autowired
	private IUserService userService;
	

	/**
	 * this function load the index page and the products.
	 * @param session HttpSession.
	 * @param response HttpServletResponse.
	 * @return the index jsp and the products.
	 * @throws SQLException if the sqls wrong.
	 * @throws JsonProcessingException if something wrong with json parse.
	 */
	@RequestMapping(value = "/")
	public ModelAndView showIndex(HttpSession session, HttpServletResponse response)
			throws SQLException, JsonProcessingException {
		logger.info("< < < start show index showindex() > > >");
		logger.info("<<>>><<<>>><<<<>>><<<>>><<<>>>");
		logger.info("Session id: " + session.getId());
		
		Authentication auth = null;
		
		if( !SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser")) {
			System.out.println("<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>" + SecurityContextHolder.getContext().getAuthentication().getName());
			auth = SecurityContextHolder.getContext().getAuthentication();
			User user = userService.getUserByUsername(auth.getName());
			logger.info("Success log in");
			SessionUtil.setUserName(session, user);
		}

		List<Product> products = productService.getProducts();

		SessionUtil.setProducts(session, products);

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(products.get(0));

		

		response.addCookie(new Cookie("lastThreeItem", ""));

		ModelAndView mv = new ModelAndView(JSPS.INDEX.getJsp());
		mv.addObject("basket", SessionUtil.getCart(session));

		return mv;
	}
	
}
