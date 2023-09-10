package com.latam.alura.tienda.modelo;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable       // va hacer embebida en otra clase ej, categoria
public class CategoriaId implements Serializable {
	private String nombre;
	private String password;
	
	public CategoriaId() {
	//	super();
	}

	public CategoriaId(String nombre, String password) {
		//super();
		this.nombre = nombre;
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// elementos unicos clase hashCode()
	@Override
	public int hashCode() {
		return Objects.hash(nombre, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoriaId other = (CategoriaId) obj;
		return Objects.equals(nombre, other.nombre) && Objects.equals(password, other.password);
	}

	
}
