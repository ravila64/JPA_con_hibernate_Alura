package com.latam.alura.tienda.prueba;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.dao.CategoriaDao;
import com.latam.alura.tienda.dao.PedidoDao;
import com.latam.alura.tienda.dao.ProductoDao;
import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.tienda.modelo.Cliente;
import com.latam.alura.tienda.modelo.ItemsPedido;
import com.latam.alura.tienda.modelo.Pedido;
import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.utils.JPAUtils;

public class RegistroDePedido {

	public static void main(String[] args) {
		registrarProducto();
		
		EntityManager em = JPAUtils.getEntityManager();
		ProductoDao productoDAO = new ProductoDao(em);
		Producto producto = productoDAO.consultaPorId(1L);  // producto 1
				
		PedidoDao pedidoDAO = new PedidoDAO(em);
		
		Cliente cliente = new Cliente ("Rene A","kb24561");
		Pedido pedido = new Pedido(cliente);
		pedido.agregarItems(new ItemsPedido(5,producto, pedido));
		
	}

	private static void registrarProducto() {
		Categoria celulares = new Categoria("CELULARES");
		Producto celular = new Producto("Xiaomi Redmi", "Muy bueno", new BigDecimal("800"), celulares);
	    EntityManager em = JPAUtils.getEntityManager();
	    ProductoDao productoDao = new ProductoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);
        
	    em.getTransaction().begin();
	    
	    categoriaDao.guardar(celulares);
	    System.out.println("Guardo Categoria "+celulares.toString());
	    productoDao.guardar(celular);	
	    System.out.println("Guardo Producto "+celular.toString());
	    
	    em.getTransaction().commit();
	    em.close();
	}

}








