package com.lawencon.parkirapps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lawencon.parkirapps.dao.VehicleDao;
import com.lawencon.parkirapps.model.Vehicle;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	@Qualifier("vhc_repo_jpa") // jika pingin ganti jpa ganti qualifiernya jadi mhs_repo_jpa
	private VehicleDao vhcDao;

	@Autowired
	private UserService userService;

	@Override
	public List<Vehicle> findAll(String userName, String password) throws Exception {

		userService.findByUserNameAndPassword(userName, password);
		return vhcDao.findAll();
	}

	@Override
	public Vehicle save(Vehicle vhc, String userName, String password) throws Exception {
		userService.findByUserNameAndPassword(userName, password);

		String noPol = vhc.getPlatNumber();
		char noPol1 = noPol.charAt(0);
		int noPol2 = Integer.parseInt(noPol.substring(1, 5));
		String noPol3 = noPol.substring(5, 8);
		if (noPol1 == 'B' || noPol1 == 'b') {
			if (noPol2 >= 0 && noPol2 <= 9999) {
				if (!noPol3.matches("[0-9]")) {
					if (vhc.getVehicleType().equalsIgnoreCase("motor")
							|| vhc.getVehicleType().equalsIgnoreCase("mobil")) {
						vhcDao.save(vhc);
					}
				}
			}
		} else {
			return null;
		}
		return vhc;
	}

	@Override
	public void deleteById(Long id, String userName, String password) throws Exception {
		userService.findByUserNameAndPassword(userName, password);
		vhcDao.deleteById(id);
	}

	@Override
	public Vehicle checkout(Vehicle vhc, String userName, String password) throws Exception {
		userService.findByUserNameAndPassword(userName, password);

		return vhc;
	}

	@Override
	public List<Vehicle> updateByPlatNumberAndDateOut(String platNumber, String dateOut, String userName,
			String password) throws Exception {
		userService.findByUserNameAndPassword(userName, password);
		return null;
	}

}
