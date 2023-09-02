package com.latam.alura.tienda.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.modelo.Cliente;

public class ClienteDao {
	
	private EntityManager em;

	public ClienteDao(EntityManager em) {
		this.em = em;
	}
	
	public void guardar(Cliente cliente) {
		this.em.persist(cliente);
	}
	
	
	public void actualizar(Cliente cliente) {
		this.em.merge(cliente);
	}
	
	public void remover(Cliente cliente) {
		cliente=this.em.merge(cliente);
		this.em.remove(cliente); 
	}
	
	public Cliente consultaPorId(Long id) {
		return em.find(Cliente.class, id);
	}
	
	public List<Cliente> consultarTodos(){
		String jqpl= "SELECT C FROM Cliente AS C";
		return em.createQuery(jqpl,Cliente.class).getResultList();
	}
	
	public List<Cliente> consultaPorNombre(String nombre){
		String jpql =" SELECT C FROM Cliente AS C WHERE C.nombre=:nombre ";
		return em.createQuery(jpql,Cliente.class).setParameter("nombre", nombre).getResultList();
	}
	
	public List<Cliente> consultaPorDNI(String dni){
		String jpql="SELECT C FROM Cliente AS C WHERE C.dni=:dni";
		return em.createQuery(jpql,Cliente.class).setParameter("dni", dni).getResultList();
	}
	 
}
