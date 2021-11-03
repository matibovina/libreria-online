package app.modelo;

import java.sql.SQLException;

import app.clasesDao.DAOLibro;

public class Libro {

	private int id_libro;
	private String titulo;
	private String autor;
	private String genero;
	private double precio;
	private String ISBN;

	public Libro(int id_libro, String titulo, String autor, String ISBN, double precio, String genero) {
		this.id_libro = id_libro;
		this.titulo = titulo;
		this.autor = autor;
		this.ISBN = ISBN;
		this.precio = precio;
		this.genero = genero;

	}

	public Libro() {
		// TODO Auto-generated constructor stub
	}

	public int getId_libro() {
		return id_libro;
	}

	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public int buscarUltimoIdLibro() throws SQLException, ClassNotFoundException {
		return DAOLibro.getInstance().buscarUltimoIdLibro();
	}
	public Libro buscarIdLibro(int id_libro) throws ClassNotFoundException, SQLException {
		return DAOLibro.getInstance().buscarPorIdLibro(id_libro);
	}

	public void insertarLibro(Libro libro) throws SQLException, ClassNotFoundException {
		DAOLibro.getInstance().insertarLibro_DAO(libro);
	}

	public boolean validarTitulo(String titulo) throws SQLException, ClassNotFoundException {
		return DAOLibro.getInstance().validarTitulo(titulo);
	}

	public boolean validarISBN(String isbn) throws SQLException, ClassNotFoundException {
		return DAOLibro.getInstance().validarISBN(isbn);
	}

	public void editarLibro(int id, double precio) throws SQLException, ClassNotFoundException {
		DAOLibro.getInstance().editarLibro_DAO(id, precio);
	}

	public void borrarLibro(int id_libro) throws SQLException, ClassNotFoundException {
		DAOLibro.getInstance().borrarLibro(id_libro);
	}
	
	public static String listaLibrosJSON() throws SQLException, ClassNotFoundException {
		return DAOLibro.getInstance().listaLibrosJSON();
	}

	public String listarIsbnJSON(String isbn) throws SQLException, ClassNotFoundException {
		return DAOLibro.getInstance().listarIsbnJSON(isbn);
	}

	public String listarTituloJSON(String titulo) throws SQLException, ClassNotFoundException {
		return DAOLibro.getInstance().listarTituloJSON(titulo);
	}

}
