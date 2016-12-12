package com.infaspects.petstore.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.infaspects.petstore.boot.PetStoreApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT, classes = PetStoreApplication.class)
@EnableJpaRepositories(basePackages={"com.infaspects.petstore.repository"})
public class PetStoreControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void getPet() throws Exception {
    	 ResponseEntity<?> responseEntity = this.restTemplate.getForEntity("/pet/1", String.class);
    	 responseEntity.getBody();
    }
}
