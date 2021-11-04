package app.clasesDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import app.connection.DBConnection;
import app.modelo.Cliente;

public class DAOCliente {

	private Connection con = null;
	public static DAOCliente instance = null;

	public DAOCliente() throws SQLException, ClassNotFoundException {
		con = DBConnection.getConnection();

	}

	public static DAOCliente getInstance() throws SQLException, ClassNotFoundException {
		if (instance == null) {
			instance = new DAOCliente();
		}
		return instance;
	}

	public int buscarUltimoId() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT MAX(id_cliente) AS id_cliente FROM clientes");
		ResultSet result = ps.executeQuery();

		int idClienteNuevo = 0;

		if (result.next()) {

			idClienteNuevo = result.getInt("id_cliente") + 1;
		}
		result.close();
		ps.close();
		return idClienteNuevo;
	}

	public void insertarCliente_DAO(Cliente cliente) throws SQLException {
		PreparedStatement ps = con.prepareStatement("INSERT INTO libreriadb.clientes VALUES (?,?,?,?,?,?,?)");
		ps.setInt(1, buscarUltimoId());
		ps.setString(2, cliente.getNombre());
		ps.setString(3, cliente.getApellido());
		ps.setString(4, cliente.getFechaNac());
		ps.setString(5, cliente.getEmail());
		ps.setString(6, cliente.getUsuario());
		ps.setString(7, cliente.getPassword());

		ps.executeUpdate();
		ps.close();
	}

	public Cliente buscarPorUsuario(String usuario) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM libreriadb.clientes WHERE user= ?");
		ps.setString(1, usuario);
		ResultSet result = ps.executeQuery();
		Cliente cliente = null;
		if (result.next()) {
			if (cliente == null) {
				cliente = new Cliente();
			}
			cliente = new Cliente(result.getInt("id_cliente"), result.getString("nombre"), result.getString("apellido"),
					result.getString("fechanac"), result.getString("email"), result.getString("user"),
					result.getString("password"));
		}
		result.close();
		ps.close();

		return cliente;
	}

	public boolean booleanPassword(String password) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT clientes.user FROM libreriadb.clientes WHERE password= ?");
		ps.setString(1, password);
		boolean usuarioExiste = false;
		ResultSet result = ps.executeQuery();
		if (result.next()) {
			usuarioExiste = true;

		}
		result.close();
		ps.close();
		return usuarioExiste;
	}

	public boolean booleanUsuario(String usuario) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT clientes.user FROM libreriadb.clientes WHERE user= ?");
		ps.setString(1, usuario);
		boolean usuarioExiste = false;
		ResultSet result = ps.executeQuery();
		if (result.next()) {
			usuarioExiste = true;

		}
		result.close();
		ps.close();
		return usuarioExiste;
	}

	public boolean booleanEmail(String email) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM libreriadb.clientes WHERE email=?");
		ps.setString(1, email);
		boolean emailExiste = false;
		ResultSet result = ps.executeQuery();
		if (result.next()) {
			emailExiste = true;

		}
		result.close();
		ps.close();
		return emailExiste;
	}

	public Cliente buscarPorPassword(String password) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM libreriadb.clientes WHERE password= ?");
		ps.setString(1, password);
		ResultSet result = ps.executeQuery();
		Cliente cliente = null;
		if (result.next()) {

			cliente = new Cliente(result.getInt("id_cliente"), result.getString("nombre"), result.getString("apellido"),
					result.getString("fechanac"), result.getString("email"), result.getString("user"),
					result.getString("password"));
		}
		result.close();
		ps.close();

		return cliente;
	}

	public Cliente buscarPorEmail(String email) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM libreriadb.clientes WHERE user= ?");
		ps.setString(1, email);
		ResultSet result = ps.executeQuery();
		Cliente cliente = null;
		if (result.next()) {
			cliente = new Cliente(result.getInt("id_cliente"), result.getString("nombre"), result.getString("apellido"),
					result.getString("fechanac"), result.getString("email"), result.getString("user"),
					result.getString("password"));
		}
		result.close();
		ps.close();
		if (cliente == null) {
			return cliente = new Cliente();
		} else {
			return cliente;
		}
	}

	public Cliente loginCliente(String usuario, String password) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM libreriadb.clientes WHERE user= ? and password=?");
		ps.setString(1, usuario);
		ps.setString(2, password);
		ResultSet result = ps.executeQuery();
		Cliente cliente = null;
		if (result.next()) {
			cliente = new Cliente(result.getInt("id_cliente"), result.getString("nombre"), result.getString("apellido"),
					result.getString("fechanac"), result.getString("email"), result.getString("user"),
					result.getString("password"));
		}
		result.close();
		ps.close();

		return cliente;
	}

	public void editarUsuario_DAO(Cliente cliente, String password) throws SQLException {
		PreparedStatement ps = con.prepareStatement("UPDATE libreriadb.clientes password= ? WHERE user=?");
		ps.setString(1, password);
		ps.setString(2, cliente.getUsuario());

		ps.executeUpdate();
		ps.close();
	}

	public ArrayList<Cliente> listarCliente() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM libreriadb.clientes");
		ResultSet result = ps.executeQuery();

		ArrayList<Cliente> listaClientes = null;
		while (result.next()) {
			if (listaClientes == null) {
				listaClientes = new ArrayList<Cliente>();
			}
			listaClientes.add(new Cliente(result.getInt("id_cliente"), result.getString("nombre"),
					result.getString("apellido"), result.getString("fechanac"), result.getString("email"),
					result.getString("user"), result.getString("password")));
		}
		if (listaClientes == null) {
			return listaClientes = new ArrayList<Cliente>();
		} else {
			return listaClientes;
		}
	}
}
