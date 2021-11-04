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
import app.modelo.Libro;

/**
 * Servlet implementation class ListarLibrosServ
 */
@WebServlet("/ListarLibrosServ")
public class ListarLibrosServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			listarLibros(request, response);
		} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			listarLibros(request, response);
		} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// SERVIDOR PARA LISTAR TODOS LOS LIBROS EXISTENTES
	protected void listarLibros(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		String listaJSON = "";
		HttpSession sesion = request.getSession();
		int id_cliente = Integer.parseInt((sesion.getAttribute("id_cliente").toString()));

		listaJSON = Libro.listaLibrosJSON();
		PrintWriter out = response.getWriter();
		out.print(listaJSON);
	}

}
