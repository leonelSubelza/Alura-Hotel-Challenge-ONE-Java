package com.hotelAlura.core.dao;

import java.time.LocalDate;
import java.util.List;
import com.hotelAlura.core.model.Huesped;
import com.hotelAlura.core.model.Reserva;

import javax.persistence.EntityManager;
import javax.swing.*;
import javax.transaction.Transactional;

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

	@Transactional
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

    @Transactional
	public void actualizar(Long id, String nombre, String apellido, LocalDate fechaNac, String nacionalidad, String tel, Reserva reserva) {
		try{
			em.getTransaction().begin();
			this.em.merge(new Huesped(id,nombre,apellido,fechaNac,nacionalidad,tel,reserva));
			em.getTransaction().commit();
		}catch (Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error al actualizar entidad");
		}

    }
}
