package com.vonkazo.proyectofinal.util;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.vonkazo.proyectofinal.modelo.Modelo;
/**
 * Clase con la que gestionamos la tabla en la que se muestran
 * los datos de la tabla modelos
 * Utilizamos un arraylist con objetos de la clase modelo
 * @author Vonkazo
 *
 */
public class GestorJTable extends AbstractTableModel {
	private ArrayList<Modelo> modelos;
	
	/**
	 * Este constructor recibe un arraylist de la clase modelo
	 * que luego utilizaremos para crear en la vista el jtable
	 * @param modelos
	 */
	public GestorJTable(ArrayList<Modelo> modelos) {
		this.modelos = modelos;
	}
	/**
	 * Metodo para obtener las columnas de la tabla
	 */
	@Override
	public int getColumnCount() {
		return 4;
	}
	/**
	 * Metodo para obtener el numero de filas que mostraremos
	 */
	@Override
	public int getRowCount() {
		return modelos.size();
	}
	/**
	 * Metodo para rellenar los datos en cada celda del jtable
	 */
	@Override
	public Object getValueAt(int fila, int col) {
		switch (col) {
		case 0:
			return modelos.get(fila).getModelo();
		case 1:
			return modelos.get(fila).getConsumo();
		case 2:
			return modelos.get(fila).getEmisiones();
		default:
			return modelos.get(fila).getC_energetica();
		}
	}
	/**
	 * Metodo para poner titulo a cada columna
	 */
	@Override
	public String getColumnName(int colu) {
		switch (colu) {
		case 0:
			return "Modelo";
		case 1:
			return "Consumo";
		case 2:
			return "Emisiones";
		default:
			return "Consumo Energetico";
		}
	}
	/**
	 * Metodo que utilizamos para obtener el tipo de cada columna
	 */
	@Override
	public Class<?> getColumnClass(int colum) {
		switch (colum) {
		case 0:
			return String.class;
		case 1:
			return float.class;
		case 2:
			return float.class;
		default:
			return String.class;
		}
	}
	/**
	 * Metodo que utilizamos para obtener el id del modelo seleccionado
	 * en el jtable
	 * @param rowPos posicion (id)
	 * @return
	 */
	public int getIdFromRowPos(int rowPos) {
		int idCoche = modelos.get(rowPos).getId();
		return idCoche;
	}
}
