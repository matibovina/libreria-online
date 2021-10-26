package app.modelo;

public class Carrito {
	private int id_carrito;
	private int id_cliente;
	private int id_libro;

	
	public int getId_carrito() {
		return id_carrito;
	}


	public Carrito(int id_carrito, int id_cliente, int id_libro) {
		this.id_carrito = id_carrito;
		this.id_cliente = id_cliente;
		this.id_libro = id_libro;
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

	public Carrito() {
		// TODO Auto-generated constructor stub
	}
	
	
}
