package app.modelo;

public class Carrito {
	private int id_carrito;
	private int id_cliente;
	private int id_libro;
	private String titulo;
	private double precio;

	public Carrito(int id_carrito, int id_cliente, int id_libro, String titulo, double precio) {
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Carrito() {
		// TODO Auto-generated constructor stub
	}

}
