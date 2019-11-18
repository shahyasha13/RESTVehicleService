package com.example.RESTVehicleService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.RESTVehicleService.model.Vehicle;

@SpringBootApplication
public class RestVehicleServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestVehicleServiceApplication.class, args);
	}

	@Bean
	public Map<Integer,Vehicle> vehicleResporce(){
		Map<Integer,Vehicle> resource= new HashMap<Integer,Vehicle>();
		
		Vehicle vehicle1=new Vehicle(1,1990,"Toyota","Camery");
		Vehicle vehicle2=new Vehicle(2,1996,"Honda","Civic");
		Vehicle vehicle3=new Vehicle(3,2015,"Tesla","Model3");
		
		resource.put(vehicle1.getId(), vehicle1);
		resource.put(vehicle2.getId(), vehicle2);
		resource.put(vehicle3.getId(), vehicle3);
		
		return resource;
	}

}
