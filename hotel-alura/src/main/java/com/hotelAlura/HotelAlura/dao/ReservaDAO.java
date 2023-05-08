package com.hotelAlura.HotelAlura.dao;

import java.util.List;

import com.hotelAlura.HotelAlura.model.Reserva;

import javax.persistence.EntityManager;


public class ReservaDAO {

	private EntityManager em;
	
	public ReservaDAO(EntityManager em) {
		this.em = em;
	}
	
	public void guardar(Reserva reserva) {
	    em.getTransaction().begin();
		this.em.persist(reserva);//crea una nueva entidad en la bd
		em.getTransaction().commit();
	}
	
	public void actualizar(Reserva reserva) {
	    em.getTransaction().begin();
		this.em.merge(reserva);//actualiza la entidad existente en la bd
		em.getTransaction().commit();

	}
	
	public void remover(Reserva reserva) {
		em.getTransaction().begin();
		reserva=this.em.merge(reserva);
		this.em.remove(reserva);
		em.getTransaction().commit();
	}
	
	public Reserva consultaPorId(Long id) {
		em.getTransaction().begin();
		Reserva ret = em.find(Reserva.class, id);
		em.getTransaction().commit();
		return ret;
	}
	
	public List<Reserva> consultarTodos(){
		em.getTransaction().begin();
		String jqpl= "SELECT R FROM Reserva AS R";
		List<Reserva> ret = em.createQuery(jqpl,Reserva.class).getResultList();
		em.getTransaction().commit();
		return ret;
	}
	
}
