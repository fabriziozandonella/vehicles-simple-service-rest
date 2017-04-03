/**
 * 
 */
package com.rentalcars.vehiclestest.restcontroller.exclusionstrategies;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.rentalcars.vehiclestest.model.Sipp;
import com.rentalcars.vehiclestest.model.Vehicle;

/**
 * @author Fabrizio Zandonella
 *
 */
public class ExclusionStrategySippImpl implements ExclusionStrategy {

	public boolean shouldSkipClass(Class<?> arg0) {
		return false;
	}

	public boolean shouldSkipField(FieldAttributes f) {

		return (f.getDeclaringClass() == Vehicle.class && f.getName().equals("price")) 
				||
				(f.getDeclaringClass() == Vehicle.class && f.getName().equals("supplier"))				
				||
				(f.getDeclaringClass() == Vehicle.class && f.getName().equals("rating"))
				||
				(f.getDeclaringClass() == Vehicle.class && f.getName().equals("totalScore"))			
				||
				(f.getDeclaringClass() == Vehicle.class && f.getName().equals("score"));
	}

}