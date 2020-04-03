package com.lawencon.parkirapps.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lawencon.parkirapps.model.Vehicle;

@Service
public interface VehicleService {

	abstract List<Vehicle> findAll(String userName, String password) throws Exception;

	abstract Vehicle save(Vehicle vhc, String userName, String password) throws Exception;

	abstract void deleteById(Long id, String userName, String password) throws Exception;

	Vehicle checkout(Vehicle vhc, String userName, String password) throws Exception;

	List<Vehicle> updateByPlatNumberAndDateOut(String platNumber, String dateOut, String userName, String password)
			throws Exception;
}
