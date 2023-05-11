package com.hotelAlura.core.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JPAUtils {
	//Se utiliza el patron Singleton, donde este objeto se instanciara una sola vez en todo el proyecto
	private static EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("hotel_alura");

	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}
	
    public static void closeEntityManagerFactory() {
        if (FACTORY != null) {
        	FACTORY.close();
        }
    }
}
