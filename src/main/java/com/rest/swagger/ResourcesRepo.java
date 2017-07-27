/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.swagger;

import com.rest.swagger.model.Building;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author Praneeth Madusanka
 */
public interface ResourcesRepo extends MongoRepository<Building, String> {

    @Query(value = "{ 'name' : ?0 }")
    List<Building> findByTheBuildingFirstname(String like);

}
