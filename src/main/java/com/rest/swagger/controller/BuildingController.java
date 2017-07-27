package com.rest.swagger.controller;

import com.rest.swagger.dao.ResourcesDao;
import com.rest.swagger.model.Building;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@Api(tags = "building")
@RestController
public class BuildingController extends HomeController {

    private ResourcesDao resourcesDao;

    @Autowired
    public void setResourcesDao(ResourcesDao resourcesDao) {
        this.resourcesDao = resourcesDao;
    }

    @ApiOperation(value = "Create building incl. floor names", nickname = "addBuilding")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "ID of newly created building data", response = Integer.class)
    })
    @RequestMapping(value = "/buildings", method = RequestMethod.POST)
    @ResponseBody
    public Building addBuilding(@ApiParam(value = "Building to add", required = true) @RequestBody Building resources, HttpServletRequest request) {
        return resourcesDao.createResources(resources);
    }

    @ApiOperation(value = "Update existing building in the DB", nickname = "updateBuilding")
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "updated", response = Void.class)
    })
    @RequestMapping(value = "/buildings/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Building> updateBuilding(@ApiParam(value = "ID of building to update", required = true) @RequestBody Building resources, @PathVariable("id") String id) {
        return resourcesDao.updateResources(id, resources);
    }

    @ApiOperation(value = "Get list of buildings with names like given pattern", nickname = "findBuildings")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Buildings list", response = Building.class)
    })
    @RequestMapping(value = "/buildings", method = RequestMethod.GET)
    @ResponseBody
    public List<Building> findBuildings(@ApiParam(value = "Pattern to match building names", required = true) @RequestParam("like") String like) {
        return resourcesDao.getAllResources(like);
    }

}
