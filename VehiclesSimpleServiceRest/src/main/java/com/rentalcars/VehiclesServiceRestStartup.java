/**
 * 
 */
package com.rentalcars;

import org.springframework.beans.factory.annotation.Autowired;
/**
 * @author Fabrizio Zandonella
 *
 */
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.rentalcars.vehiclestest.service.VehiclesService;

@Component
public class VehiclesServiceRestStartup implements ApplicationListener<ApplicationReadyEvent> {

	/**
	 * This event is executed as late at the end of the loading of Spring Boot 
	 * and provides the initialization calling the service vehiclesService.jsonParser
	 */

	@Autowired
	VehiclesService vehiclesService;

	@Override
	public void onApplicationEvent(final ApplicationReadyEvent event) {

		vehiclesService.jsonParser("vehicles.json");

		return;
	}

}