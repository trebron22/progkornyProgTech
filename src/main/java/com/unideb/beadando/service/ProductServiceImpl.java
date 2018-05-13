package com.unideb.beadando.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unideb.beadando.model.Cart;
import com.unideb.beadando.model.Product;
import com.unideb.beadando.repository.ProductJpaDao;

/**
 * product service implementation.
 * @author gagyi.norbert
 *
 */
@Service
public class ProductServiceImpl implements IProductService {

	/**
	 * static log4j logger for this class.
	 */
	static Logger logger = Logger.getLogger(ProductServiceImpl.class.getName());

	/**
	 * productJpaDao with inject.
	 */
	@Autowired
	ProductJpaDao productJpaDao;

	@Override
	public List<Product> getProducts() {
		logger.info("Get products from database.");
		return productJpaDao.getAllProduct();
	}

	@Override
	public Product getProductById(int id) {

		return productJpaDao.getProductById(id);
	}

	@Override
	public boolean hasOffer(List<Cart> carts) {
		int sumPrices = 0;

		for (Cart cart : carts) {
			sumPrices += cart.getPrice();
		}
		
		if(sumPrices >= 3000) return true;
		if(hasWomanThings(carts)) return true;
		return false;
	}
	
	public int getPrice(List<Cart> carts) {
		int sum = 0;	
		for(Cart cart : carts) {
			sum += cart.getPrice();
		}
		return sum;
	}

	@Override
	public int finallyPrice(List<Cart> carts) {
		int sumPrices = getPrice(carts);
		int priceWith0_95percentWhenSumPriceIsMoreThan3000 = Integer.MAX_VALUE;
		int priceForWomanThings = Integer.MAX_VALUE;
		if (hasOffer(carts)) {
			priceWith0_95percentWhenSumPriceIsMoreThan3000 = (int) (sumPrices * 0.95);
		}
		if(hasWomanThings(carts)) {
			priceForWomanThings = (int) (sumPrices * 0.75);
		}
		
		if(priceWith0_95percentWhenSumPriceIsMoreThan3000 > priceForWomanThings ) return priceForWomanThings;
		if( priceWith0_95percentWhenSumPriceIsMoreThan3000 < priceForWomanThings ) return priceWith0_95percentWhenSumPriceIsMoreThan3000;
		return  sumPrices;
	}

	@Override
	public boolean hasWomanThings(List<Cart> carts) {
		logger.info("start hasWoman...");
		for(Cart cart: carts) {
			logger.info(cart.getCartElement().getProduct().getFilter() );
			if(cart.getCartElement().getProduct().getFilter().equals("women")) {
				logger.info("has a woman thing");
				return true;
			}
		}
		return false;
	}

}
