package com.example.RESTVehicleService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND,reason="No vehicle found")
public class VehicleNotFoundException extends RuntimeException {
	
	public VehicleNotFoundException() {
	}

}
