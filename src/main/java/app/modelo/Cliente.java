package app.modelo;

import java.sql.SQLException;
import java.util.ArrayList;

import app.clasesDao.DAOCliente;

public class Cliente {
	private int id_cliente;
	private String nombre;
	private String apellido;
	private String fechaNac;
	private String email;
	private String usuario;
	private String password;


	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(int id_cliente, String nombre, String apellido, String fechaNac, String email, String usuario, String password
			) {
		this.id_cliente = id_cliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNac = fechaNac;
		this.email = email;
		this.usuario = usuario;
		this.password = password;

	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}
	
	public int buscarUltimoId() throws SQLException, ClassNotFoundException {
		return DAOCliente.getInstance().buscarUltimoId();
	}
	
	public void insertarCliente(Cliente cliente) throws SQLException, ClassNotFoundException {
		DAOCliente.getInstance().insertarCliente_DAO(cliente);
	}
	
	public Cliente buscarPorUsuario(String usuario) throws SQLException, ClassNotFoundException {
		return DAOCliente.getInstance().buscarPorUsuario(usuario);
	}
	
	public boolean booleanUsuario(String usuario) throws SQLException, ClassNotFoundException {
		return DAOCliente.getInstance().booleanUsuario(usuario);
	}
	
	public boolean booleanPassword(String password) throws SQLException, ClassNotFoundException {
		return DAOCliente.getInstance().booleanPassword(password);
	}
	
	public boolean booleanEmail(String email) throws SQLException, ClassNotFoundException {
		return DAOCliente.getInstance().booleanEmail(email);
	}
	
	public Cliente buscarPorPassword(String password) throws SQLException, ClassNotFoundException {
		return DAOCliente.getInstance().buscarPorPassword(password);
	}
	
	public Cliente loginCliente(String usuario, String password) throws SQLException, ClassNotFoundException {
		return DAOCliente.getInstance().loginCliente(usuario, password);
	}
	
	public void editarUsuario(Cliente cliente, String password) throws SQLException, ClassNotFoundException {
		 DAOCliente.getInstance().editarUsuario_DAO(cliente, password);
	}
	
	public ArrayList<Cliente> listarCliente() throws SQLException, ClassNotFoundException {
		return DAOCliente.getInstance().listarCliente();
	}
	
	
}
