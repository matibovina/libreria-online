package app.modelo;

public class Libro {

	private int id_libro;
	private String titulo;
	private String autor;
	private String genero;
	private Double precio;
	private String ISBN;

	public Libro(int id_libro, String titulo, String autor, String ISBN, Double precio, String genero) {
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

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

}
