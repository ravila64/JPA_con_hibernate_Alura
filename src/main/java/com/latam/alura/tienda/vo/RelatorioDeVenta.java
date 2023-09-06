package com.latam.alura.tienda.vo;

import java.time.LocalDate;

public class RelatorioDeVenta {
	private String nombreProducto;
	private Long cantProducto;
	private LocalDate FechaUltimaVenta;
	
	public RelatorioDeVenta(String nombreProducto, Long cantProducto, LocalDate fechaUltimaVenta) {
		this.nombreProducto = nombreProducto;
		this.cantProducto = cantProducto;
		FechaUltimaVenta = fechaUltimaVenta;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public Long getCantProducto() {
		return cantProducto;
	}

	public void setCantProducto(Long cantProducto) {
		this.cantProducto = cantProducto;
	}

	public LocalDate getFechaUltimaVenta() {
		return FechaUltimaVenta;
	}

	public void setFechaUltimaVenta(LocalDate fechaUltimaVenta) {
		FechaUltimaVenta = fechaUltimaVenta;
	}

	@Override
	public String toString() {
		return "relatorioDeVenta [nombreProducto=" + nombreProducto + ", cantProducto=" + cantProducto
				+ ", FechaUltimaVenta=" + FechaUltimaVenta + "]";
	}
	
}
