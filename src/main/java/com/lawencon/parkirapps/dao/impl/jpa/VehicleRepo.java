package com.lawencon.parkirapps.dao.impl.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.parkirapps.model.Vehicle;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle, Long> {

}
