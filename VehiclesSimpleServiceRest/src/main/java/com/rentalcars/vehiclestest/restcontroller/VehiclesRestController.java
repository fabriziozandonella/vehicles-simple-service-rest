/**
 * 
 */
package com.rentalcars.vehiclestest.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rentalcars.vehiclestest.restcontroller.exclusionstrategies.ExclusionStrategyPriceImpl;
import com.rentalcars.vehiclestest.restcontroller.exclusionstrategies.ExclusionStrategyRatingImpl;
import com.rentalcars.vehiclestest.restcontroller.exclusionstrategies.ExclusionStrategyScoreImpl;
import com.rentalcars.vehiclestest.restcontroller.exclusionstrategies.ExclusionStrategySippImpl;
import com.rentalcars.vehiclestest.service.VehiclesService;

/**
 * @author Fabrizio Zandonella
 *
 */
@RestController
@RequestMapping("/vehicles") 
public class VehiclesRestController{

	@Autowired
	VehiclesService vehiclesService;

	@RequestMapping(value = "/getVehiclesOrderByPrice", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getVehiclesListOrderByPrice() throws Exception {		 

		Gson gson = new GsonBuilder().setExclusionStrategies(new ExclusionStrategyPriceImpl()).create();

		return gson.toJson(vehiclesService.getVehiclesListOrderByPrice());
	}

	@RequestMapping(value = "/getVehiclesListSippDetailed", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getVehiclesListSippDetailed() throws Exception {

		Gson gson = new GsonBuilder().setExclusionStrategies(new ExclusionStrategySippImpl()).create();

		return gson.toJson(vehiclesService.getVehiclesListSippDetailed());
	}

	@RequestMapping(value = "/getVehiclesListHighestRated", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getVehiclesListHighestRated() throws Exception {

		Gson gson = new GsonBuilder().setExclusionStrategies(new ExclusionStrategyRatingImpl()).create();

		return gson.toJson(vehiclesService.getVehiclesListHighestRated());
	}	

	@RequestMapping(value = "/getVehiclesListOrderByTotalScore", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getVehiclesListOrderByTotalScore() throws Exception {

		Gson gson = new GsonBuilder().setExclusionStrategies(new ExclusionStrategyScoreImpl()).create();

		return gson.toJson(vehiclesService.getVehiclesListOrderByTotalScore());
	}	
	
	
	
    
	
}
