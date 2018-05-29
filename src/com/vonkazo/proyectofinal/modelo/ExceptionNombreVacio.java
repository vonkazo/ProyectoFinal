package com.vonkazo.proyectofinal.modelo;

/**
 * Clase que hereda de Exception que tratamos en la vista al insertar datos
 * Si el nombre del modelo esta vacio o solo contiene espacios la lanza
 * @author Vonkazo
 *
 */
public class ExceptionNombreVacio extends Exception{
	public ExceptionNombreVacio () {
		super();
	}
}
