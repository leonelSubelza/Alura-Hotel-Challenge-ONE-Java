package com.hotelAlura.HotelAlura.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JPAUtils {
	private static EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("hotel_alura");

	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}
}
