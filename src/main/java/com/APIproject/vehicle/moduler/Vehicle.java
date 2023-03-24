package com.APIproject.vehicle.moduler;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vid;
	private String vname;
	private double vprice;
	private int vmodel;
	private String vcolor;
	
	
	
}
