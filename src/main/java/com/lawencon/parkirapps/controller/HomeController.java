package com.lawencon.parkirapps.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lawencon.parkirapps.model.User;
import com.lawencon.parkirapps.model.Vehicle;
import com.lawencon.parkirapps.service.UserService;
import com.lawencon.parkirapps.service.VehicleService;

/*
 * Author Munadi Fauzi A
 */

@RestController
public class HomeController extends BaseController{

	@Autowired
	VehicleService vhcService;

	@Autowired
	UserService userService;

	@PostMapping("home/user/save")
	public ResponseEntity<?> insertUser(@RequestBody String content) {
		User user = new User();
		try {
			user = new ObjectMapper().readValue(content, User.class);
			userService.save(user);
		} catch (Exception e) {
			e.getMessage();
			return new ResponseEntity<>("gagal insert : ", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping("home/user/show/")
	public ResponseEntity<?> showUser(@RequestHeader String userName, @RequestHeader String password) {
		User user = new User();
		try {
			userService.findByUserNameAndPassword(userName, password);
		} catch (Exception e) {
			e.getMessage();
			return new ResponseEntity<>("gagal menampilkan: ", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PostMapping("home/vehicle/checkin")
	public ResponseEntity<?> insertVehicle(@RequestBody String content, @RequestHeader String userName,
			@RequestHeader String password) {
		Vehicle vhc = new Vehicle();
		try {
			vhc = new ObjectMapper().readValue(content, Vehicle.class);
			vhcService.save(vhc, userName, password);
		} catch (Exception e) {
			e.getMessage();
			return new ResponseEntity<>("gagal checkin : ", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(vhc, HttpStatus.OK);
	}

	@GetMapping("/home/vehicle/listcheckin")
	public ResponseEntity<?> dataVehicle(@RequestHeader String authorization) {
		List<Vehicle> listVhc = new ArrayList<>();
		try {
			String[] auth = super.auth(authorization);
			listVhc = vhcService.findAll(auth[0], auth[1]);
		} catch (Exception e) {
			return new ResponseEntity<>("gagal menampilkan : ", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(listVhc, HttpStatus.OK);
	}

//	@GetMapping("/homeid/vehicle/{id}")
//	public ResponseEntity<?> getPath(@PathVariable("id") Long id) {
//		Vehicle vhc = new Vehicle();
//		try {
//			vhc = vhcService.findByid(id);
//		} catch (Exception e) {
//			return new ResponseEntity<>(vhc, HttpStatus.BAD_REQUEST);
//		}
//		return new ResponseEntity<>(vhc, HttpStatus.OK);
//	}

	@DeleteMapping("home/vehicle/delete")
	public ResponseEntity<?> deleteVehicle(@RequestParam Long id, @RequestHeader String userName,
			@RequestHeader String password) {
		try {
			vhcService.deleteById(id, userName, password);
		} catch (Exception e) {
			e.getMessage();
			return new ResponseEntity<>("gagal", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("berhasil", HttpStatus.OK);
	}

//	@PutMapping("home/vehicle/checkout")
//	public ResponseEntity<?> checkOut(@RequestParam String platNumber, String dateOut) {
//		try {
//			vhcService.updateByPlatNumberAndDateOut(platNumber, dateOut);
//		} catch (Exception e) {
//			e.getMessage();
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
//		return new ResponseEntity<>(HttpStatus.OK);
//	}

//	@PutMapping("/vehicle/{id}")
//	public ResponseEntity<Vehicle> updateEmployee(@PathVariable(value = "id") Long idVehicle,
//			@Valid @RequestBody Checkout checkout) {
//		Vehicle vhc = new Vehicle();
//		try {
//			vhc = vhcService.findByid(idVehicle);
//
//			vhc.setDateOut(checkout.getDateOut());
//			vhcService.save(vhc);
//		} catch (Exception e) {
//			e.getMessage();
//			return new ResponseEntity<>(vhc, HttpStatus.BAD_REQUEST);
//		}
//		return new ResponseEntity<>(vhc, HttpStatus.OK);
//	}
}
