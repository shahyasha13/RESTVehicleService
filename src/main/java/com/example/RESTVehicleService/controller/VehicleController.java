package com.example.RESTVehicleService.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.RESTVehicleService.exception.VehicleAlreadyExistsException;
import com.example.RESTVehicleService.exception.VehicleNotFoundException;
import com.example.RESTVehicleService.model.Vehicle;
import com.example.RESTVehicleService.service.Interface.VehicleService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/vehicles")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@GetMapping("/{id}")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public Vehicle getVehicleById(@PathVariable("id") Integer vehicleId) {
		
		Vehicle vehicle = vehicleService.getVehicleById(vehicleId);
		
		if (vehicle == null) {
			throw new VehicleNotFoundException();
		}
		
		return vehicle;
	}

	//	Pass filter parameter as Query parameters
	
	@GetMapping()
	@ResponseBody
	public List<Vehicle> getAllVehicles(@RequestParam(name = "id", required = false) Integer id,
			@RequestParam(name = "year", required = false) Integer year,
			@RequestParam(name = "make", required = false) String make,
			@RequestParam(name = "model", required = false) String model) {

		List<Vehicle> vehicles = vehicleService.getAllMatchingVehicles(id, year, model, make);
		
		if (vehicles == null || vehicles.size() == 0) {
			throw new VehicleNotFoundException();
		}
		
		return vehicles;
	}

	
	
	@PostMapping()
	@ResponseStatus(value = HttpStatus.CREATED, reason = "Vehicle successfully created")
	public void createVehicle(@Valid @RequestBody Vehicle vehicle) {
		
		boolean createdSuccess = vehicleService.createVehicle(vehicle);
		
		if (!createdSuccess) {
			throw new VehicleAlreadyExistsException();
		}
	}

	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK, reason = "Vehicle successfully deleted")
	public void deleteVehicleById(@PathVariable("id") Integer vehicleId) {
		
		Vehicle deletedVehicle = vehicleService.deleteVehicleById(vehicleId);
		
		if (deletedVehicle == null) {
			throw new VehicleNotFoundException();
		}
		
	}

	@PutMapping()
	@ResponseStatus(value = HttpStatus.OK, reason = "Vehicle successfully updated")
	public void updateVehicle(@Valid @RequestBody Vehicle vehicle) {
		
		boolean updateSuccess = vehicleService.updateVehicle(vehicle);
		
		if (!updateSuccess) {
			throw new VehicleNotFoundException();
		}
		
	}
}
