package com.latam.alura.tienda.prueba;

import java.io.FileNotFoundException;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.modelo.Pedido;
import com.latam.alura.tienda.utils.JPAUtils;


public class PruebaDeDesempenho {
	public static void main(String[] args) throws FileNotFoundException {
		LoadRecords.cargarRegistros();
		
		EntityManager em = JPAUtils.getEntityManager();
		Pedido pedido = em.find(Pedido.class, 3L);
		
		System.out.println("fecha del pedido "+pedido.getFecha());
		
		System.out.println("Items del pedido "+pedido.getItems().size());
	}
}
