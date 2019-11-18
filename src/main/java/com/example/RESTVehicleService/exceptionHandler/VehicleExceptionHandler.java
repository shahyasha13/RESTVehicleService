package com.example.RESTVehicleService.exceptionHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class VehicleExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			WebRequest request ){
		
		Map<String, Object> body = new HashMap<>();
		
        body.put("timestamp", new Date());
        body.put("status",HttpStatus.BAD_REQUEST);
		
        List<String> errors= new ArrayList<String>();
 
        for ( FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getDefaultMessage());
        }
        
        body.put("errors", errors);
        
        return new ResponseEntity<>(body,new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}
	
	

}
