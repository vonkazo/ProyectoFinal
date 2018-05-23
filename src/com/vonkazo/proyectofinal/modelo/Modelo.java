package com.vonkazo.proyectofinal.modelo;

public class Modelo {
	private int id;
	private int id_marca;
	private String marca;
	private float consumo;
	private float emisiones;
	private char c_energetica;

	public Modelo(int id, int id_marca, String marca, float consumo, float emisiones, char c_energetica) {
		this.id = id;
		this.id_marca = id_marca;
		this.marca = marca;
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

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
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

	public char getC_energetica() {
		return c_energetica;
	}

	public void setC_energetica(char c_energetica) {
		this.c_energetica = c_energetica;
	}

}
