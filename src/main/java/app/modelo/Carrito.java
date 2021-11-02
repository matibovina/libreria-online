package app.modelo;

import java.sql.SQLException;

import app.clasesDao.DAOCarrito;

public class Carrito{
	private int id_carrito;
	private int id_cliente;
	private int id_libro;
	private String titulo;
	private int precio;

	
	
	public Carrito(int id_carrito, int id_cliente, int id_libro, String titulo, int precio) {
		this.id_carrito = id_carrito;
		this.id_cliente = id_cliente;
		this.id_libro = id_libro;
		this.titulo = titulo;
		this.precio = precio;
	}



	public int getId_carrito() {
		return id_carrito;
	}

	public void setId_carrito(int id_carrito) {
		this.id_carrito = id_carrito;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
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

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Carrito() {
		// TODO Auto-generated constructor stub
	}
	
	public int buscarUltimoIdCarrito() throws SQLException, ClassNotFoundException {
		return DAOCarrito.getInstance().buscarUltimoIdCarrito();
	}	
		
	public void insertarCarrito(Carrito carrito) throws SQLException, ClassNotFoundException {
		DAOCarrito.getInstance().insertarCarrito_DAO(carrito);
	}
	
	public String listarCarritoJSON(int id_cliente) throws SQLException, ClassNotFoundException {
		return DAOCarrito.getInstance().listarCarritoJSON(id_cliente);
	}

	public void borrarItemCarrito(int id_libro, int id_cliente) throws SQLException, ClassNotFoundException {
		DAOCarrito.getInstance().borrarItemCarrito(id_libro, id_cliente);
	}
	
	public int contadorCarrito(int id_cliente) throws SQLException, ClassNotFoundException {
		return DAOCarrito.getInstance().contadorCarrito(id_cliente);
	}
	
	public void borrarLibro(int id_libro) throws SQLException, ClassNotFoundException {
		DAOCarrito.getInstance().borrarLibro(id_libro);
	}
	
	public void editarLibro(int id, int precio) throws SQLException, ClassNotFoundException {
		DAOCarrito.getInstance().editarLibro_DAO(id, precio);
	}
	
	

}
