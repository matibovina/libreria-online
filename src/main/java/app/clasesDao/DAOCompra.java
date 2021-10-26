package app.clasesDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import app.connection.DBConnection;
import app.modelo.Cliente;
import app.modelo.Compra;
import app.modelo.Libro;

public class DAOCompra {

	private Connection con = null;
	public static DAOCompra instance = null;

	public DAOCompra() throws SQLException, ClassNotFoundException {
		con = DBConnection.getConnection();

	}

	public static DAOCompra getInstance() throws SQLException, ClassNotFoundException {
		if (instance == null) {
			instance = new DAOCompra();
		}
		return instance;
	}

	public int buscarUltimoIdCompra() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT MAX(id_compra) FROM libreriadb.compra");
		ResultSet result = ps.executeQuery();
		int idLibroNuevo = 0;
		if (result.next()) {
			idLibroNuevo = result.getInt("id_compra") + 1;
		}
		result.close();
		ps.close();
		return idLibroNuevo;
	}

	public void crearCompra_DAO(Compra compra, Libro libro, Cliente cliente) throws SQLException {
		compra.setId_cliente(cliente.getId_cliente());
		compra.setId_libro(libro.getId_libro());
		PreparedStatement ps = con.prepareStatement("INSERT INTO libreriadb.compra VALUES (?,?,?)");
		ps.setInt(1, compra.getId_compra());
		ps.setInt(2, compra.getId_cliente());
		ps.setInt(3, compra.getId_libro());

		ps.executeUpdate();
		ps.close();
	}

	public ArrayList<Compra> listarCompra() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM libreriadb.carrito");
		ResultSet result = ps.executeQuery();

		ArrayList<Compra> listaCompras = null;
		while (result.next()) {
			if (listaCompras == null) {
				listaCompras = new ArrayList<Compra>();
			}
			listaCompras.add(
					new Compra(result.getInt("id_compra"), result.getInt("id_cliente"), result.getInt("id_libro")));
		}
		result.close();
		ps.close();
		if (listaCompras == null) {
			return listaCompras = new ArrayList<Compra>();
		} else {
			return listaCompras;
		}
	}

}
