package com.APIproject.vehicle.custumSort;

import java.util.Comparator;

import com.APIproject.vehicle.moduler.Vehicle;

public class SortByColour implements Comparator<Vehicle> {

	

	@Override
	public int compare(Vehicle o1, Vehicle o2) {
		// TODO Auto-generated method stub
		return o1.getVcolor().compareTo(o2.getVcolor());
	}

}
