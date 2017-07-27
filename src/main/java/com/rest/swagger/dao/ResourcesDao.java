/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.swagger.dao;

import com.rest.swagger.model.Building;
import java.util.List;
import org.json.simple.JSONArray;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Praneeth Madusanka
 */
public interface ResourcesDao {

    public Building createResources(Building resources);

    public ResponseEntity<Building> updateResources(String id, Building resources);
//
//    public void deleteResources(String id);

    public Building getResourceById(String name);

    public List<Building> getAllResources(String like);
}
