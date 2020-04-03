package com.lawencon.parkirapps.dao.impl.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.parkirapps.dao.VehicleDao;
import com.lawencon.parkirapps.model.Vehicle;

@Repository("vhc_repo_jpa")
public class VehicleDaoImpl implements VehicleDao {

	@Autowired
	private VehicleRepo vhcRepo;

	@Override
	public List<Vehicle> findAll() throws Exception {
		return vhcRepo.findAll();
	}

	@Override
	public Vehicle save(Vehicle vhc) throws Exception {
		return vhcRepo.save(vhc);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		vhcRepo.deleteById(id);
	}

	@Override
	public Vehicle checkOut(Vehicle vhc) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
