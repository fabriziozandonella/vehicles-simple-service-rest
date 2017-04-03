/**
 * 
 */
package com.rentalcars.vehiclestest.service;

import java.net.URL;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentalcars.vehiclestest.backend.DataManager;
import com.rentalcars.vehiclestest.model.Vehicle;

/**
 * @author Fabrizio Zandonella
 *
 */
@Service("vehiclesService")
public class VehiclesServiceImpl implements VehiclesService {

	@Autowired
	DataManager dataManager;
	
	/* (non-Javadoc)
	 * @see com.rentalcars.vehiclestest.service.VehiclesService#getVehiclesListOrderByPrice()
	 */
	@Override
	public ArrayList<Vehicle> getVehiclesListOrderByPrice() throws Exception {
		
		return dataManager.getVehiclesListOrderByPrice();
	}

	/* (non-Javadoc)
	 * @see com.rentalcars.vehiclestest.service.VehiclesService#getVehiclesListSippDetailed()
	 */
	@Override
	public ArrayList<Vehicle> getVehiclesListSippDetailed() throws Exception {
 
		return dataManager.getVehiclesListSippDetailed();
	}

	/* (non-Javadoc)
	 * @see com.rentalcars.vehiclestest.service.VehiclesService#getVehiclesListHighestRated()
	 */
	@Override
	public ArrayList<Vehicle> getVehiclesListHighestRated() throws Exception {
	 
		return dataManager.getVehiclesListHighestRated();
	}

	/* (non-Javadoc)
	 * @see com.rentalcars.vehiclestest.service.VehiclesService#getVehiclesListOrderByTotalScore()
	 */
	@Override
	public ArrayList<Vehicle> getVehiclesListOrderByTotalScore() throws Exception {
	 
		return dataManager.getVehiclesListOrderByTotalScore();
	}

	/* (non-Javadoc)
	 * @see com.rentalcars.vehiclestest.service.VehiclesService#jsonParser(java.lang.String)
	 */
	@Override
	public void jsonParser(String path) {
		//new URL(url)
		dataManager.jsonParser(path.trim().replaceAll("\\s", ""));  
		
	}

	/* (non-Javadoc)
	 * @see com.rentalcars.vehiclestest.service.VehiclesService#jsonParser(java.net.URL)
	 */
	@Override
	public void jsonParser(URL url)  {
		
		dataManager.jsonParser(url);  
	}

}
