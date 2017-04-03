/**
 * 
 */
package com.rentalcars.vehiclestest.backend;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import com.rentalcars.vehiclestest.model.Sipp;
import com.rentalcars.vehiclestest.model.SippCodes;
import com.rentalcars.vehiclestest.model.Vehicle;

/**
 * @author Fabrizio Zandonella
 *
 */
public interface DataManager {

	public ArrayList<Vehicle> getVehiclesList();

	public Sipp sippConverter(String sipp) throws Exception;

	public void jsonParser(String path);

	public void jsonParser(URL url);

	public ArrayList<Vehicle> getVehiclesListOrderByPrice();

	public ArrayList<Vehicle> getVehiclesListSippDetailed() throws Exception;

	public ArrayList<Vehicle> getVehiclesListHighestRated() throws Exception;	

	public ArrayList<Vehicle> getVehiclesListOrderByTotalScore();


	public HashMap<SippCodes.CarType, String> getCarTypeMap();

	public HashMap<SippCodes.DoorsCarType, String> getDoorsCarTypeMap();

	public HashMap<SippCodes.Transmission, String> getTransmissionMap();

	public HashMap<SippCodes.FuelAC, String> getFuelAcMap();

}
