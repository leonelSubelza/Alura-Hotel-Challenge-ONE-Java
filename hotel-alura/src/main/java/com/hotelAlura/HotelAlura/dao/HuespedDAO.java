package com.hotelAlura.HotelAlura.dao;

import java.util.List;
import com.hotelAlura.HotelAlura.model.Huesped;
import com.hotelAlura.HotelAlura.model.Reserva;

import javax.persistence.EntityManager;

public class HuespedDAO {

	private EntityManager em;
	
	public HuespedDAO(EntityManager em) {
		this.em = em;
	}
	
	public void guardar(Huesped huesped) {
	    em.getTransaction().begin();
		this.em.persist(huesped);
		em.getTransaction().commit();
	}
	
	public void actualizar(Huesped huesped) {
		em.getTransaction().begin();
		this.em.merge(huesped);
		em.getTransaction().commit();
	}
	
	public void remover(Huesped huesped) {
		em.getTransaction().begin();
		huesped=this.em.merge(huesped);
		this.em.remove(huesped);
		em.getTransaction().commit();
	}
	
	public Huesped consultaPorId(Long id) {
		em.getTransaction().begin();
		Huesped ret = em.find(Huesped.class, id);
		em.getTransaction().commit();
		return ret;
	}
	
	public List<Huesped> consultarTodos(){
		em.getTransaction().begin();
		String jqpl= "SELECT H FROM Huesped AS H";
		List<Huesped> ret = em.createQuery(jqpl,Huesped.class).getResultList();
		em.getTransaction().commit();
		return ret;
	}
	
}
