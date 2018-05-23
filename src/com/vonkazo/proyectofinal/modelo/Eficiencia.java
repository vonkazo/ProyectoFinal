package com.vonkazo.proyectofinal.modelo;

public class Eficiencia {
	private String cEnergetica;
	private String descripcion;
	private String icono;
	
	public Eficiencia(String cEnergetica, String descripcion, String icono) {
		this.cEnergetica = cEnergetica;
		this.descripcion = descripcion;
		this.icono = icono;
	}
	public String getcEnergetica() {
		return cEnergetica;
	}
	public void setcEnergetica(String cEnergetica) {
		this.cEnergetica = cEnergetica;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getIcono() {
		return icono;
	}
	public void setIcono(String icono) {
		this.icono = icono;
	}
	
}
