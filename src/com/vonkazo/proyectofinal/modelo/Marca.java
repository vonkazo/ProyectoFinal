package com.vonkazo.proyectofinal.modelo;
/**
 * Clase que utilizamos para obtener datos de la tabla marcas de la bbdd
 * @author Vonkazo
 *
 */
public class Marca {
	private int id;
	private String marca;
	
	/**
	 * Constructor que recibe los valores de la tabla marcas
	 * @param id
	 * @param marca
	 */
	public Marca(int id, String marca) {
		this.id = id;
		this.marca = marca;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	
}
