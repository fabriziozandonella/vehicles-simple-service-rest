/**
 * 
 */
package com.rentalcars;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.rentalcars.vehiclestest.model.Vehicle;
import com.rentalcars.vehiclestest.service.VehiclesService;;
/**
 * @author Fabrizio Zandonella
 *
 */

/*
	Create a standalone Java console application, with the functionality 
	to read the specified JSON file, parse and then perform the set tasks 
	below on the parsed data. All tasks should be printed out to the console 
	using System.out. You are free to use any external libraries, please 
	include these JARs when you submit your work.
	JSON file is accessible via http://www.rentalcars.com/js/vehicles.json
 */
public class Console {

	/**
	 * @param args
	 * @throws Exception 
	 */

	private static AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
	private static VehiclesService vehiclesService = (VehiclesService) context.getBean("vehiclesService");

	public static void main(String[] args) throws Exception  {

        // Load json file provided
		vehiclesService.jsonParser("vehicles.json");


		/*  QUESTION 1:
			Print a list of all the cars, in ascending price order, in the following format:
				1.	{Vehicle name} – {Price}
				2.	{Vehicle name} – {Price}
				.
				.
				.
				.
				31.	{Vehicle name} – {Price}

		 */

		System.out.println("\n---------- QUESION 1 ----------\n");
		String pattern1 = "%-16s   %-7s";
		System.out.println(String.format(pattern1,"Vehicle name","Price"));
		System.out.println("-------------------------");
		
		for(Vehicle v : vehiclesService.getVehiclesListOrderByPrice()){
			System.out.println(v.toStringNamePrince());
		}


		/*  QUESION 2
			Using the table below, calculate the specification of the vehicles based on their SIPP. Print the specification out using the following format:
			1.	{Vehicle name} – {SIPP} – {Car type} – {Car type/doors} – {Transmission} – {Fuel} – {Air con}
			2.	{Vehicle name} – {SIPP} – {Car type} – {Car type/doors} – {Transmission} – {Fuel} – {Air con}
			.
			.
			.
			31.	{Vehicle name} – {SIPP} – {Car type} – {Car type/doors} – {Transmission} – {Fuel} – {Air con}

		 */
		System.out.println("\n---------- QUESION 2 ----------\n");
		String pattern2 = "%-16s   %-5s   %-12s   %-14s   %-13s   %-10s   %-10s";
		System.out.println(String.format(pattern2,"Vehicle name","SIPP","Car type", "Car type/doors","Transmission", "Fuel", "Air con"));
	    System.out.println("-----------------------------------------------------------------------------------------------");
		for(Vehicle v : vehiclesService.getVehiclesListSippDetailed()){
			System.out.println(v.toStringSipp());
		}


		/*  QUESION 3
			Print out the highest rated supplier per car type, descending order, in the following format:
			1.	{Vehicle name} – {Car type} – {Supplier} – {Rating}
			2.	{Vehicle name} – {Car type} – {Supplier} – {Rating}
			.
			.
			.
			.
			7.	{Vehicle name} – {Car type} – {Supplier} – {Rating}

		 */
		System.out.println("\n---------- QUESION 3 ----------\n");
		String pattern3 = "%-16s   %-12s   %-12s   %-5s";
		System.out.println(String.format(pattern3,"Vehicle name","Car type","Supplier","Rating"));
		System.out.println("-------------------------------------------------------");
		
		for(Vehicle v : vehiclesService.getVehiclesListHighestRated()){
			System.out.println(v.toStringRating());
		}


		/*  QUESION 4
			Give each vehicle a score based on the below breakdown, then combine this score with the suppliers rating. Print out a list of vehicles, ordered by the sum of the scores in descending order, in the following format:
			1.	{Vehicle name} – {Vehicle score} – {Supplier rating} – {Sum of scores}
			2.	{Vehicle name} – {Vehicle score} – {Supplier rating} – {Sum of scores}
			.
			.
			.
			.
			3.	{Vehicle name} – {Vehicle score} – {Supplier rating} – {Sum of scores}
		
		
			Breakdown
			Manual transmission – 1 point
			Automatic transmission – 5 points
			Air conditioned – 2 points

		 */
		System.out.println("\n---------- QUESION 4 ----------\n");
		String pattern4 = "%-16s   %-16s   %-16s   %-16s";
		System.out.println(String.format(pattern4,"Vehicle name","Vehicle score","Supplier rating","Sum of scores"));
		System.out.println("----------------------------------------------------------------------");
		
		for(Vehicle v : vehiclesService.getVehiclesListOrderByTotalScore()){
			System.out.println(v.toStringScore());
		}
	}	

}
