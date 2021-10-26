package app.clasesDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import app.connection.DBConnection;
import app.modelo.Carrito;
import app.modelo.Cliente;
import app.modelo.Libro;

public class DAOCarrito {

	private Connection con = null;
	public static DAOCarrito instance = null;

	public DAOCarrito() throws SQLException, ClassNotFoundException {
		con = DBConnection.getConnection();

	}

	public static DAOCarrito getInstance() throws SQLException, ClassNotFoundException {
		if (instance == null) {
			instance = new DAOCarrito();
		}
		return instance;
	}

	public int buscarUltimoIdCarrito() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT MAX(id_carrito) AS id_carrito FROM libreriadb.carrito");
		ResultSet result = ps.executeQuery();
		int idLibroNuevo = 0;
		if (result.next()) {
			idLibroNuevo = result.getInt("id_carrito") + 1;
		}
		result.close();
		ps.close();
		return idLibroNuevo;
	}

	public void insertarCarrito_DAO(int id_carrito, int id_cliente, int id_libro) throws SQLException {

		PreparedStatement ps = con.prepareStatement("INSERT INTO libreriadb.carrito VALUES (?,?,?)");
		ps.setInt(1, id_carrito);
		ps.setInt(2, id_cliente);
		ps.setInt(3, id_libro);

		ps.executeUpdate();
		ps.close();
	}

	public ArrayList<Carrito> listarCarrito() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM libreriadb.carrito");
		ResultSet result = ps.executeQuery();

		ArrayList<Carrito> listaLibros = null;
		while (result.next()) {
			if (listaLibros == null) {
				listaLibros = new ArrayList<Carrito>();
			}
			listaLibros.add(
					new Carrito(result.getInt("id_carrito"), result.getInt("id_cliente"), result.getInt("id_libro")));
		}
		result.close();
		ps.close();
		if (listaLibros == null) {
			return listaLibros = new ArrayList<Carrito>();
		} else {
			return listaLibros;
		}
	}

	public void borrarItemCarrito(Carrito carrito) throws SQLException {
		PreparedStatement ps = con.prepareStatement("DELETE * FROM libreriadb.carrito WHERE id_carrito=?");
		ps.setInt(1, carrito.getId_carrito());

		ps.executeUpdate();
		ps.close();
	}
}
