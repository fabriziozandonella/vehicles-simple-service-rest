/**
 * 
 */
package com.rentalcars.vehiclestest.model;

import java.util.HashMap;

/**
 * @author Fabrizio Zandonella
 *
 */
public class SippSpecMaps {
	
	private HashMap<SippCodes.CarType, String> carTypeMap;
	private HashMap<SippCodes.DoorsCarType, String> doorsCarTypeMap;
	private HashMap<SippCodes.Transmission, String> transmissionMap;
	private HashMap<SippCodes.FuelAC, String> fuelAcMap;
	
	public HashMap<SippCodes.CarType, String> getCarTypeMap() {
		return carTypeMap;
	}
	public void setCarTypeMap(HashMap<SippCodes.CarType, String> carTypeMap) {
		this.carTypeMap = carTypeMap;
	}
	public HashMap<SippCodes.DoorsCarType, String> getDoorsCarTypeMap() {
		return doorsCarTypeMap;
	}
	public void setDoorsCarTypeMap(HashMap<SippCodes.DoorsCarType, String> doorsCarTypeMap) {
		this.doorsCarTypeMap = doorsCarTypeMap;
	}
	public HashMap<SippCodes.Transmission, String> getTransmissionMap() {
		return transmissionMap;
	}
	public void setTransmissionMap(HashMap<SippCodes.Transmission, String> transmissionMap) {
		this.transmissionMap = transmissionMap;
	}
	public HashMap<SippCodes.FuelAC, String> getFuelAcMap() {
		return fuelAcMap;
	}
	public void setFuelAcMap(HashMap<SippCodes.FuelAC, String> fuelAcMap) {
		this.fuelAcMap = fuelAcMap;
	}

}
