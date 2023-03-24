package com.APIproject.vehicle.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.APIproject.vehicle.moduler.Vehicle;

@Service
public interface VehicleService {
	
	Vehicle saveData(Vehicle vehicle);
	
	void delet(int vid);
	
	List<Vehicle> getAlData();
	
	List<Vehicle> getByVcolor(String vcolor);
	
	Optional<Vehicle> getById(int vid);

	List<Vehicle> sortByVprice();
	
	List<Vehicle> getDataByMoreThanVprice(Double vprice);
	
	List<Vehicle> getDataByPrice();
	
	Vehicle update(int vid,Vehicle vehicle);
}
