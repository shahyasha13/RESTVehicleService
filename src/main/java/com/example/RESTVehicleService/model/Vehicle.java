package com.example.RESTVehicleService.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Vehicle {

	private static Integer idCounter=1;
	
	@JsonProperty("Id")
	private Integer id;

	@NotNull(message = "Year is required")
	@Min(value = 1950, message = "Year Must be between 1950 and 2050")
	@Max(value = 2050, message = "Year Must be between 1950 and 2050")
	@JsonProperty("Year")
	private Integer year;

	@NotNull(message = "Make is required")
	@Size(min = 0, max = 100, message = "Make Length must be between 0 to 100")
	@JsonProperty("Make")
	private String make;

	@NotNull(message = "Model is required")
	@Size(min = 0, max = 100, message = "Model Length must be between 0 to 100")
	@JsonProperty("Model")
	private String model;

	public Vehicle() {
		
		this.id = idCounter++;
	}

	public Vehicle(Integer id, Integer year, String make, String model) {
		
		super();
		this.id = idCounter++;
		this.year = year;
		this.make = make;
		this.model = model;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}
	
	
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}


	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

}
