package com.unideb.beadando.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.unideb.beadando.jsps.JSPS;
import com.unideb.beadando.model.User;

/**
 * this is a login controller.
 * @author gagyi.norbert
 *
 */
@Controller
public class LogInController {

	/**
	 * this is a static log4j logger in this controller.
	 */
	static Logger logger = Logger.getLogger(LogInController.class.getName());

	/**
	 * this function redirect you to log-in page.
	 * @return log-in page.
	 */
	@RequestMapping(value = "/log-in")
	public ModelAndView showLogInPage() {
		ModelAndView mv = new ModelAndView(JSPS.LOGIN.getJsp());	
		mv.addObject("user", new User());

		return mv;
	}

	
	/**
	 * log-out user.
	 * @param session HttpSession.
	 * @return log out user.
	 */
	@RequestMapping(value = "/log-out", method = RequestMethod.GET)
	public ModelAndView addToCard(HttpSession session) {

		session.removeAttribute("user");
		return new ModelAndView(JSPS.INDEX.getJsp());

	}
	
}
