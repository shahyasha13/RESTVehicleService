package com.example.RESTVehicleService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RESTVehicleService.model.Vehicle;
import com.example.RESTVehicleService.repository.VehicleRepository;
import com.example.RESTVehicleService.service.Interface.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Override
	public Vehicle getVehicleById(Integer vehicleId) {
		
		Vehicle vehicle= vehicleRepository.getVehicleById(vehicleId);
		
		return vehicle;
	}
	
	@Override
	public boolean createVehicle(Vehicle vehicle) {
		
		boolean result = vehicleRepository.createVehicle(vehicle);
		
		return result;
	}


	@Override
	public Vehicle deleteVehicleById(Integer vehicleId) {
		
		return vehicleRepository.deleteVehicheById(vehicleId);
	}
	
	@Override
	public boolean updateVehicle(Vehicle vehicle) {
		
		return vehicleRepository.updateVehicle(vehicle);
	}

	@Override
	public List<Vehicle> getAllMatchingVehicles(Integer id, Integer year, String model, String make) {
		
		return vehicleRepository.getAllMatchingVehicle(id,year,model,make);
	}



}
