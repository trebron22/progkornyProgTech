package com.example.user.service.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.persistence.NoResultException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.unideb.beadando.service.IUserService;

/**
 * UserServiceTest class.
 * @author gagyi.norbert
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = com.unideb.beadando.DemoApplication.class)
// @ContextConfiguration
@ComponentScan({ "com.example.demo.*" })
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserServiceTest {

	/**
	 * userService interface injected.
	 */
	@Autowired
	IUserService userService;
	
	/**
	 * test correct username and password.
	 */
	@Test
	public void userLogInWithUsernameAndPassowrdTest() {
	
		assertTrue(userService.userLogInWithUsernameAndPassowrd("gagyinorbert", "tesztt"));
	}
	
	/**
	 * test fake username and password.
	 */
	@Test(expected = NoResultException.class)
	public void userLogInWithUsernameAndPassowrdTest01() {
		assertTrue(userService.userLogInWithUsernameAndPassowrd("fakeFoo", "fake") );
	}
}
