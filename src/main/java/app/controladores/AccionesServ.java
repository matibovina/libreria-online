package app.controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.clasesDao.DAOCarrito;
import app.clasesDao.DAOLibro;
import app.modelo.Carrito;
import app.modelo.Libro;

/**
 * Servlet implementation class AccionesServ
 */
@WebServlet("/AccionesServ")
public class AccionesServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		AccionesLibros(request, response);
	}

	protected void AccionesLibros(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		int id_cliente = Integer.parseInt((sesion.getAttribute("id_cliente").toString()));
		int contadorCarrito = 0;
		String resultadoJSON = "";
		String opcion = request.getParameter("opcion");
		String buscador = request.getParameter("buscador");
		String id_libro = request.getParameter("id_libro");
		String precio = request.getParameter("precio");
		int id_carrito = 0;
		Carrito carrito = new Carrito();
		PrintWriter out = response.getWriter();
		Libro libro = new Libro();
		try {
			switch (opcion) {
			case "1":
				if (libro.validarISBN(buscador)) {
					resultadoJSON = libro.listarIsbnJSON(buscador); // SI VALOR OPCION 1 BUSCA POR ISBN
				}
				break;
			case "2":
				if (libro.validarTitulo(buscador)) {
					resultadoJSON = libro.listarTituloJSON(buscador); // SI LA OPCION ES 2 BUSCA POR TITULO
				}
				break;
			case "3": // SI LA OPCION ES EDITA EL PRECIO DEL LIBRO
				libro.editarLibro(Integer.parseInt(id_libro), Double.parseDouble(precio));
				carrito.editarLibro(Integer.parseInt(id_libro), Double.parseDouble(precio));
				break;
			case "4": // SI LA OPCION ES 4 BORRA EL LIBRO
				carrito.borrarLibro(Integer.parseInt(id_libro));
				libro.borrarLibro(Integer.parseInt(id_libro));
				break;
			case "5":
			case "6": // SI LA OPCION ES 5 O 6 AGREGA AL CARRITO - PERO A LA VEZ SI ES 6 REDIRIJE AL
						// CARRITO
				id_carrito = carrito.buscarUltimoIdCarrito();

				libro = libro.buscarIdLibro(Integer.parseInt(id_libro));
				carrito = new Carrito(id_carrito, id_cliente, Integer.parseInt(id_libro), libro.getTitulo(),
						libro.getPrecio());
				carrito.insertarCarrito(carrito);
				contadorCarrito = carrito.contadorCarrito(id_cliente);
				out.print(contadorCarrito);
				break;

			}
			out.print(resultadoJSON);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
