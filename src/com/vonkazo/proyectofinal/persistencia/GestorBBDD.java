package com.vonkazo.proyectofinal.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.sql.PreparedStatement;
import com.vonkazo.proyectofinal.modelo.Eficiencia;
import com.vonkazo.proyectofinal.modelo.Marca;
import com.vonkazo.proyectofinal.modelo.Modelo;
/**
 * Clase que gestiona la conexion con la BBDD
 * Carga el driver y la conexion por las constantes que tiene
 * @author Vonkazo
 *
 */
public class GestorBBDD {
	private final static String DRIVER = "com.mysql.jdbc.Driver";
	private final static String BBDD = "jdbc:mysql://localhost:3306/bbdd_gestmotor";
	private final static String USER = "dam2018";
	private final static String PASSWORD = "dam2018";
	private Connection conexion;
	/**
	 * Constructor donde cargamos el driver y la conexion de la bbdd
	 * @throws ClassNotFoundException si no carga el driver
	 * @throws SQLException si devuelve un fallo la conexion
	 */
	public GestorBBDD() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		cargarConexion();
	}
	/**
	 * Metodo para cargar la conexion
	 * @throws SQLException arroja una excepcion si hay algun fallo al cargar conexion
	 */
	private void cargarConexion() throws SQLException {
		conexion = DriverManager.getConnection(BBDD, USER, PASSWORD);
	}
	/**
	 * Metodo para cerra conexion
	 * @throws SQLException
	 */
	public void cerrarConexion() throws SQLException {
		conexion.close();
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

	/**
	 * Metodo que devuelve un arraylist y que utilizamos en la vista para obtener en
	 * el combobox las marcas
	 * @return un arraylist de Marca con todas las marcas
	 * @throws SQLException
	 */
	public ArrayList<Marca> cargaMarcas() throws SQLException {
		Marca m;
		ResultSet rs = null;
		Statement st = null;
		ArrayList<Marca> aLMarcas = new ArrayList<Marca>();

		String query = "SELECT DISTINCT * FROM marcas";
		st = conexion.createStatement();

		rs = st.executeQuery(query);
		while (rs.next() == true) {
			m = new Marca(rs.getInt(1), rs.getString(2));
			aLMarcas.add(m);
		}

		rs.close();
		st.close();
		return aLMarcas;
	}

	/**
	 * Metodo que devuelve un arraylist y que utilizamos en la vista para obtener en
	 * el combobox la calificacion energetica
	 * @return un arraylist de Eficienci con todas las Calificaciones energeticas
	 * @throws SQLException
	 */
	public ArrayList<Eficiencia> cargaCalificacionEnergetica() throws SQLException {
		Eficiencia e;
		ResultSet rs = null;
		Statement st = null;
		ArrayList<Eficiencia> aLEficiencia = new ArrayList<Eficiencia>();

		String query = "SELECT DISTINCT * FROM eficiencias";
		st = conexion.createStatement();

		rs = st.executeQuery(query);
		while (rs.next() == true) {
			e = new Eficiencia(rs.getString(1), rs.getString(2), rs.getString(3));
			aLEficiencia.add(e);
		}

		rs.close();
		st.close();
		return aLEficiencia;
	}

	/**
	 * Metodo que devuelve un arraylist y que utilizamos en la vista para obtener en
	 * el combobox los modelos
	 * @return un arraylist de Modelo con todas los modelos
	 * @throws SQLException
	 */
	public ArrayList<Modelo> cargaModelos() throws SQLException {
		Modelo m;
		ResultSet rs = null;
		Statement st = null;
		ArrayList<Modelo> aLModelos = new ArrayList<Modelo>();

		String query = "SELECT DISTINCT * FROM modelos";
		st = conexion.createStatement();

		rs = st.executeQuery(query);
		while (rs.next() == true) {
			m = new Modelo(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getFloat(4), rs.getFloat(5),
					rs.getString(6));
			aLModelos.add(m);
		}

		rs.close();
		st.close();
		return aLModelos;
	}

	/**
	 * Metodo con el que insertamos una tupla en la tabla modelos y ademas
	 * devolvemos un boolean dependiendo de si se ha insertado bien o no
	 * @param id_marca
	 * @param modelo
	 * @param consumo
	 * @param emisiones
	 * @param c_energetica
	 * @return boolean dependiendo de si se inserta correctamente o no
	 * @throws SQLException
	 */
	public boolean insertarModelo(int id_marca, String modelo, float consumo, float emisiones, String c_energetica)
			throws SQLException {

		boolean insertado = false;
		String sql = "INSERT INTO modelos(ID_MARCA, MODELO, CONSUMO, EMISIONES, C_ENERGETICA) VALUES(?,?,?,?,?)";
		PreparedStatement ps = conexion.prepareStatement(sql);
		ps.setInt(1, id_marca);
		ps.setString(2, modelo);
		ps.setFloat(3, consumo);
		ps.setFloat(4, emisiones);
		ps.setString(5, c_energetica);
		int numRegistrosInsertados = ps.executeUpdate();
		conexion.setAutoCommit(true);

		if (numRegistrosInsertados == 1) {
			insertado = true;
		}
		return insertado;
	}
}
