package com.latam.alura.tienda.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="pedidos")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private LocalDate fecha=LocalDate.now();
	@Column(name="valor_total")
	private BigDecimal valorTotal=new BigDecimal(0);
	// un cliente(one) tiene muchos pedidos (Many)
	@ManyToOne(fetch=FetchType.LAZY)   	
	private Cliente cliente;
	// un pedido puede tener multiples productos
//	@ManyToMany
//	@JoinTable(name="items-pedido")
//	List<Producto> productos;

	// tratamiento bidireccional
	@OneToMany(mappedBy="pedido",cascade=CascadeType.ALL)
	//Items de pedido se agregan automatico a items pedido, add, remove, etc=prop. CASCADE 
	private List<ItemsPedido>  items=new ArrayList<>();  // Ahi se tiene una lista vacia
	
	public List<ItemsPedido> getItems() {
		return items;
	}

	public void setItems(List<ItemsPedido> items) {
		this.items = items;
	}

	public Pedido() {
	}
	
	// añadir valoers a la lista
	public void agregarItems(ItemsPedido item) {
		item.setPedido(this);
		this.items.add(item);
		this.valorTotal = this.valorTotal.add(item.getValor());
	}
	
	public Pedido(Cliente cliente) {
	//	super();
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
