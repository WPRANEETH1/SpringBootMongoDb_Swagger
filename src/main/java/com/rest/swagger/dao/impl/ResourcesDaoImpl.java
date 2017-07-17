/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.swagger.dao.impl;

import com.rest.swagger.ResourcesRepo;
import com.rest.swagger.dao.ResourcesDao;
import com.rest.swagger.model.Resources;
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
    public Resources createResources(Resources resources) {
        return resourcesRepo.save(resources);
    }

    @Override
    public ResponseEntity<Resources> updateResources(String id, Resources resources) {
        Resources findResources = resourcesRepo.findOne(id);
        if (findResources == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        findResources.setAddress(resources.getAddress());
        findResources.setType(resources.getType());
        Resources updateResources = resourcesRepo.save(findResources);
        return new ResponseEntity<>(updateResources, HttpStatus.OK);
    }

    @Override
    public void deleteResources(String id) {
        resourcesRepo.delete(id);
    }

    @Override
    public Resources getResourceById(String id) {
        return resourcesRepo.findOne(id);
    }

    @Override
    public List<Resources> getAllResources() {
        Sort sortByname = new Sort(Sort.Direction.DESC, "name");
        return resourcesRepo.findAll(sortByname);
    }

}
