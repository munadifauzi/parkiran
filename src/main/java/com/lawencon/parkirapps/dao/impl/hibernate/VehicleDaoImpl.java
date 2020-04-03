package com.lawencon.parkirapps.dao.impl.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.parkirapps.dao.VehicleDao;
import com.lawencon.parkirapps.model.Vehicle;

@Repository("vhc_repo_hibernate")
public class VehicleDaoImpl extends BaseHibernate implements VehicleDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Vehicle> findAll() throws Exception {
		Query q = em.createQuery(" from Vehicle");

		List<Vehicle> listVhc = new ArrayList<>();
		listVhc = q.getResultList();
		return listVhc;
	}

	public Vehicle findByid(Long id) throws Exception {
		Query q = em.createQuery(" from Vehicle where idVehicle = :idParam");
		q.setParameter("idParam", id);

		Vehicle vhc = new Vehicle();
		vhc = (Vehicle) q.getSingleResult();
		return vhc;
	}

	public Vehicle save(Vehicle vhc) throws Exception {
		em.persist(vhc);
		return vhc;
	}

	public void deleteById(Long id) throws Exception {

		Query q = em.createQuery(" from Vehicle where idVehicle = :idParam");
		q.setParameter("idParam", id);

		Vehicle vhc = new Vehicle();
		vhc = (Vehicle) q.getSingleResult();
		em.remove(vhc);
	}

	@Override
	public Vehicle checkOut(Vehicle vhc) throws Exception {
//		List<Vehicle> listVhc = 
		return null;
	}

}
