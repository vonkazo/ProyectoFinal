package com.vonkazo.proyectofinal.modelo;
/**
 * Clase que utilizamos para obtener datos de la tabla eficiencias de la bbdd
 * @author Vonkazo
 *
 */
public class Eficiencia {
	private String cEnergetica;
	private String descripcion;
	private String icono;
	
	/**
	 * Constructor que recibe los valores de la tabla eficiencias
	 * @param cEnergetica
	 * @param descripcion
	 * @param icono
	 */
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
