package com.rentalcars;

import java.util.HashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.rentalcars.vehiclestest.backend.DataManager;
import com.rentalcars.vehiclestest.backend.DataManagerImpl;
import com.rentalcars.vehiclestest.model.SippCodes;
import com.rentalcars.vehiclestest.model.SippSpecMaps;
import com.rentalcars.vehiclestest.service.VehiclesService;
import com.rentalcars.vehiclestest.service.VehiclesServiceImpl;


/**
 * 
 * @author Fabrizio Zandonella
 *
 */
@Configuration
public class ApplicationConfig {

	@Bean(name="dataManager")
	public DataManager dataManager() {
		SippSpecMaps sippSpecMaps = new SippSpecMaps();
		
	    sippSpecMaps.setCarTypeMap(carTypeMap());
		sippSpecMaps.setDoorsCarTypeMap(doorsCarTypeMap());
		sippSpecMaps.setTransmissionMap(transmissionMap());
		sippSpecMaps.setFuelAcMap(fuelAcMap());

		return new DataManagerImpl(sippSpecMaps);
	}	

	@Bean(name="vehiclesService")
	@Scope("singleton")
	public VehiclesService vehiclesService() {
		return new VehiclesServiceImpl();
	}


	/*
		1st letter (car type)		2nd letter (doors/car type)		3rd letter (transmission)	4th letter (Fuel/Air Con)
		Letter	Value				Letter		Value				Letter	Value				Letter		Value
		M		Mini				B			2 doors				M		Manual				N			Petrol/no AC
		E		Economy				C			4 doors				A		Automatic			R			Petrol/AC
		C		Compact				D			5 doors				
		I		Intermediate		W			Estate				
		S		Standard			T			Convertible				
		F		Full size			F			SUV				
		P		Premium				P			Pick up				
		L		Luxury				V			Passenger Van				
		X		Special						

	 */

	//	private HashMap<SippCodes.FuelAC, SippCodes> fuelAcMap;
	private final HashMap<SippCodes.CarType, String> carTypeMap(){
		HashMap<SippCodes.CarType, String> carTypeMap = new HashMap<>();

		carTypeMap.put(SippCodes.CarType.M, SippCodes.CARTYPE_M);
		carTypeMap.put(SippCodes.CarType.E, SippCodes.CARTYPE_E);
		carTypeMap.put(SippCodes.CarType.C, SippCodes.CARTYPE_C);
		carTypeMap.put(SippCodes.CarType.I, SippCodes.CARTYPE_I);
		carTypeMap.put(SippCodes.CarType.S, SippCodes.CARTYPE_S);
		carTypeMap.put(SippCodes.CarType.F, SippCodes.CARTYPE_F);
		carTypeMap.put(SippCodes.CarType.P, SippCodes.CARTYPE_P);
		carTypeMap.put(SippCodes.CarType.L, SippCodes.CARTYPE_L);
		carTypeMap.put(SippCodes.CarType.X, SippCodes.CARTYPE_X);

		return carTypeMap;
	}
	private final HashMap<SippCodes.DoorsCarType, String> doorsCarTypeMap(){
		HashMap<SippCodes.DoorsCarType, String> doorsCarTypeMap = new HashMap<>();

		doorsCarTypeMap.put(SippCodes.DoorsCarType.B, SippCodes.DOORS_B);
		doorsCarTypeMap.put(SippCodes.DoorsCarType.C, SippCodes.DOORS_C);
		doorsCarTypeMap.put(SippCodes.DoorsCarType.D, SippCodes.DOORS_D);
		doorsCarTypeMap.put(SippCodes.DoorsCarType.W, SippCodes.DOORS_W);
		doorsCarTypeMap.put(SippCodes.DoorsCarType.T, SippCodes.DOORS_T);
		doorsCarTypeMap.put(SippCodes.DoorsCarType.F, SippCodes.DOORS_F);
		doorsCarTypeMap.put(SippCodes.DoorsCarType.P, SippCodes.DOORS_P);
		doorsCarTypeMap.put(SippCodes.DoorsCarType.V, SippCodes.DOORS_V);

		return doorsCarTypeMap;
	}

	private final HashMap<SippCodes.Transmission, String> transmissionMap(){
		HashMap<SippCodes.Transmission, String> transmissionMap = new HashMap<>();

		transmissionMap.put(SippCodes.Transmission.M, SippCodes.TRANSMISSION_M);
		transmissionMap.put(SippCodes.Transmission.A, SippCodes.TRANSMISSION_A);

		return transmissionMap;
	}	

	private final HashMap<SippCodes.FuelAC, String> fuelAcMap(){
		HashMap<SippCodes.FuelAC, String> fuelAcMap = new HashMap<>();

		fuelAcMap.put(SippCodes.FuelAC.N, SippCodes.FUEL_AC_N);
		fuelAcMap.put(SippCodes.FuelAC.R, SippCodes.FUEL_AC_R);

		return fuelAcMap;
	}	
}
