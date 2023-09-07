package com.latam.alura.tienda.prueba;

import java.io.FileNotFoundException;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.dao.PedidoDao;
import com.latam.alura.tienda.modelo.Pedido;
import com.latam.alura.tienda.utils.JPAUtils;


public class PruebaDeDesempenho {
	public static void main(String[] args) throws FileNotFoundException {
		LoadRecords.cargarRegistros();
		
		EntityManager em = JPAUtils.getEntityManager();
//		Pedido pedido = em.find(Pedido.class, 3L);
		PedidoDao pedidoDAO = new PedidoDao(em);
		Pedido pedidoConCliente = pedidoDAO.consultarPedidoConCliente(2L);    // (id)
		
		em.close();
		
		//System.out.println("fecha del pedido "+pedido.getFecha());
		//System.out.println("Items del pedido "+pedido.getItems().size());
		//System.out.println("Items del pedido "+pedido.getCliente().getNombre());
		System.out.println("Items del pedido "+pedidoConCliente.getCliente().getNombre());
	}
}
