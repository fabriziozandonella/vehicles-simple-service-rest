/**
 * 
 */
package com.rentalcars.vehiclestest.backend;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.rentalcars.vehiclestest.model.Sipp;
import com.rentalcars.vehiclestest.model.SippCodes;
import com.rentalcars.vehiclestest.model.SippSpecMaps;
import com.rentalcars.vehiclestest.model.Vehicle;

/**
 * @author Fabrizio Zandonella
 *
 */
public class DataManagerImpl implements DataManager{
	private Logger logger = LogManager.getLogger(DataManagerImpl.class);
	
	private ArrayList<Vehicle> vehiclesList;
	
	private HashMap<SippCodes.CarType, String> carTypeMap = null;
	private HashMap<SippCodes.DoorsCarType, String> doorsCarTypeMap = null;
	private HashMap<SippCodes.Transmission, String> transmissionMap = null;
	private HashMap<SippCodes.FuelAC, String> fuelAcMap = null;

    /**
     * Constructor 
     * loading of SIPP specifications (view ApplicationConfig)
     * @param sippSpecMaps
     */
	public DataManagerImpl(SippSpecMaps sippSpecMaps){
		this.carTypeMap = sippSpecMaps.getCarTypeMap();
		this.doorsCarTypeMap = sippSpecMaps.getDoorsCarTypeMap();
		this.transmissionMap = sippSpecMaps.getTransmissionMap();
		this.fuelAcMap = sippSpecMaps.getFuelAcMap();

	}
	@Override
	public HashMap<SippCodes.CarType, String> getCarTypeMap() {
		return carTypeMap;
	}

	@Override
	public HashMap<SippCodes.DoorsCarType, String> getDoorsCarTypeMap() {
		return doorsCarTypeMap;
	}

	@Override
	public HashMap<SippCodes.Transmission, String> getTransmissionMap() {
		return transmissionMap;
	}

	@Override
	public HashMap<SippCodes.FuelAC, String> getFuelAcMap() {
		return fuelAcMap;
	}


	@Override
	public ArrayList<Vehicle> getVehiclesList() {
		return vehiclesList;
	}

	private void setVehiclesList(ArrayList<Vehicle> vehiclesList) {
		this.vehiclesList = vehiclesList;
	}

	/**
	 * JSON parser usign GSON library. 
	 * the parameter provides the path of the JSON file.
	 * Vehicles object is created from the JSON and VehiclesList
	 * setted.
	 * 
	 * @param path 
	 */
	@Override
	public void jsonParser(String path) {

		JSONParser parser = new JSONParser();
		JSONObject jsonObject;
		try{

			jsonObject = (JSONObject) parser.parse(new FileReader(path));

			Vehicles vehicles =  new Gson().fromJson(jsonObject.toJSONString(), Vehicles.class);

			setVehiclesList(vehicles.getSearch().getVehicleList());

			logger.info("File: " + path + " loaded");
		} catch (IOException | ParseException e) {
			logger.error(e.getMessage());
		}

	}

	/**
	 * Converts the sipp String verifying the correctness of the data  .
	 * through carTypeValidator, doorsCarTypeValidator, transmissionValidator fuelAcValidator
	 * sets the informations. 
	 * In case of IllegalArgumentException, The assumption is to load a default value 
	 * SippCodes.NOT_FOUND
	 * 
	 * @param sipp
	 */
	@Override
	public Sipp sippConverter(String sipp) throws Exception {
		if(null == sipp ){
			logger.error("SIPP is null");
			throw new Exception("SIPP is null");
		}
		if(sipp.length()!=4 ){
			logger.error("SIPP has " + sipp.length() + " characters, requested 4");
			throw new Exception("SIPP has " + sipp.length() + " characters, requested 4");
		}
		if(null == this.carTypeMap){
			logger.error("Specification of the vehicles null");
			throw new Exception("Specification of the vehicles null");
		}
		if(this.carTypeMap.isEmpty()){
			logger.error("Specification of the vehicles empty");
			throw new Exception("Specification of the vehicles empty");
		}		

		Sipp s = new Sipp();

		String ctype = String.valueOf(sipp.charAt(0));
		String ctypeDoors = String.valueOf(sipp.charAt(1));
		String transmission =String.valueOf(sipp.charAt(2));
		String fuelAc = String.valueOf(sipp.charAt(3));
		int scoreTransmission = 0;
		int scoreAC = 0;

			s.setCarType(carTypeValidator(ctype));
			s.setCarTypeDoors(doorsCarTypeValidator(ctypeDoors));
			s.setTransmission(transmissionValidator(transmission));

			if(!s.getTransmission().equalsIgnoreCase(SippCodes.NOT_FOUND)){
				scoreTransmission = SippCodes.Transmission.valueOf(transmission).score();
			}
			if(!fuelAcValidator(fuelAc).equalsIgnoreCase(SippCodes.NOT_FOUND)){
				String[] fa = SippCodes.FuelAC.valueOf(fuelAc).fuelAC().split("/");
				s.setFuel(fa[0]);
				s.setAc(fa[1]);
				scoreAC = SippCodes.FuelAC.valueOf(fuelAc).score();
			}else{
				s.setFuel(SippCodes.NOT_FOUND);
				s.setAc(SippCodes.NOT_FOUND);
			}
			s.setScore(scoreTransmission + scoreAC);

		return s;
	}

	private String carTypeValidator(String s){
		try{
			return this.carTypeMap.get(SippCodes.CarType.valueOf(s));
		} catch (IllegalArgumentException e) {
			return SippCodes.NOT_FOUND;
		}
	}
	private String doorsCarTypeValidator(String s){
		try{
			return this.doorsCarTypeMap.get(SippCodes.DoorsCarType.valueOf(s));
		} catch (IllegalArgumentException e) {
			return SippCodes.NOT_FOUND;
		}
	}

	private String transmissionValidator(String s){
		try{
			return this.transmissionMap.get(SippCodes.Transmission.valueOf(s));
		} catch (IllegalArgumentException e) {
			return SippCodes.NOT_FOUND;
		}
	}
	private String fuelAcValidator(String s){
		try{
			return this.fuelAcMap.get(SippCodes.FuelAC.valueOf(s));
		} catch (IllegalArgumentException e) {
			return SippCodes.NOT_FOUND;
		}
	}	

	/**
	 * 	Prints a list of all the cars, in ascending price order.
	 */
	@Override
	public ArrayList<Vehicle> getVehiclesListOrderByPrice() {

		ArrayList<Vehicle> vehicle = getVehiclesList();

		Collections.sort(vehicle, new Comparator<Vehicle>() {
			public int compare(Vehicle o1, Vehicle o2) {
				return Double.compare(o2.getPrice(), o1.getPrice());
			}
		});

		return vehicle;
	}

	/**
	 * Calculates the specification of the vehicles based on their SIPP
	 */
	@Override
	public ArrayList<Vehicle> getVehiclesListSippDetailed() throws Exception {

		ArrayList<Vehicle> vehicle = getVehiclesList();
		for(Vehicle v : vehicle){

				try {
					v.setSippObj(sippConverter(v.getSipp()));
				} catch (Exception e) {
					logger.error(e.getMessage());
				}
		}
		return vehicle;
	}

	/**
	 * Prints out the highest rated supplier per car type, descending order.
	 */
	@Override
	public ArrayList<Vehicle> getVehiclesListHighestRated() throws Exception {
		ArrayList<Vehicle> vehicle = getVehiclesList();

		Collections.sort(vehicle, new Comparator<Vehicle>() {
			public int compare(Vehicle o1, Vehicle o2) {
				String s1 = String.valueOf(o1.getSipp().charAt(0));
				String s2 = String.valueOf(o2.getSipp().charAt(0));			 
				if (s1.equalsIgnoreCase(s2)){
					return Double.compare(o2.getRating(), o1.getRating());
				}				 
				return s1.compareToIgnoreCase(s2);

			}
		});

		for(Vehicle v : vehicle){

			try {
				v.setSippObj(sippConverter(v.getSipp()));
			} catch (Exception e) {
				logger.error(e.getMessage());
			}

		}
		return vehicle;
	}

	/**
	 * Gives each vehicle a score based on the info implemented into SippCodes object, 
	 * then combines this score with the suppliers rating. Returns a list of vehicles, 
	 * ordered by the sum of the scores in descending order
	 * 
	 */
	@Override
	public ArrayList<Vehicle> getVehiclesListOrderByTotalScore() {
		ArrayList<Vehicle> vehicle = getVehiclesList();
		ArrayList<Vehicle> vScore = new ArrayList<>();
		for(Vehicle v : vehicle){
			Vehicle vs = new Vehicle();
			try {
				v.setSippObj(sippConverter(v.getSipp()));
				v.setTotalScore(v.getSippObj().getScore() + v.getRating());	
				
				vs.setName(v.getName());
				vs.setSippObj(v.getSippObj());
				vs.setRating(v.getRating());
				vs.setTotalScore(v.getTotalScore());
				vScore.add(vs);

			} catch (Exception e) {
				logger.error(e.getMessage());
			}

		}

		Collections.sort(vScore, new Comparator<Vehicle>() {
			public int compare(Vehicle o1, Vehicle o2) {
				return Double.compare(o2.getTotalScore(), o1.getTotalScore());
			}
		});
		return vScore;
	}

}

/**
 * 
 * @author Fabrizio Zandonella
 * Class to map the JSON structure
 */
class Vehicles {
	@SerializedName("Search")
	private VehicleList search;

	public VehicleList getSearch() {
		return search;
	}
}
/**
 * 
 * @author Fabrizio Zandonella
 * Class to map the JSON structure
 */
class VehicleList {
	@SerializedName("VehicleList")
	private ArrayList<Vehicle> vehicleList;

	public ArrayList<Vehicle> getVehicleList() {
		return vehicleList;
	}
}
