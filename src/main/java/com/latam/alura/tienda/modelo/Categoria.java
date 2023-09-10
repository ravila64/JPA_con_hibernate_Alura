package com.latam.alura.tienda.modelo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="categorias")
public class Categoria {

	// se quito mapenado llaves compuestas
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private Long id;
//	private String nombre;
	
	@EmbeddedId
	private CategoriaId categoriaId;
	
	public Categoria() {}
	
	public Categoria(CategoriaId categoriaId) {
//		super();
		this.categoriaId = categoriaId;
	}

	public Categoria(String nombre) {
		this.categoriaId = new CategoriaId(nombre,"1224");
	}
	
	public String getNombre() {
		return categoriaId.getNombre();
	}
	
	public void setNombre(String nombre) {
		this.categoriaId.setNombre(nombre);
	}

}
