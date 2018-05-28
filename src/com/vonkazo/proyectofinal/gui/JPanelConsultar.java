package com.vonkazo.proyectofinal.gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;

import com.vonkazo.proyectofinal.modelo.Eficiencia;
import com.vonkazo.proyectofinal.modelo.Marca;
import com.vonkazo.proyectofinal.modelo.Modelo;
import com.vonkazo.proyectofinal.persistencia.GestorBBDD;
import com.vonkazo.proyectofinal.util.GestorJTable;

import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPanelConsultar extends JPanel {
	private JTable tTablaConsulta;
	private GestorJTable gjt;
	ArrayList<Modelo> modelos;

	/**
	 * En este panel se mostrara una jtable con 100 tuplas en la que podremos
	 * filtrar por diferente datos
	 */
	public JPanelConsultar() {
		setLayout(new BorderLayout(0, 0));

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

		// Grupo botones
		ButtonGroup radios = new ButtonGroup();
		radios.add(rdbtnMarca);
		radios.add(radioConsumo);
		radios.add(rdbtnEmisionesMaximas);
		radios.add(rdbtnClasificacion);

		JComboBox<String> cbMarca = new JComboBox<String>();
		cbMarca.setBounds(196, 11, 153, 20);
		panel.add(cbMarca);

		JComboBox<String> cbClasificacion = new JComboBox<String>();
		cbClasificacion.setBounds(196, 125, 200, 20);
		panel.add(cbClasificacion);

		JSlider slConsumo = new JSlider();
		slConsumo.setValue(0);
		slConsumo.setMaximum(205);
		slConsumo.setMinorTickSpacing(1);
		slConsumo.setMajorTickSpacing(5);
		slConsumo.setBounds(192, 51, 200, 26);
		panel.add(slConsumo);

		JSlider slEmisiones = new JSlider();
		slEmisiones.setValue(0);
		slEmisiones.setMinorTickSpacing(1);
		slEmisiones.setMajorTickSpacing(5);
		slEmisiones.setBounds(192, 88, 200, 26);
		panel.add(slEmisiones);

		JScrollPane sPContenedorTabla = new JScrollPane();
		sPContenedorTabla.setBounds(10, 172, 619, 199);
		panel.add(sPContenedorTabla);
		// Jtable
		tTablaConsulta = new JTable();
		sPContenedorTabla.setViewportView(tTablaConsulta);
		tTablaConsulta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// Realizamos un try para la conexion con la base de datos
		try {
			GestorBBDD gb = new GestorBBDD();
			// Realizamos la vista de la tabla y le pasamos el array
			gjt = new GestorJTable(gb.cargaModelos());
			tTablaConsulta.setModel(gjt);
			// Rellenamos los combobox de la vista
			for (Marca m : gb.cargaMarcas()) {
				cbMarca.addItem(m.getMarca());

			}

			for (Eficiencia e : gb.cargaCalificacionEnergetica()) {
				cbClasificacion.addItem(e.getcEnergetica());
			}
			// Cerramos conexion
			gb.cerrarConexion();
		} catch (ClassNotFoundException e1) {
			System.out.println("Error en carga del driver");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Boton buscar
				try {
					GestorBBDD gb = new GestorBBDD();
					if (radios.getSelection() == rdbtnMarca.getModel()) {
						gjt = new GestorJTable(gb.consultaSegunMarca(cbMarca.getSelectedItem().toString()));
						tTablaConsulta.setModel(gjt);
					} else if (radios.getSelection() == radioConsumo.getModel()) {
						gjt = new GestorJTable(gb.consultaSegunConsumo((float)slConsumo.getValue()));
						tTablaConsulta.setModel(gjt);
						System.out.println("consumos <= " + (float)(float)slConsumo.getValue());
					}

					gb.cerrarConexion();
				} catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "Error carga driver");
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Error SQL: " + e1.getErrorCode());
				}
			}
		});
		btnBuscar.setIcon(null);
		toolBar.add(btnBuscar);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Editar
			}
		});
		btnEditar.setIcon(null);
		toolBar.add(btnEditar);

		JButton btnEliminar = new JButton("Eliminiar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Eliminar
			}
		});
		btnEliminar.setIcon(null);
		toolBar.add(btnEliminar);

		JButton btnExportar = new JButton("Exportar");
		btnExportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Exportar
			}
		});
		btnExportar.setIcon(null);
		toolBar.add(btnExportar);
	}
}
