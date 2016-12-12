/*
 * @Copyright 2016 - Infinite Aspects, All rights reserved
 */

/**
 * Main Pet Store Controller
 */
package com.infaspects.petstore.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.infaspects.petstore.model.Pet;
import com.infaspects.petstore.repository.PetStoreRepository;

@RestController
@RequestMapping(path="/pet")
public class PetStoreController {
	
	private final Logger logger = LoggerFactory.getLogger(PetStoreController.class);
	
	private PetStoreRepository repository;

	/**
	 * View all pets
	 * 
	 * @return
	 */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Pet>> getAllPets(){
    	logger.debug("GET Request to get all pets");
        return new ResponseEntity<>((Collection<Pet>) repository.findAll(), HttpStatus.OK);
    }
    
    /**
     * Add a new pet
     * 
     * @param pet
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Pet> addPet(@Valid @RequestBody Pet pet) {
    	logger.debug("POST Request for adding pet "+pet.getName());
        return new ResponseEntity<Pet>(repository.save(pet), HttpStatus.CREATED);
    }
    
    /**
     * Find pet by ID
     * 
     * @param id
     * @return
     */
    @RequestMapping(path="/{id}", method=RequestMethod.GET)
    public ResponseEntity<?> findByID(@PathVariable Integer id) {
    	logger.debug("Requesting pet with id "+id);
    	ResponseEntity<Pet> responseEntity = null;
    	
    	try {
    		Pet pet = repository.findOne(id);
        	if (null != pet) {
        		logger.debug("pet with id "+id+" found");
        		responseEntity = new ResponseEntity<Pet>(pet, HttpStatus.OK);
        	} else {
        		logger.debug("pet with id "+id+" not found");
        		responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        	}
    	} catch (Exception e){
    		logger.error("Exception occured when finding pet by "+id, e.getMessage());
    	}

    	return responseEntity;
    }
    
    /**
     * Delete pet by ID
     * 
     * @param id
     * @return
     */
    @SuppressWarnings("rawtypes")
	@RequestMapping(path="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity deleteByID(@PathVariable Integer id) {
    logger.debug("delete pet with id "+id);
   	ResponseEntity responseEntity = null;
    	
    	try {
    		Pet pet = repository.findOne(id);
        	if (null != pet) {
        		logger.debug("pet with id "+id+" found");
        		repository.delete(id);
        		responseEntity = new ResponseEntity(HttpStatus.OK);
        	} else {
        		logger.debug("pet with id "+id+" not found");
        		responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        	}
    	} catch (Exception e){
    		logger.error("Exception occured when deleting pet by "+id, e.getMessage());
    	}

    	return responseEntity;
    }
    
    
    @ExceptionHandler( MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
    protected void handleDMSRESTException(MethodArgumentNotValidException objException) {

    }
}
