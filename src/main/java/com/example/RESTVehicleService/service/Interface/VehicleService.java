package com.example.RESTVehicleService.service.Interface;

import java.util.List;

import com.example.RESTVehicleService.model.Vehicle;

public interface VehicleService {
	
	public Vehicle getVehicleById(Integer vehicleId);
	public boolean createVehicle(Vehicle vehicle);
	public Vehicle deleteVehicleById(Integer vehicleId);
	public boolean updateVehicle(Vehicle vehicle);
	public List<Vehicle> getAllMatchingVehicles(Integer id, Integer year, String model, String make);
	

}
