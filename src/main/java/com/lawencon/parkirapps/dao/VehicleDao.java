package com.lawencon.parkirapps.dao;

import java.util.List;

import com.lawencon.parkirapps.model.Vehicle;

public interface VehicleDao {

	List<Vehicle> findAll() throws Exception;

	Vehicle save(Vehicle vhc) throws Exception;

	void deleteById(Long id) throws Exception;

	Vehicle checkOut(Vehicle vhc) throws Exception;

}
