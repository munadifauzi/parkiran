package com.lawencon.parkirapps.controller;

import java.util.Base64;

public abstract class BaseController {

	String[] auth (String auth) {
		byte[] decodedBytes = Base64.getDecoder().decode(auth);
		String decodedString = new String(decodedBytes);
		String[] result = decodedString.split(":");
		
		return result;
	}
}
