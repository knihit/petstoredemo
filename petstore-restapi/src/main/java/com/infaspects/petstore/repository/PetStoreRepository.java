/*
 * @Copyright 2016 - Infinite Aspects, All rights reserved
 */

package com.infaspects.petstore.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infaspects.petstore.model.Pet;

@Transactional
@Repository
public interface PetStoreRepository extends CrudRepository<Pet, Integer> {

}
