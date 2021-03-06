package com.vonkazo.proyectofinal.gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

import com.vonkazo.proyectofinal.modelo.Eficiencia;
import com.vonkazo.proyectofinal.modelo.ExceptionNombreIgual;
import com.vonkazo.proyectofinal.modelo.ExceptionNombreVacio;
import com.vonkazo.proyectofinal.modelo.Marca;
import com.vonkazo.proyectofinal.modelo.Modelo;
import com.vonkazo.proyectofinal.persistencia.GestorBBDD;
import com.vonkazo.proyectofinal.util.GestorJTable;

import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPanelCreacion extends JPanel {
	private JTextField tFModelo;
	private boolean pasa = false;
	private String mar;
	/**
	 * JPanel que utilizamos para realizar creacion de un modelo mediante varios
	 * jslider y combox Realiza un insert en una base de datos Solo inserta si hay
	 * conexion con la bbdd y si el nombre es correcto o no esta repetido
	 */
	public JPanelCreacion() {
		setLayout(new BorderLayout(0, 0));

		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(20, 14, 159, 14);
		panel.add(lblMarca);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(20, 65, 159, 14);
		panel.add(lblModelo);

		JLabel lblConsumokm = new JLabel("Consumo(0/100km)");
		lblConsumokm.setBounds(20, 116, 159, 14);
		panel.add(lblConsumokm);

		JLabel lblEmisionesgckm = new JLabel("Emisiones(gC02km)");
		lblEmisionesgckm.setBounds(20, 161, 159, 14);
		panel.add(lblEmisionesgckm);

		JLabel lblCalificacinEnergtica = new JLabel("Calificaci\u00F3n energ\u00E9tica");
		lblCalificacinEnergtica.setBounds(20, 202, 159, 14);
		panel.add(lblCalificacinEnergtica);

		JComboBox<String> cBMarcas = new JComboBox<String>();
		cBMarcas.setBounds(204, 11, 169, 20);
		panel.add(cBMarcas);

		JComboBox<String> cBEficiencia = new JComboBox<String>();
		cBEficiencia.setBounds(204, 199, 208, 20);
		panel.add(cBEficiencia);

		tFModelo = new JTextField();
		tFModelo.setBounds(204, 62, 169, 20);
		panel.add(tFModelo);
		tFModelo.setColumns(10);

		JLabel lConsumoContador = new JLabel("0");
		lConsumoContador.setBounds(383, 110, 46, 20);
		panel.add(lConsumoContador);

		JSlider sConsumo = new JSlider();
		sConsumo.setMaximum(205);
		sConsumo.setValue(0);
		sConsumo.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				lConsumoContador.setText(String.valueOf(sConsumo.getValue()));
			}
		});
		sConsumo.setMinorTickSpacing(1);
		sConsumo.setMajorTickSpacing(5);
		sConsumo.setBounds(204, 116, 169, 14);
		panel.add(sConsumo);

		JLabel lEmisionesContador = new JLabel("0");
		lEmisionesContador.setBounds(383, 155, 46, 20);
		panel.add(lEmisionesContador);

		JSlider sEmisiones = new JSlider();
		sEmisiones.setMajorTickSpacing(5);
		sEmisiones.setMaximum(999);
		sEmisiones.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lEmisionesContador.setText(String.valueOf(sEmisiones.getValue()));
			}
		});
		sEmisiones.setValue(0);
		sEmisiones.setBounds(204, 161, 169, 14);
		panel.add(sEmisiones);

		try {
			GestorBBDD gb = new GestorBBDD();

			for (Marca m : gb.cargaMarcas()) {
				cBMarcas.addItem(m.getMarca());
			}

			for (Eficiencia e : gb.cargaCalificacionEnergetica()) {
				cBEficiencia.addItem(e.getcEnergetica());
			}

			gb.cerrarConexion();
		} catch (ClassNotFoundException e1) {
			JOptionPane.showMessageDialog(null, "Error carga driver");
		} catch (SQLException e1) {
			if (e1.getErrorCode() == 0) {
				JOptionPane.showMessageDialog(null, "Fallo en la conexion con el servidor");
			} else {
				JOptionPane.showMessageDialog(null,
						"Error SQL: " + e1.getErrorCode() + " (Consultalo con un administrador)");
			}

		}

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					GestorBBDD gb = new GestorBBDD();
					String eficiencia = cBEficiencia.getSelectedItem().toString();
					for (Modelo mo : gb.cargaModelos()) {
						if (mo.getModelo().equalsIgnoreCase(tFModelo.getText())) {
							throw new ExceptionNombreIgual();
						} else if (tFModelo.getText().trim().length() == 0) {
							throw new ExceptionNombreVacio();
						} else {
							mar = cBMarcas.getSelectedItem().toString();
							int tmp = gb.cargaMarcaEspecifica(mar);
							gb.insertarModelo(tmp, tFModelo.getText(),
									(float) sConsumo.getValue(), (float) sEmisiones.getValue(), eficiencia);
							break;
						}
						

					}

					gb.cerrarConexion();
					JOptionPane.showMessageDialog(null, "Modelo insertado con exito");

				} catch (SQLException e) {
					if (e.getErrorCode() == 0) {
						JOptionPane.showMessageDialog(null, "Fallo en la conexion con el servidor");
					} else {
						JOptionPane.showMessageDialog(null,
								"Error SQL: " + e.getErrorCode() + " (Consultalo con un administrador)");
					}
				} catch (ClassNotFoundException e) {
					JOptionPane.showMessageDialog(null, "Error carga driver");
				} catch (ExceptionNombreIgual e) {
					JOptionPane.showMessageDialog(null, "Ese modelo ya existe");
				} catch (ExceptionNombreVacio e) {
					JOptionPane.showMessageDialog(null, "El modelo esta vacio");
				}
			}
		});
		toolBar.add(btnGuardar);

	}
}
