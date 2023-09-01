package com.latam.alura.tienda.dao;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.modelo.Categoria;

public class CategoriaDao {
	
	private EntityManager em;

	public CategoriaDao(EntityManager em) {
		this.em = em;
	}
	
	public void guardar(Categoria categoria) {
		this.em.persist(categoria);
	}
	
	public void actualizar(Categoria categoria) {
		this.em.merge(categoria);
	}
	
	public void remover(Categoria categoria) {
		categoria=this.em.merge(categoria);
		this.em.remove(categoria);
	}

	@Override
	public String toString() {
		return "CategoriaDao [em=" + em + "]";
	}

	
//	public Categoria consultarPorNombre(String nombre) {
//		String jpql =" SELECT C FROM Categotia AS C WHERE C.nombre=:nombre ";
//		return em.createQuery(jpql,Categoria.class).setParameter("nombre", nombre).getResultList();
//	}
	
}
