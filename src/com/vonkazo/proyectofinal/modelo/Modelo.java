package com.vonkazo.proyectofinal.modelo;
/**
 * Clase modelo que rellenamos con los datos de la tabla modelos de la base de datos
 * @author Vonkazo
 *
 */
public class Modelo {
	private int id;
	private int id_marca;
	private String modelo;
	private float consumo;
	private float emisiones;
	private String c_energetica;
	/**
	 * Constructor de la clase que recibe los datos de la BBDD
	 * @param id
	 * @param id_marca
	 * @param modelo
	 * @param consumo
	 * @param emisiones
	 * @param c_energetica
	 */
	public Modelo(int id, int id_marca, String modelo, float consumo, float emisiones, String c_energetica) {
		this.id = id;
		this.id_marca = id_marca;
		this.modelo = modelo;
		this.consumo = consumo;
		this.emisiones = emisiones;
		this.c_energetica = c_energetica;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_marca() {
		return id_marca;
	}

	public void setId_marca(int id_marca) {
		this.id_marca = id_marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String marca) {
		this.modelo = marca;
	}

	public float getConsumo() {
		return consumo;
	}

	public void setConsumo(float consumo) {
		this.consumo = consumo;
	}

	public float getEmisiones() {
		return emisiones;
	}

	public void setEmisiones(float emisiones) {
		this.emisiones = emisiones;
	}

	public String getC_energetica() {
		return c_energetica;
	}

	public void setC_energetica(String c_energetica) {
		this.c_energetica = c_energetica;
	}

}
