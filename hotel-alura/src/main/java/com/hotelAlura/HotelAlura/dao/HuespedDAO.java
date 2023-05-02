package com.hotelAlura.HotelAlura.dao;

import java.util.List;
import com.hotelAlura.HotelAlura.model.Huesped;
import jakarta.persistence.EntityManager;

public class HuespedDAO {

	private EntityManager em;
	
	public HuespedDAO(EntityManager em) {
		this.em = em;
	}
	
	public void guardar(Huesped huesped) {
		this.em.persist(huesped);
	}
	
	public void actualizar(Huesped huesped) {
		this.em.merge(huesped);
	}
	
	public void remover(Huesped huesped) {
		huesped=this.em.merge(huesped);
		this.em.remove(huesped);
	}
	
	public Huesped consultaPorId(Long id) {
		return em.find(Huesped.class, id);
	}
	
	public List<Huesped> consultarTodos(){
		String jqpl= "SELECT H FROM Huesped AS H";
		return em.createQuery(jqpl,Huesped.class).getResultList();
	}
	
}
