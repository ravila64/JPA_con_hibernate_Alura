package com.latam.alura.tienda.modelo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="items_pedido")
public class ItemsPedido {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private int cantidad;
	private BigDecimal precioUnitario;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Producto producto;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Pedido pedido;
	// example atemped 1 prod 1 ped 2
	// example atemped 2 prod 2 ped 2
	// example atemped 3 prod 1 ped 1
	// example atemped 4 prod 2 ped 1
	
	// constructor
	public ItemsPedido() {
	}
	
	public ItemsPedido(int cantidad, Producto producto, Pedido pedido) {
		this.cantidad = cantidad;
		this.producto = producto;
		this.pedido = pedido;
		this.precioUnitario = producto.getPrecio(); // agregar el precio unitario
	}
	
	// getters and setters
	
	public Long getId() {
		return id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public Producto getProducto() {
		return producto;
	}
	
	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	// metodo para valor total
	public BigDecimal getValor() {
		BigDecimal vt = this.precioUnitario.multiply(new BigDecimal(this.cantidad));
		return vt;
	}
	
	
}
