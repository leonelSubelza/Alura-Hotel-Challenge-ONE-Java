package com.hotelAlura.core;

import com.hotelAlura.core.controller.MenuController;
import com.hotelAlura.core.utils.JPAUtils;

import javax.persistence.EntityManager;

public class HotelAluraApplication {
	
	public static void main(String[] args) {
		new MenuController();
	}
}
