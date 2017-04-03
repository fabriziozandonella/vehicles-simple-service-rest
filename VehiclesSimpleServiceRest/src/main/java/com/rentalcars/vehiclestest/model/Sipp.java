/**
 * 
 */
package com.rentalcars.vehiclestest.model;

/**
 * @author Fabrizio Zandonella
 *
 */
public class Sipp {

	private String carType;
	private String carTypeDoors;
	private String transmission;
	private String fuel;
	private String ac;
	private int score = 0;
 
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getCarTypeDoors() {
		return carTypeDoors;
	}
	public void setCarTypeDoors(String carTypeDoors) {
		this.carTypeDoors = carTypeDoors;
	}
	public String getTransmission() {
		return transmission;
	}
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	public String getAc() {
		return ac;
	}
	public void setAc(String ac) {
		this.ac = ac;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
}
