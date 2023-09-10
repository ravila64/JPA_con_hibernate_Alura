package com.latam.alura.tienda.modelo;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Embedded
	private DatosPersonales datosPersonales;
	
	public Cliente() {}
	
	public Cliente(String nombre,String dni) {
		this.datosPersonales=new DatosPersonales(nombre, dni);
	}
	
	public Long getId() {
		return id;
	}
	public String getDni() {
		return datosPersonales.getDni();
	}

	public String getNombre() {
		return datosPersonales.getNombre();
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public void setNombre(String nombre) {
		this.datosPersonales.setNombre(nombre);
	}

	public void setDni(String dni) {
		this.datosPersonales.setDni(dni);
	}

//	public void setDatosPersonales(DatosPersonales datosPersonales) {
//		this.datosPersonales = datosPersonales;
//	}
		

}
