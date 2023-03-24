package com.APIproject.vehicle.serviceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.APIproject.vehicle.custumSort.SortByColour;
import com.APIproject.vehicle.custumSort.SortByVprice;
import com.APIproject.vehicle.moduler.Vehicle;
import com.APIproject.vehicle.repository.VehicleRepo;
import com.APIproject.vehicle.service.VehicleService;
import com.mysql.cj.x.protobuf.MysqlxCrud.Order.Direction;

@Service
public class VehicleSeviceImpl implements VehicleService {

	@Autowired
	VehicleRepo vr;

	@Override
	public Vehicle saveData(Vehicle vehicle) {

		return vr.save(vehicle);
	}

	@Override
	public void delet(int vid) {

		vr.deleteById(vid);
		System.out.println("deleted");

	}

	@Override
	public List<Vehicle> getAlData() {

		ArrayList<Vehicle> al = (ArrayList<Vehicle>) vr.findAll();
		Collections.sort(al, new SortByColour());
		return al;
	}

	@Override
	public List<Vehicle> getByVcolor(String vcolor) {

		return vr.getByVcolor(vcolor);
	}

	@Override
	public Optional<Vehicle> getById(int vid) {

		return vr.findById(vid);
	}

	@Override
	public List<Vehicle> sortByVprice() {

		List<Vehicle> al = vr.findAll();
		Collections.sort(al, new SortByVprice());
		return al;
	}

	@Override
	public List<Vehicle> getDataByMoreThanVprice(Double vprice) {

		return vr.moreThanVprice(vprice);
	}

	@Override
	public List<Vehicle> getDataByPrice() {

		List al = vr.findAll(Sort.by(Sort.Direction.ASC, "vcolor"));

		Collections.sort(al, new SortByVprice());

		return al;
	}

	@Override
	public Vehicle update(int vid, Vehicle vehicle) {

		Vehicle v = vr.getById(vid);
		if (vehicle.getVcolor() != null)
			v.setVcolor(vehicle.getVcolor());
		if (vehicle.getVmodel() > 0)
			v.setVmodel(vehicle.getVmodel());
		if (vehicle.getVname() != null)
			v.setVname(vehicle.getVname());
		if (vehicle.getVprice() > 0)
			v.setVprice(vehicle.getVprice());

		return vr.save(v);
	}

}
