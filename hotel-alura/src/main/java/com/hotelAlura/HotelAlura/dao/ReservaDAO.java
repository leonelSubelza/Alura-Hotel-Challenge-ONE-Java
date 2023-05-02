package com.hotelAlura.HotelAlura.dao;

import java.util.List;

import com.hotelAlura.HotelAlura.model.Reserva;

import jakarta.persistence.EntityManager;

public class ReservaDAO {

	private EntityManager em;
	
	public ReservaDAO(EntityManager em) {
		this.em = em;
	}
	
	public void guardar(Reserva reserva) {
		this.em.persist(reserva);
	}
	
	public void actualizar(Reserva reserva) {
		this.em.merge(reserva);
	}
	
	public void remover(Reserva reserva) {
		reserva=this.em.merge(reserva);
		this.em.remove(reserva);
	}
	
	public Reserva consultaPorId(Long id) {
		return em.find(Reserva.class, id);
	}
	
	public List<Reserva> consultarTodos(){
		String jqpl= "SELECT R FROM Reserva AS R";
		return em.createQuery(jqpl,Reserva.class).getResultList();
	}
	
}
