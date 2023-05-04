package com.hotelAlura.HotelAlura.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.hotelAlura.HotelAlura.model.Usuario;


public class UsuarioDAO {

	private EntityManager em;
	
	public UsuarioDAO(EntityManager em2) {
		this.em = em2;
	}
	
	public void guardar(Usuario usuario) {
		this.em.persist(usuario);
	}
	
	public void actualizar(Usuario usuario) {
		this.em.merge(usuario);
	}
	
	public void remover(Usuario usuario) {
		usuario=this.em.merge(usuario);
		this.em.remove(usuario);
	}
	
	public Usuario consultaPorId(Long id) {
		return em.find(Usuario.class, id);
	}
	
	public List<Usuario> consultarTodos(){
		String jqpl= "SELECT U FROM Usuario AS U";
		return em.createQuery(jqpl,Usuario.class).getResultList();
	}
	
	//nose como funciona
	
	public Usuario exist(String nombre, String contrasena) {
	    TypedQuery<Usuario> query = em.createQuery(
	        "SELECT U FROM Usuario U WHERE U.nombre = :nombre AND U.contrasena = :contrasena", Usuario.class);
	    query.setParameter("nombre", nombre);
	    query.setParameter("contrasena", contrasena);

	    try {
	        return query.getSingleResult();
	    } catch (NoResultException ex) {
	        return null;
	    }
	}
	
}
