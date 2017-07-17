/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.swagger;

import com.rest.swagger.model.Resources;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Praneeth Madusanka
 */
public interface ResourcesRepo extends MongoRepository<Resources, String> {

}
