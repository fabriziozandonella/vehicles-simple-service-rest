/**
 * 
 */
package com.rentalcars.vehiclestest.model;

/**
 * @author Fabrizio Zandonella
 *
 */
public class Vehicle {
    private String sipp;
	private String name; 
	private double price;
	private String supplier;
	private double rating;
	private Sipp sippObj;
	private double totalScore;

	
	public String getSipp() {
		return sipp;
	}
	public void setSipp(String sipp) {
		this.sipp = sipp;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	public Sipp getSippObj() {
		return sippObj;
	}
	public void setSippObj(Sipp sippObj) {
		this.sippObj = sippObj;
	}
	
	public double getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(double totalScore) {
		this.totalScore = totalScore;
	}
	
	@Override
	public String toString() {
		String pattern = "|%-5s|%-17s|%-7s|%-8s|%-4s|\n";
		return String.format(pattern,sipp,name ,price, supplier, rating);
	}
	
	 
	public String toStringNamePrince() {
		String pattern = "%-16s - %-7s";
		return String.format(pattern,name,price);
	}	
	
	public String toStringSipp() {
		String pattern = "%-16s - %-5s - %-12s - %-14s - %-13s - %-10s - %-10s";
		return String.format(pattern,name,sipp,sippObj.getCarType(), sippObj.getCarTypeDoors(),sippObj.getTransmission(), sippObj.getFuel(), sippObj.getAc());
	}
	
	public String toStringRating() {
		String pattern = "%-16s - %-12s - %-12s - %-5s";
		return String.format(pattern,name,sippObj.getCarType(),supplier, rating);
	}	
	
	public String toStringScore() {
		String pattern = "%-16s - %-16s - %-16s - %-16s";
		return String.format(pattern,name,sippObj.getScore(),rating, totalScore);
	}	
	
}