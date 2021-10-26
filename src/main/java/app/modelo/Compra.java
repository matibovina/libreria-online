package app.modelo;

public class Compra {
	private int id_compra;
	private int id_cliente;
	private int id_libro;

	


	public Compra() {
		// TODO Auto-generated constructor stub
	}
	public Compra(int id_compra, int id_cliente, int id_libro) {
		this.id_compra = id_compra;
		this.id_cliente = id_cliente;
		this.id_libro = id_libro;
	}
	public int getId_compra() {
		return id_compra;
	}

	public void setId_compra(int id_compra) {
		this.id_compra = id_compra;
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



}
