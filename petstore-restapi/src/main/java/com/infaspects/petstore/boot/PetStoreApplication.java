/*
 * @Copyright 2016 - Infinite Aspects, All rights reserved
 */

/**
 * Main class to initialize boot application
 */

package com.infaspects.petstore.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class PetStoreApplication {
	
	public static final Logger logger = LoggerFactory.getLogger(PetStoreApplication.class);
	
	private static Class<PetStoreApplication> bootClass = PetStoreApplication.class;
	
	public static void  main (String args[]) {
		ApplicationContext ctx = SpringApplication.run(bootClass, args);
		
		String []beanNames = ctx.getBeanDefinitionNames();
		
		for (String beanName: beanNames) {
			logger.debug("loading "+beanName);
		}
	}
}

/**
 * Test controller to check Spring boot
 * 
 * @author angular
 *
 */
@RestController
class HelloController {
	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
}
