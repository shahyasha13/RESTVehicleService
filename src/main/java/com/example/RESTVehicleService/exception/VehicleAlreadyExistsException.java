package com.example.RESTVehicleService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.CONFLICT,reason="Vehicle with given Id already exist")
public class VehicleAlreadyExistsException extends RuntimeException{

	public VehicleAlreadyExistsException() {
		
	}
}
