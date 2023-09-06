package com.latam.alura.tienda.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.modelo.Pedido;
import com.latam.alura.tienda.vo.relatorioDeVenta;

public class PedidoDao {
	
	private EntityManager em;

	public PedidoDao(EntityManager em) {
		this.em = em;
	}
	
	public void guardar(Pedido pedido) {
		this.em.persist(pedido);
	}
		
	public void actualizar(Pedido pedido) {
		this.em.merge(pedido);
	}
	
	public void remover(Pedido pedido) {
		pedido=this.em.merge(pedido);
		this.em.remove(pedido); 
	}
	
	public Pedido consultaPorId(Long id) {
		return em.find(Pedido.class, id);
	}
	
	public List<Pedido> consultarTodos(){
		String jqpl= "SELECT P FROM Pedido AS P";
		return em.createQuery(jqpl,Pedido.class).getResultList();
	}
	
	public BigDecimal valorTotalVendido() {
		String jqpl= "SELECT SUM(p.valorTotal) FROM Pedido p";
		return em.createQuery(jqpl, BigDecimal.class).getSingleResult();
	}
	
	public List<Object[]> relatorioDeVentas(){
		String jpql = "SELECT producto.nombre, "
				+ "SUM(item.cantidad),"
				+ "MAX(pedido.fecha) "
				+ "FROM Pedido pedido "
				+ "JOIN pedido.items item "
				+ "JOIN item.producto producto "
				+ "GROUP BY producto.nombre "
				+ "GROUP BY item.cantidad DESC ";
		return em.createQuery(jpql,Object[].class).getResultList();
	}
	
	public List<relatorioDeVenta> relatorioDeVentasVO(){
		String jpql = "SELECT new com.latam.alura.tienda.vo.RelatorioDeVenta(producto.nombre, "
				+ "SUM(item.cantidad),"
				+ "MAX(pedido.fecha)) "
				+ "FROM Pedido pedido "
				+ "JOIN pedido.items item "
				+ "JOIN item.producto producto "
				+ "GROUP BY producto.nombre "
				+ "GROUP BY item.cantidad DESC ";
		return em.createQuery(jpql,relatorioDeVenta.class).getResultList();
	}
	
	// faltaria consultaPorFecha(){}

	
}
