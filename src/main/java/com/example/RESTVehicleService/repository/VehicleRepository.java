package com.example.RESTVehicleService.repository;

import java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.RESTVehicleService.model.Vehicle;

@Repository
public class VehicleRepository {

	@Autowired
	private Map<Integer, Vehicle> vehicleResource;


	public Vehicle getVehicleById(Integer vehicleId) {
		
		Vehicle vehicle = vehicleResource.get(vehicleId);
		
		return vehicle;
	}

	
	public boolean createVehicle(Vehicle vehicle) {
	
		if (vehicleResource.containsKey(vehicle.getId())) {
			return false;
		} else {
			vehicleResource.put(vehicle.getId(), vehicle);
			return true;
		}
		
	}


	public Vehicle deleteVehicheById(Integer vehicleId) {
		
		return vehicleResource.remove(vehicleId);
	}

	public boolean updateVehicle(Vehicle vehicle) {
		
		Vehicle vehicleToUpdate = vehicleResource.get(vehicle.getId());
		if (vehicleToUpdate == null) {
			return false;
		} else {
			
			vehicleToUpdate.setMake(vehicle.getMake());
			vehicleToUpdate.setModel(vehicle.getModel());
			vehicleToUpdate.setYear(vehicle.getYear());
			
			return true;
		}

	}

	public List<Vehicle> getAllMatchingVehicle(Integer id, Integer year, String model, String make) {
		
		List<Predicate<Vehicle>> predicateList = new ArrayList<Predicate<Vehicle>>();
		
		if (id != null && id > 0) {
			predicateList.add(v -> v.getId() == id);
		}
		
		if (year != null && year > 0) {
			predicateList.add(v -> v.getYear() == year);
		}
		
		if (make != null && make.trim().length() > 0) {
			predicateList.add(v -> v.getMake().equals(make));
		}
		
		if (model != null && model.trim().length() > 0) {
			predicateList.add(v -> v.getModel().equals(model));
		}

		//Filter Vehicles based on matching properties
		List<Vehicle> foundVehicle = vehicleResource.values().stream()
				.filter(predicateList.stream().reduce(x -> true, Predicate::and))
				.collect(Collectors.toList());
		
		return foundVehicle;
		
	}

}
