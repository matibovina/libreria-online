package app.clasesDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

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

	public void insertarCarrito_DAO(Carrito carrito) throws SQLException {

		PreparedStatement ps = con.prepareStatement("INSERT INTO libreriadb.carrito VALUES (?,?,?,?,?)");
		ps.setInt(1, carrito.getId_carrito());
		ps.setInt(2, carrito.getId_cliente());
		ps.setInt(3, carrito.getId_libro());
		ps.setString(4, carrito.getTitulo());
		ps.setDouble(5, carrito.getPrecio());
		ps.executeUpdate();
		ps.close();
	}

	public ArrayList<Carrito> listarCarrito(int id_cliente) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM libreriadb.carrito WHERE id_cliente = ?");
		ps.setInt(1, id_cliente);
		ResultSet result = ps.executeQuery();

		ArrayList<Carrito> listaLibros = null;
		while (result.next()) {
			if (listaLibros == null) {
				listaLibros = new ArrayList<Carrito>();
			}
			listaLibros.add(
					new Carrito(result.getInt("id_carrito"), result.getInt("id_cliente"), result.getInt("id_libro"), result.getString("titulo"), result.getDouble("precio")));
		}
		result.close();
		ps.close();
		if (listaLibros == null) {
			return listaLibros = new ArrayList<Carrito>();
		} else {
			return listaLibros;
		}
	}

	public void borrarItemCarrito(int id_libro, int id_cliente) throws SQLException {
		PreparedStatement ps = con.prepareStatement("DELETE FROM libreriadb.carrito WHERE id_libro=? and id_cliente=? LIMIT 1");
		ps.setInt(1, id_libro);
		ps.setInt(2, id_cliente);

		ps.executeUpdate();
		ps.close();
	}
	
	public int contadorCarrito(int id_cliente) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT count(*) FROM carrito WHERE id_cliente = ?");
		ps.setInt(1, id_cliente);
		int cantidadLibros = 0;
		ResultSet result = ps.executeQuery();
		if(result.next()) {
			cantidadLibros = result.getInt(1);
		}
		result.close();
		ps.close();
		return cantidadLibros;
	}
	public void borrarLibro(int id_libro) throws SQLException {
		PreparedStatement ps = con.prepareStatement("DELETE FROM libreriadb.carrito WHERE id_libro=?");
		ps.setInt(1, id_libro);

		ps.executeUpdate();
		ps.close();
	}
	
	public void editarLibro_DAO(int id, double precio) throws SQLException {
		PreparedStatement ps = con.prepareStatement("UPDATE libreriadb.carrito SET precio= ? WHERE id_libro=?");
		ps.setDouble(1, precio);
		ps.setInt(2, id);

		ps.executeUpdate();
		ps.close();
	}
	
	public String listarCarritoJSON(int id_cliente) throws SQLException {
		Gson gson = new Gson();
		String JSON = gson.toJson(this.listarCarrito(id_cliente));
		return JSON;
	}
	
}
