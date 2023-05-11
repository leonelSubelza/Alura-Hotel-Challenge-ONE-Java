package com.hotelAlura.core.dao;

import java.time.LocalDate;
import java.util.List;

import com.hotelAlura.core.model.Huesped;
import com.hotelAlura.core.model.Reserva;
import com.hotelAlura.core.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.swing.*;


public class ReservaDAO {

	private EntityManager em;
	
	public ReservaDAO(EntityManager em) {
		this.em = em;
	}
	
	public void guardar(Reserva reserva) {
		try {
			em.getTransaction().begin();
			this.em.persist(reserva);
			em.getTransaction().commit();
		} catch (PersistenceException e) {
			em.getTransaction().rollback(); // deshace la transacción
			throw new RuntimeException("Error al guardar la reserva: " + e.getMessage(), e);
		}
	}
	
	public void actualizar(Reserva reserva) {
		try{
			em.getTransaction().begin();
			this.em.merge(reserva);//actualiza la entidad existente en la bd
			em.getTransaction().commit();
		}catch (PersistenceException e){
			e.printStackTrace();
			em.getTransaction().rollback(); // deshace la transacción
		}
	}
	public void actualizar(Long id,String nroReserva,LocalDate fechaIn, LocalDate  fechaOut, double valor,String formaPago,List<Huesped> huespedes) {
		try{
			em.getTransaction().begin();
			this.em.merge(new Reserva(id,fechaIn,fechaOut,valor,formaPago,nroReserva,huespedes));//actualiza la entidad existente en la bd
			em.getTransaction().commit();
		}catch (PersistenceException e){
			e.printStackTrace();
			em.getTransaction().rollback(); // deshace la transacción
		}
	}

	public void remover(Reserva reserva) {
		try{
			em.getTransaction().begin();
			reserva=this.em.merge(reserva);
			this.em.remove(reserva);
			em.getTransaction().commit();
		}catch (PersistenceException e){
			em.getTransaction().rollback(); // deshace la transacción
			e.printStackTrace();
		}
	}
	
	public Reserva consultaPorId(Long id) {
		em.getTransaction().begin();
		Reserva ret = em.find(Reserva.class, id);
		em.getTransaction().commit();
		return ret;
	}

	public List<Reserva> buscarPorNumeroReserva(String buscar) {
		em.getTransaction().begin();
		String jqpl= "SELECT R FROM Reserva AS R WHERE R.nroReserva LIKE :reserva";
		List<Reserva> ret = null;
		try{
			TypedQuery<Reserva> query = em.createQuery(jqpl,Reserva.class);
			query.setParameter("reserva","%"+buscar+"%");
			em.getTransaction().commit();
			ret = query.getResultList();
		}catch (Exception e){
			e.printStackTrace();
		}
		return ret;
	}

	public List<Reserva> consultarTodos(){
		em.getTransaction().begin();
		String jqpl= "SELECT R FROM Reserva AS R";
		List<Reserva> ret = em.createQuery(jqpl,Reserva.class).getResultList();
		em.getTransaction().commit();
		return ret;
	}
	
	public String obtenerUltNroReserva() {
		em.getTransaction().begin();
		String jqpl= "SELECT R FROM Reserva AS R ORDER BY R.id DESC";
		Reserva ret = null;
		try{
			ret = em.createQuery(jqpl,Reserva.class).setMaxResults(1).getSingleResult();
		}catch (Exception e){
			e.printStackTrace();
			return "";
		}
		return ret.getNroReserva();
	}

	public Reserva existEntity(Reserva reserva){
		//no se realiza un begin() porque no se va a hacer ninguna modificacion en la bd
		//si existe retorna el obj
		TypedQuery<Reserva> query;
		Reserva ret;
		try {
			query = em.createQuery(
					"SELECT R FROM Reserva R WHERE " +
							"R.fechaEntrada = :fechaEntrada AND " +
							"R.fechaSalida = :fechaSalida AND " +
							"R.formaPago = :formaPago AND " +
							"R.valor =: valor", Reserva.class);
			query.setParameter("fechaEntrada", reserva.getFechaEntrada());
			query.setParameter("fechaSalida", reserva.getFechaSalida());
			query.setParameter("formaPago", reserva.getFormaPago());
			query.setParameter("valor", reserva.getValor());
			ret = query.getSingleResult();
		}catch (Exception e){
//			e.printStackTrace();
			return null;
			//no se hace commit() ya que este método es solo para guardar los datos en la bd y aca solo consultamos
		}
		return ret;
	}

}
