package com.vonkazo.proyectofinal.util;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.vonkazo.proyectofinal.modelo.Modelo;

public class GestorJTable extends AbstractTableModel {
	private ArrayList<Modelo> modelos;

	public GestorJTable(ArrayList<Modelo> modelos) {
		this.modelos = modelos;
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public int getRowCount() {
		return 1;
	}

	@Override
	public Object getValueAt(int fila, int col) {
		switch (fila) {
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
	
	@Override
	public Class<?> getColumnClass(int col) {
		switch (col) {
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
	
	public int getIdFromRowPos(int rowPos) {
		int idCoche = modelos.get(rowPos).getId();
		return idCoche;
	}
}
