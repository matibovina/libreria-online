package app.clasesDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import app.connection.DBConnection;
import app.modelo.Libro;

public class DAOLibro {

	private Connection con = null;
	public static DAOLibro instance = null;

	public DAOLibro() throws SQLException, ClassNotFoundException {
		con = DBConnection.getConnection();

	}

	public static DAOLibro getInstance() throws SQLException, ClassNotFoundException {
		if (instance == null) {
			instance = new DAOLibro();
		}
		return instance;
	}

	public int buscarUltimoIdLibro() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT MAX(id_libro) AS id_libro FROM libreriadb.libros");
		ResultSet result = ps.executeQuery();
		int idLibroNuevo = 0;
		if (result.next()) {
			idLibroNuevo = result.getInt("id_libro") + 1;
		}
		result.close();
		ps.close();
		return idLibroNuevo;
	}

	public void insertarLibro_DAO(Libro libro) throws SQLException {
		PreparedStatement ps = con.prepareStatement("INSERT INTO libreriadb.libros VALUES (?,?,?,?,?,?)");
		ps.setInt(1, buscarUltimoIdLibro());
		ps.setString(2, libro.getTitulo());
		ps.setString(3, libro.getAutor());
		ps.setString(4, libro.getISBN());
		ps.setDouble(5, libro.getPrecio());
		ps.setString(6, libro.getGenero());

		ps.executeUpdate();
		ps.close();
	}

	public boolean validarTitulo(String titulo) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM libreriadb.libros WHERE titulo= ?");
		ps.setString(1, titulo);
		ResultSet result = ps.executeQuery();
		boolean tituloExiste = false;
		if (result.next()) {
			System.out.println("Encuentra el titulo en el DAO");
			tituloExiste = true;

		}
		result.close();
		ps.close();

		return tituloExiste;
	}
	public boolean validarISBN(String isbn) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM libreriadb.libros WHERE isbn= ?");
		ps.setString(1, isbn);
		ResultSet result = ps.executeQuery();
		boolean isbnExiste = false;
		if (result.next()) {
			System.out.println("Encuentra el ISBN en el DAO");
			isbnExiste = true;

		}
		result.close();
		ps.close();

		return isbnExiste;
	}


	public void editarLibro_DAO(int id, Double precio) throws SQLException {
		PreparedStatement ps = con.prepareStatement("UPDATE libreriadb.libros SET precio= ? WHERE id_libro=?");
		ps.setDouble(1, precio);
		ps.setInt(2, id);

		ps.executeUpdate();
		ps.close();
	}

	public ArrayList<Libro> listarLibros() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM libreriadb.libros");
		ResultSet result = ps.executeQuery();

		ArrayList<Libro> listaLibros = null;
		while (result.next()) {
			if (listaLibros == null) {
				listaLibros = new ArrayList<Libro>();
			}
			listaLibros.add(new Libro(result.getInt("id_libro"), result.getString("titulo"), result.getString("autor"),
					result.getString("isbn"), result.getDouble("precio"), result.getString("genero")));
		}
		result.close();
		ps.close();
		if (listaLibros == null) {
			return listaLibros = new ArrayList<Libro>();
		} else {
			return listaLibros;
		}
	}

	public ArrayList<Libro> buscarTitulos(String titulo) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM libreriadb.libros WHERE titulo= ?");
		ps.setString(1, titulo);
		ResultSet result = ps.executeQuery();

		ArrayList<Libro> listaTitulos = null;
		while (result.next()) {
			if (listaTitulos == null) {
				listaTitulos = new ArrayList<Libro>();
			}
			listaTitulos.add(new Libro(result.getInt("id_libro"), result.getString("titulo"), result.getString("autor"),
					result.getString("isbn"), result.getDouble("precio"), result.getString("genero")));
		}
		result.close();
		ps.close();
		if (listaTitulos == null) {
			return listaTitulos = new ArrayList<Libro>();
		} else {
			return listaTitulos;
		}
	}
	
	public ArrayList<Libro> buscarPorISBN(String isbn) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM libreriadb.libros WHERE isbn= ?");
		ps.setString(1, isbn);
		ResultSet result = ps.executeQuery();
		ArrayList<Libro> listaTitulos = null;
		while (result.next()) {
			if (listaTitulos == null) {
				listaTitulos = new ArrayList<Libro>();
			}
			listaTitulos.add(new Libro(result.getInt("id_libro"), result.getString("titulo"), result.getString("autor"),
					result.getString("isbn"), result.getDouble("precio"), result.getString("genero")));
		}
		result.close();
		ps.close();
		if (listaTitulos == null) {
			return listaTitulos = new ArrayList<Libro>();
		} else {
			return listaTitulos;
		}
	}

	public void borrarLibro(int id_libro) throws SQLException {
		PreparedStatement ps = con.prepareStatement("DELETE FROM libreriadb.libros WHERE id_libro=?");
		ps.setInt(1, id_libro);

		ps.executeUpdate();
		ps.close();
	}

	public String listaLibrosJSON() throws SQLException {
		Gson gson = new Gson();

		String JSON = gson.toJson(this.listarLibros());

		System.out.println(JSON);

		return JSON;
	}

	public String listarIsbnJSON(String isbn) throws SQLException {
		Gson gson = new Gson();
		System.err.println("llama a la funcion JSON ISBN EN DAO");
		String JSON = gson.toJson(this.buscarPorISBN(isbn));

		System.out.println(JSON);

		return JSON;
	}

	public String listarTituloJSON(String titulo) throws SQLException {
		Gson gson = new Gson();

		String JSON = gson.toJson(this.buscarTitulos(titulo));

		System.out.println(JSON);

		return JSON;
	}
}
