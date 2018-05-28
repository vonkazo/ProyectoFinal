package com.vonkazo.proyectofinal.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.vonkazo.proyectofinal.util.GestorJTable;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Jframe (Vista) principal de la aplicacion
 * En este mostraremos diferentes jpanel dependiendo de que quiera
 * el usuario
 */
public class jFramePrincipal extends JFrame {
	// Jpanel de la aplicacion
	private JPanel contentPane;
	private JPanelCreacion creacion;
	private JPanelConsultar consulta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jFramePrincipal frame = new jFramePrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public jFramePrincipal() {
		setTitle("Concesionario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 699, 514);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnArchivo.add(mntmSalir);
		
		JMenu mnModelos = new JMenu("Modelos");
		menuBar.add(mnModelos);
		
		JMenuItem mntmCrear = new JMenuItem("Crear");
		mntmCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cambiarPantalla("PanelCreacion");
			}
		});
		mnModelos.add(mntmCrear);
		
		JMenuItem mntmConsultar = new JMenuItem("Consultar");
		mntmConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarPantalla("PanelConsulta");
			}
		});
		mnModelos.add(mntmConsultar);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAyuda = new JMenuItem("Ayuda");
		mnAyuda.add(mntmAyuda);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de");
		mnAyuda.add(mntmAcercaDe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		creacion = new JPanelCreacion();
		consulta = new JPanelConsultar();
		contentPane.setLayout(new CardLayout(0, 0));
		
		contentPane.add(consulta, "PanelConsulta");
		contentPane.add(creacion, "PanelCreacion");
	}
	
	private void cambiarPantalla(String nombre) {
		((CardLayout)contentPane.getLayout()).show(contentPane, nombre);
	}
}
