package app.controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.clasesDao.DAOLibro;
import app.modelo.Cliente;
import app.modelo.Libro;

/**
 * Servlet implementation class ListarLibrosServ
 */
@WebServlet("/ListarLibrosServ")
public class ListarLibrosServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListarLibrosServ() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		try {

			listarLibros(request, response);
		} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void listarLibros(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		String listaJSON = "";
		listaJSON = DAOLibro.getInstance().listaLibrosJSON();
		PrintWriter out = response.getWriter();
		out.print(listaJSON);
	}

}

//ArrayList <Libro> listaLibros = null;
//if(buscarPor.equals("0") || valorBuscador.length() == 0) {
//}
//listaLibros = DAOLibro.getInstance().buscarTitulos(valorBuscador);
//	if(listaLibros.size() != 0) {
//request.setAttribute("listaJSON", listaJSON);

//}
//else if("1".equals(buscarPor)) {
//System.out.println(libro.getTitulo());
//if(libro.getId_libro() != 0) {
// listaLibros = new ArrayList<>();
// listaLibros.add(libro);
//}

//if(listaLibros.size() != 0) {
//request.setAttribute("listaLibros", listaJSON);
//} else {

//listaLibros = DAOLibro.getInstance().listarLibros();
//request.setAttribute("listaLibros", listaLibros);
//}
//request.setAttribute("buscarPor", buscarPor);
//request.setAttribute("valorBuscador", valorBuscador);
//request.getRequestDispatcher("tablaLibros.jsp").forward(request, response);
