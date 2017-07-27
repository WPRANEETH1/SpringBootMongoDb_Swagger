/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.swagger.dao.impl;

import com.rest.swagger.ResourcesRepo;
import com.rest.swagger.dao.ResourcesDao;
import com.rest.swagger.model.Building;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Praneeth Madusanka
 */
@Service
public class ResourcesDaoImpl implements ResourcesDao {

    @Autowired
    private ResourcesRepo resourcesRepo;

    @Override
    public Building createResources(Building resources) {
        return resourcesRepo.save(resources);
    }

    @Override
    public ResponseEntity<Building> updateResources(String id, Building resources) {
        Building findResources = resourcesRepo.findOne(id);
        if (findResources == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        findResources.setName(resources.getName());
        findResources.setAddress(resources.getAddress());
        findResources.setFloor(resources.getFloor());
        Building updateResources = resourcesRepo.save(findResources);
        return new ResponseEntity<>(updateResources, HttpStatus.OK);
    }
//    @Override
//    public void deleteResources(String id) {
//        resourcesRepo.delete(id);
//    }

    @Override
    public Building getResourceById(String id) {
        return resourcesRepo.findOne(id);
    }

    @Override
    public List<Building> getAllResources(String like) {
//        Sort sortByname = new Sort(Sort.Direction.DESC, "name");
        return resourcesRepo.findByTheBuildingFirstname(like);
    }

}
