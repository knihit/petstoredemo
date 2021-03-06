package com.infaspects.petstore.model.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import com.infaspects.petstore.model.Category;
import com.infaspects.petstore.model.Pet;
import com.infaspects.petstore.model.PhotoUrl;
import com.infaspects.petstore.model.Status;
import com.infaspects.petstore.model.Tag;
import com.infaspects.petstore.repository.PetStoreRepository;

@RunWith(SpringRunner.class)
@EnableJpaRepositories(basePackages={"com.infaspects.petstore.repository"})
@EntityScan(basePackages={"com.infaspects.petstore.model"})
@Transactional
public class PetStoreRepositoryTest {
	
	@Autowired
	public PetStoreRepository petStoreRepository;
	
	@Test
	public void addPet() {
		
		//Pet 1
		Set<PhotoUrl> photoUrkSet = new HashSet<PhotoUrl>();
		photoUrkSet.add(new PhotoUrl("www.google.com"));
		
		Set<Tag> tagSet = new HashSet<Tag>();
		tagSet.add(new Tag("Sweety"));
		
		Pet pet = new Pet(new Category("Dog"), "Spiky", photoUrkSet, tagSet, Status.AVAILABLE);
		petStoreRepository.save(pet);
		
		//get the added pet
		Pet retrievedPet = petStoreRepository.findOne(pet.getId());
		assertEquals(pet.toString(), retrievedPet.toString());
	}

	@Test
	public void deletePet() {
		Set<PhotoUrl> photoUrkSet = new HashSet<PhotoUrl>();
		photoUrkSet.add(new PhotoUrl("www.google.com"));
		
		Set<Tag> tagSet = new HashSet<Tag>();
		tagSet.add(new Tag("Pumpkin"));
		
		Pet pet = new Pet(new Category("Cat"), "Tiny", photoUrkSet, tagSet, Status.AVAILABLE);
		petStoreRepository.save(pet);
		
		Pet retrievedPet = petStoreRepository.findOne(pet.getId());
		
		//delete the pet
		petStoreRepository.delete(pet.getId());
		retrievedPet = petStoreRepository.findOne(pet.getId());
		assertNull(retrievedPet);
	}
	
}
