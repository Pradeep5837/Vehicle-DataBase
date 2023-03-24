package com.APIproject.vehicle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.APIproject.vehicle.moduler.Vehicle;

public interface VehicleRepo extends JpaRepository<Vehicle, Integer>{
	
	public List<Vehicle> getByVcolor(String vcolr);
	
	@Query(value="select * from Vehicle where vprice >=:vprice",nativeQuery = true)
	List<Vehicle> moreThanVprice(Double vprice);
	
//	@Query(value="select * from Vehicle order by vcolor asc")
//	List<Vehicle> orderByAscVcolor();

}
