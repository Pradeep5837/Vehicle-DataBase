package com.APIproject.vehicle.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.APIproject.vehicle.moduler.Vehicle;
import com.APIproject.vehicle.service.VehicleService;

@RestController
public class VehicleController {
	
	@Autowired
	VehicleService vs;
	
	@PostMapping("saveData")
	ResponseEntity<Vehicle> saveData(@RequestBody Vehicle vehicle){
		
		return new ResponseEntity<Vehicle>(vs.saveData(vehicle),HttpStatus.CREATED);
	}
	
	@DeleteMapping("delet/{id}")
	public void delet(@PathVariable int id) {
		
		vs.delet(id);
	}
	
	@GetMapping("getAll")
	List<Vehicle> getAllData()
	{
		return vs.getAlData();
	}
	
	@GetMapping("getByColor/{vcolor}")
	List<Vehicle> getByColor(@PathVariable String vcolor){
		
		return vs.getByVcolor(vcolor);
	}
	
	@GetMapping("getById")
	Optional<Vehicle> getByVid(@RequestHeader int vid){
		
		return vs.getById(vid);
	}
	
	@GetMapping("sortByPrice")
	List<Vehicle> sortbyPrice(){
		
		return vs.sortByVprice();
	}
	
	@GetMapping("getVpriceMoreThan")
	List<Vehicle> getVpriceMoreThan(@RequestHeader Double vprice){
		
		return vs.getDataByMoreThanVprice(vprice);
	}
	
	@GetMapping("sortByPriceWithColor")
	List<Vehicle> sortByPriceWithColor(){
		
		return vs.getDataByPrice();
	}
	
	@PutMapping("update/{vid}")
	ResponseEntity<Vehicle> updete(@PathVariable int vid,@RequestBody Vehicle v){
		
		return new ResponseEntity<Vehicle>(vs.update(vid, v),HttpStatus.CREATED);
	}

}









