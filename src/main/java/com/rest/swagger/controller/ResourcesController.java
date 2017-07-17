package com.rest.swagger.controller;

import com.rest.swagger.dao.ResourcesDao;
import com.rest.swagger.model.Resources;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController("/resources")
public class ResourcesController {

    private ResourcesDao resourcesDao;

    @Autowired
    public void setResourcesDao(ResourcesDao resourcesDao) {
        this.resourcesDao = resourcesDao;
    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public Resources getResource(@PathVariable("id") String id) {
        return resourcesDao.getResourceById(id);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Resources> getAllResource() {
        return resourcesDao.getAllResources();
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteResource(@PathVariable("id") String id) {
        resourcesDao.deleteResources(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public Resources createResources(@RequestBody Resources resources, HttpServletRequest request) {
        return resourcesDao.createResources(resources);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Resources> updateResources(@PathVariable("id") String id, @RequestBody Resources resources, HttpServletRequest request) {
        return resourcesDao.updateResources(id, resources);
    }
}
