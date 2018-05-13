package com.unideb.beadando;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  this is an entrance class.
 */
@SpringBootApplication
public class DemoApplication {
	/**
	 * this is an entrance main function.
	 * @param args is arguments for this application which are load when your program is loaded
	 */
	public static void main(String... args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
