package com.example.product.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.model.Cart;
import com.example.demo.model.CartElement;
import com.example.demo.model.Product;
import com.example.demo.service.IProductService;
import com.example.demo.util.SessionUtil;

/**
 * product service test.
 * 
 * @author gagyi.norbert
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = com.example.demo.DemoApplication.class)
// @ContextConfiguration
@ComponentScan({ "com.example.demo.*" })
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductDaoImplTest {

	/**
	 * productService is injected.
	 */
	@Autowired
	IProductService productService;
	
	 @Autowired
	 MockHttpSession session;

	/**
	 * support test this cart list.
	 */
	List<Cart> carts = new ArrayList<Cart>();

	/**
	 * getProduct test this test is test hot getProducts return some products.
	 */
	@Test
	public void getProductTest() {
		assertNotNull(productService.getProducts());
	}

	/**
	 * this function test how to getProductById method return a correct product.
	 */
	@Test
	public void getProductByIDTest() {
		List<Product> products = productService.getProducts();
		int id = products.get(0).getId();
		assertNotNull(productService.getProductById(id));
	}

	/**
	 * this function test that when price is over then 3000 exist discount.
	 */
	@Test
	public void hasOfferTestPrice3000() {
		
		List<Product> products = productService.getProducts();
		int id = products.get(0).getId();
		
		Product product = productService.getProductById(id);
		product.setPrice(3000);
		Cart cart01 = new Cart(product);
		carts.add(cart01);
		assertTrue(productService.hasOffer(carts));
	}
	
	/**
	 * this function test that when price is lower then 3000 not exist discount.
	 */
	@Test
	public void hasOfferTestPrice2999() {
		
		List<Product> products = productService.getProducts();
		int id = products.get(0).getId();
		
		Product product = productService.getProductById(id);
		product.setPrice(2999);
		Cart cart01 = new Cart(product);
		carts.add(cart01);
		assertFalse(productService.hasOffer(carts));
	}
	
	/**
	 * this function test that when discount is not exist the finally price correct.
	 */
	@Test
	public void finallyPriceTest() {
		List<Product> products = productService.getProducts();
		int id = products.get(0).getId();
		
		Product product = productService.getProductById(id);
		product.setPrice(2999);
		Cart cart01 = new Cart(product);
		carts.add(cart01);
		
		assertEquals(2999, productService.finallyPrice(carts));
	}
	
	/**
	 * this function test that discount exist and finally price correct you get the discount.
	 */
	@Test
	public void finallyPriceTest01() {
		List<Product> products = productService.getProducts();
		int id = products.get(0).getId();
		
		Product product = productService.getProductById(id);
		product.setPrice(3000);
		Cart cart01 = new Cart(product);
		carts.add(cart01);
		
		assertEquals( 3000*0.95, productService.finallyPrice(carts),1 );
	}
	
	/**
	 * hasWomanThingTest with nothing.
	 */
	@Test(expected = NullPointerException.class )
	public void hasWomanThingsTest() {
		
		assertFalse( productService.hasWomanThings( SessionUtil.getCart(session) ) );
		
	}
	
	
	

}
