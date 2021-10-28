package app.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
//
public class DBConnection {
	


		
		
		private static final String JDBC_url = "jdbc:mysql://localhost:3306/libreriadb";
		private static Connection instance = null;
		
		
		public DBConnection() {}
		
		public static Connection getConnection() throws SQLException, ClassNotFoundException {
			if(instance == null) {
				
				Properties props = new Properties();
				props.put("user", "root");
				props.put("password", "Aporapipe.5859");
				Class.forName("com.mysql.cj.jdbc.Driver");
				instance = DriverManager.getConnection(JDBC_url, props);
				Statement stm = instance.createStatement();
				String sql = "CREATE DATABASE IF NOT EXISTS libreriadb";
				stm.executeUpdate(sql);				
				crearTablas();
				
			}
			return instance;
		}
//		public static void crearBaseDatos() throws SQLException, ClassNotFoundException {
//			PreparedStatement ps = getConnection().prepareStatement("CREATE DATABASE IF NOT EXISTS libreriadb");
//			ps.executeUpdate();
//			ps.close();
//		}
		
		public static void crearTablas() throws SQLException, ClassNotFoundException {
			tablaClientes();
			tablaLibros();
	//		agregarIndexPrecioTablaLibros();
			tablaCarrito();
			tablaCompra();
			inserts();
		}
		
		public static void tablaClientes() throws SQLException, ClassNotFoundException {
			PreparedStatement ps  = getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS libreriadb.clientes (\n"
					+ "  id_cliente INT NOT NULL,\n"
					+ "  nombre VARCHAR(45) NOT NULL,\n"
					+ "  apellido VARCHAR(45) NOT NULL,\n"
					+ "  fechanac VARCHAR(45) NOT NULL,\n"
					+ "  email VARCHAR(90) NOT NULL,\n"
					+ "  user VARCHAR(45) NOT NULL,\n"
					+ "  password VARCHAR(45) NOT NULL,\n"
					+ "  PRIMARY KEY (id_cliente));");
			
			ps.executeUpdate();
			ps.close();
		}
		
		public static void tablaLibros() throws SQLException, ClassNotFoundException {
			PreparedStatement ps = getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS libreriadb.libros (\n"
					+ "  id_libro INT NOT NULL,\n"
					+ "  titulo VARCHAR(45) NOT NULL,\n"
					+ "  autor VARCHAR(45) NOT NULL,\n"
					+ "  isbn VARCHAR(45) NOT NULL,\n"
					+ "  precio INT NOT NULL,\n"
					+ "  genero VARCHAR(45) NOT NULL,\n"
					+ "  PRIMARY KEY (id_libro));");
			ps.executeUpdate();
			ps.close();
		}
//		public static void agregarIndexPrecioTablaLibros() throws SQLException, ClassNotFoundException {
//			PreparedStatement ps = getConnection().prepareStatement(
//					" ALTER TABLE `libreriadb`.`libros` \n"
//					+ "ADD INDEX `precio` (`precio` ASC) VISIBLE;");
//			ps.executeUpdate();
//			ps.close();
//		}
		public static void tablaCarrito() throws SQLException, ClassNotFoundException {
			
			PreparedStatement ps = getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS libreriadb.carrito (\n"
					+ "  id_carrito INT NOT NULL,\n"
					+ "  id_cliente INT NOT NULL,\n"
					+ "  id_libro INT NOT NULL,\n"
					+ "  titulo VARCHAR(45) NOT NULL,\n"
					+ "  precio INT NOT NULL,\n"
					+ "  PRIMARY KEY (id_carrito),\n"
					+ "    FOREIGN KEY (id_cliente)\n"
					+ "    REFERENCES libreriadb.clientes (id_cliente)"
					+ "		ON DELETE CASCADE\n"
					+ "		ON UPDATE CASCADE,\n"
					+ "    FOREIGN KEY (id_libro)\n"
					+ "    REFERENCES libreriadb.libros (id_libro)"
					+ "		ON DELETE CASCADE\n"
					+ "		ON UPDATE CASCADE,"
					+ "    CONSTRAINT `carrito_ibfk_3` FOREIGN KEY (precio)\n"
					+ "    REFERENCES libreriadb.libros (precio)"
					+ "		ON DELETE CASCADE"
					+ "		ON UPDATE CASCADE);");
			ps.executeUpdate();
			ps.close();
		}
		public static void tablaCompra() throws SQLException, ClassNotFoundException {
			PreparedStatement ps = getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS libreriadb.compra (\n"
					+ "  id_compra INT NOT NULL,\n"
					+ "  monto DECIMAL(4) NOT NULL,\n"
					+ "  id_cliente INT NOT NULL,\n"
					+ "  PRIMARY KEY (id_compra),\n"
					+ " FOREIGN KEY (id_cliente)\n"
					+ " REFERENCES libreriadb.clientes (id_cliente));");
			ps.executeUpdate();
			ps.close();
		}
		public static void inserts() throws SQLException, ClassNotFoundException {
			insertUsuario();
		}
		public static void insertUsuario() throws SQLException, ClassNotFoundException {

			PreparedStatement ps = getConnection().prepareStatement(
					"INSERT INTO libreriadb.clientes (id_cliente, nombre, apellido, fechanac, email, user, password) SELECT * FROM (SELECT 1, 'a','b','1989-10-08', 'admin@admin.com', 'admin', '1234' ) as tmp WHERE NOT EXISTS (SELECT user FROM clientes WHERE user = 'admin') LIMIT 1;  ");

			ps.executeUpdate();
			ps.close();
		}

	}



