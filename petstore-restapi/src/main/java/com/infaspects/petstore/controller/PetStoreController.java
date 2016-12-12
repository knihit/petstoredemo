/*
 * @Copyright 2016 - Infinite Aspects, All rights reserved
 */

/**
 * Main Pet Store Controller
 */
package com.infaspects.petstore.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infaspects.petstore.model.Pet;
import com.infaspects.petstore.repository.PetStoreRepository;

@RestController
@RequestMapping("/pet")
public class PetStoreController {
	
	@Autowired
	private PetStoreRepository repository;

	/**
	 * View all pets
	 * 
	 * @return
	 */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Pet>> getAllPets(){
        return new ResponseEntity<>((Collection<Pet>) repository.findAll(), HttpStatus.OK);
    }
    
    /**
     * Add a new pet
     * 
     * @param pet
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Pet> addPet(@RequestBody Pet pet) {
        return new ResponseEntity<Pet>(repository.save(pet), HttpStatus.CREATED);
    }
    
    /**
     * Find pet by ID
     * 
     * @param id
     * @return
     */
    @RequestMapping(path="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Pet> findByID(@PathVariable Integer id) {
    	return new ResponseEntity<Pet>(repository.findOne(id), HttpStatus.OK);
    }
    
    /**
     * Delete pet by ID
     * 
     * @param id
     * @return
     */
    @RequestMapping(path="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<?> deleteByID(@PathVariable Integer id) {
    	repository.delete(id);
    	return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
