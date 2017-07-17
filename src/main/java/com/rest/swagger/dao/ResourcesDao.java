/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.swagger.dao;

import com.rest.swagger.model.Resources;
import java.util.List;
import org.json.simple.JSONArray;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Praneeth Madusanka
 */
public interface ResourcesDao {

    public Resources createResources(Resources resources);

    public ResponseEntity<Resources> updateResources(String id, Resources resources);

    public void deleteResources(String id);

    public Resources getResourceById(String name);

    public List<Resources> getAllResources();
}
