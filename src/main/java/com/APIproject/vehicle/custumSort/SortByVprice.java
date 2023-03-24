package com.APIproject.vehicle.custumSort;

import java.util.Comparator;

import com.APIproject.vehicle.moduler.Vehicle;

public class SortByVprice implements Comparator<Vehicle> {

	@Override
	public int compare(Vehicle o1, Vehicle o2) {

		Double d1=o1.getVprice(),d2=o2.getVprice();
		return d1.compareTo(d2);
	}

}
