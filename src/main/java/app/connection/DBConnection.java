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
				
				System.out.println("intenta hacer la conexion y crear las tablas");
				instance = DriverManager.getConnection(JDBC_url, props);
				Statement stm = instance.createStatement();
				String sql = "CREATE DATABASE IF NOT EXISTS libreriadb";
				stm.executeUpdate(sql);
				System.out.println("Database created successfully...");
				
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
					+ "  precio DECIMAL(5) NOT NULL,\n"
					+ "  genero VARCHAR(45) NOT NULL,\n"
					+ "  PRIMARY KEY (id_libro));");
			ps.executeUpdate();
			ps.close();
		}
		public static void tablaCarrito() throws SQLException, ClassNotFoundException {
			PreparedStatement ps = getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS `libreriadb`.`carrito` (\n"
					+ "  id_carrito INT NOT NULL,\n"
					+ "  id_cliente INT NOT NULL,\n"
					+ "  id_libro INT NOT NULL,\n"
					+ "  PRIMARY KEY (id_carrito),\n"
					+ "  INDEX id_cliente_idx (id_cliente ASC) VISIBLE,\n"
					+ "  INDEX id_libro_idx (id_libro ASC) VISIBLE,\n"
					+ "  CONSTRAINT id_cliente\n"
					+ "    FOREIGN KEY (id_cliente)\n"
					+ "    REFERENCES libreriadb.clientes (id_cliente)\n"
					+ "    ON DELETE NO ACTION\n"
					+ "    ON UPDATE NO ACTION,\n"
					+ "  CONSTRAINT id_libro\n"
					+ "    FOREIGN KEY (id_libro)\n"
					+ "    REFERENCES libreriadb.libros (id_libro)\n"
					+ "    ON DELETE CASCADE\n"
					+ "    ON UPDATE CASCADE);\n"
					+ "");
			ps.executeUpdate();
			ps.close();
		}
		public static void tablaCompra() throws SQLException, ClassNotFoundException {
			PreparedStatement ps = getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS libreriadb.compra (\n"
					+ "  id_compra INT NOT NULL,\n"
					+ "  precio_pagado DECIMAL(4) NOT NULL,\n"
					+ "  id_carrito INT NOT NULL,\n"
					+ "  PRIMARY KEY (id_compra),\n"
					+ "  INDEX id_carrito_idx (id_carrito ASC) VISIBLE,\n"
					+ "  CONSTRAINT id_carrito\n"
					+ "    FOREIGN KEY (id_carrito)\n"
					+ "    REFERENCES libreriadb.carrito (id_carrito)\n"
					+ "    ON DELETE NO ACTION\n"
					+ "    ON UPDATE NO ACTION);");
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



