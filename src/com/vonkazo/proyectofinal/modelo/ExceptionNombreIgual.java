package com.vonkazo.proyectofinal.modelo;
/**
 * Clase que hereda de Exception que tratamos en la vista al insertar datos
 * Si el nombre del modelo es igual a uno en la bbdd la lanza
 * @author Vonkazo
 *
 */
public class ExceptionNombreIgual extends Exception{
	public ExceptionNombreIgual () {
		super();
	}
}
