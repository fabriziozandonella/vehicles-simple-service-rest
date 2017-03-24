/**
 * 
 */
package com.rentalcars.vehiclestest.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.rentalcars.vehiclestest.model.Vehicle;

/**
 * @author Fabrizio Zandonella
 *
 */

public interface VehiclesService {

	public ArrayList<Vehicle> getVehiclesListOrderByPrice() throws Exception;
	
	public ArrayList<Vehicle> getVehiclesListSippDetailed() throws Exception;
	
	public ArrayList<Vehicle> getVehiclesListHighestRated() throws Exception;	
	
	public ArrayList<Vehicle> getVehiclesListOrderByTotalScore() throws Exception;
	
	public void jsonParser(String path);
	
}
