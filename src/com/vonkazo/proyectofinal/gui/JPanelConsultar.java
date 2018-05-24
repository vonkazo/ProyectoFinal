package com.vonkazo.proyectofinal.gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JToolBar;

import com.vonkazo.proyectofinal.modelo.Eficiencia;
import com.vonkazo.proyectofinal.modelo.Marca;
import com.vonkazo.proyectofinal.modelo.Modelo;
import com.vonkazo.proyectofinal.persistencia.GestorBBDD;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JPanelConsultar extends JPanel {
	private JTable tTablaConsulta;

	/**
	 * Create the panel.
	 */
	public JPanelConsultar() {		
		setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(null);
		toolBar.add(btnBuscar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setIcon(null);
		toolBar.add(btnEditar);
		
		JButton btnEliminar = new JButton("Eliminiar");
		btnEliminar.setIcon(null);
		toolBar.add(btnEliminar);
		
		JButton btnExportar = new JButton("Exportar");
		btnExportar.setIcon(null);
		toolBar.add(btnExportar);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JRadioButton rdbtnMarca = new JRadioButton("Marca");
		rdbtnMarca.setBounds(6, 10, 109, 23);
		panel.add(rdbtnMarca);
		
		JRadioButton radioConsumo = new JRadioButton("Consumo");
		radioConsumo.setBounds(6, 51, 109, 23);
		panel.add(radioConsumo);
		
		JRadioButton rdbtnEmisionesMaximas = new JRadioButton("Emisiones maximas");
		rdbtnEmisionesMaximas.setBounds(6, 88, 115, 23);
		panel.add(rdbtnEmisionesMaximas);
		
		JRadioButton rdbtnClasificacion = new JRadioButton("Clasificacion");
		rdbtnClasificacion.setBounds(6, 124, 109, 23);
		panel.add(rdbtnClasificacion);
		
		JComboBox cbMarca = new JComboBox();
		cbMarca.setBounds(196, 11, 153, 20);
		panel.add(cbMarca);
		
		JComboBox cbClasificacion = new JComboBox();
		cbClasificacion.setBounds(196, 125, 200, 20);
		panel.add(cbClasificacion);
		
		JSlider slConsumo = new JSlider();
		slConsumo.setValue(0);
		slConsumo.setMaximum(205);
		slConsumo.setBounds(192, 51, 200, 26);
		panel.add(slConsumo);
		
		JSlider slEmisiones = new JSlider();
		slEmisiones.setValue(0);
		slEmisiones.setBounds(192, 88, 200, 26);
		panel.add(slEmisiones);
		
		JScrollPane sPContenedorTabla = new JScrollPane();
		sPContenedorTabla.setBounds(10, 172, 619, 199);
		panel.add(sPContenedorTabla);
		
		tTablaConsulta = new JTable();
		sPContenedorTabla.setViewportView(tTablaConsulta);
		
		try {
			GestorBBDD gb = new GestorBBDD();
			
			for (Marca m : gb.cargaMarcas()) {
				cbMarca.addItem(m.getMarca());
			}
			
			for (Eficiencia e : gb.cargaCalificacionEnergetica()) {
				cbClasificacion.addItem(e.getDescripcion());
			}
			gb.cerrarConexion();
		} catch (ClassNotFoundException e1) {
			System.out.println("Error en carga del driver");
		} catch (SQLException e1) {
			System.out.println();
		}
	}
}
