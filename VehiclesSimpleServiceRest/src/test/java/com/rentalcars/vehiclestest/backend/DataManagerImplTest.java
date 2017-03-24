/**
 * 
 */
package com.rentalcars.vehiclestest.backend;

import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.rentalcars.ApplicationConfig;

/**
 * @author Fabrizio
 *
 */
public class DataManagerImplTest {
	AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
	DataManager dm = (DataManager) context.getBean("dataManager");


	@Test
	public void jsonParserTest() {
		dm.jsonParser("vehicles.json");
		assertFalse(dm.getVehiclesList().isEmpty());
	}
	@Test
	public void carTypeMapTest() {
		assertFalse(dm.getCarTypeMap().isEmpty());
	}	
	@Test
	public void doorsCarTypeMapTest() {
		assertFalse(dm.getDoorsCarTypeMap().isEmpty());
	}
	@Test
	public void transmissionMapTest() {
		assertFalse(dm.getTransmissionMap().isEmpty());
	}	
	@Test
	public void fuelAcMapTest() {
		assertFalse(dm.getFuelAcMap().isEmpty());
	}		

	@Test(expected=Exception.class)
	public void sippConverterTest1() throws Exception {
		dm.sippConverter("CDMRR");
	}	
	@Test(expected=Exception.class)
	public void sippConverterTest2() throws Exception {
		dm.sippConverter("");
	}			
	@Test(expected=Exception.class)
	public void sippConverterTest3() throws Exception {
		dm.sippConverter(null);
	}	
	@Test
	public void vehiclesListOrderByPriceTest() {
		dm.jsonParser("vehicles.json");
		assertFalse(dm.getVehiclesListOrderByPrice().isEmpty());
	}	
	@Test
	public void vehiclesListSippDetailedTest() throws Exception {
		dm.jsonParser("vehicles.json");
		assertFalse(dm.getVehiclesListSippDetailed().isEmpty());
	}	
	@Test
	public void vehiclesListHighestRated() throws Exception {
		dm.jsonParser("vehicles.json");
		assertFalse(dm.getVehiclesListHighestRated().isEmpty());
	}	
	@Test
	public void vehiclesListOrderByTotalScoreTest() {
		dm.jsonParser("vehicles.json");
		assertFalse(dm.getVehiclesListOrderByTotalScore().isEmpty());
	}	
}