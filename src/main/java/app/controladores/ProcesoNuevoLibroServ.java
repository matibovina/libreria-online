package app.controladores;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.modelo.Libro;

/**
 * Servlet implementation class ProcesoNuevoLibroServ
 */
@WebServlet("/ProcesoNuevoLibroServ")
public class ProcesoNuevoLibroServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getSession().getAttribute("user");
		try {
			nuevoLibro(request, response);
		} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//SERVIDOR PARA DAR DE ALTA UN NUEVO LIBRO 
	protected void nuevoLibro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException{
		
		//String opcion = request.getParameter("opcion");
		Libro libro = new Libro();
		int id_libro = 0;
		String mensaje = "";
		String titulo = request.getParameter("titulo");
		String autor = request.getParameter("autor");
		String isbn = request.getParameter("ISBN");
		String genero = request.getParameter("genero");
		double precio = Double.parseDouble(request.getParameter("precio"));
		if(libro.validarISBN(isbn) || libro.validarTitulo(titulo)) { //COMPRUEBA QUE ISBN Y TITULO NO EXISTAN 
			mensaje = "Ya existe un libro con ese titulo o ISBN";
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher("cargarLibro.jsp").forward(request, response);;
		} else {
			id_libro = libro.buscarUltimoIdLibro();
			libro = new Libro(id_libro, titulo, autor, isbn, precio, genero);
			libro.insertarLibro(libro);
			request.getRequestDispatcher("tablaLibros.jsp").forward(request, response);;
		}

	}

}
