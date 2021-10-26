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

/**
 * Servlet implementation class AccionesServ
 */
@WebServlet("/AccionesServ")
public class AccionesServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccionesServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		buscarLibros(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		buscarLibros(request, response);
	}
	protected void buscarLibros(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		int id_cliente = Integer.parseInt((sesion.getAttribute("id_cliente").toString())) ;
		
		String resultadoJSON = "";
		String opcion = request.getParameter("opcion");
		String buscador = request.getParameter("buscador");
		String id_libro = request.getParameter("id_libro");
		String precio = request.getParameter("precio");
		System.out.println("VALOR BUSCADOR" + buscador);
		System.out.println("ID CLIENTE DE LA SESION ES: " + id_cliente);
		int id_carrito = 0;
		Carrito carrito = null;

		try {
			switch(opcion) {
			case "1":
				System.out.println("Entra a METODO ISBN");
				System.out.println("VALOR BUSCADOR ISBN" + buscador);
				resultadoJSON = DAOLibro.getInstance().listarIsbnJSON(buscador);
				System.out.println("ESTA LISTA ES EN SERVLET ISBN" + resultadoJSON);
				break;
			case "2":
				System.out.println("Entra a METODO TITULO");
				System.out.println("VALOR BUSCADOR" + buscador);
				System.out.println("VALOR OPCION" + opcion);
				resultadoJSON = DAOLibro.getInstance().listarTituloJSON(buscador);
				System.out.println("ESTA LISTA ES EN SERVLET TITULO" + resultadoJSON);
				break;
			case "3":
				DAOLibro.getInstance().editarLibro_DAO(Integer.parseInt(id_libro), Double.parseDouble(precio));
			break;
			case "4":
				System.out.println(id_libro + "este es el id que llega");
				DAOLibro.getInstance().borrarLibro(Integer.parseInt(id_libro));
				break;
			case "5":
				id_carrito = DAOCarrito.getInstance().buscarUltimoIdCarrito();
				carrito = new Carrito(id_carrito, id_cliente, Integer.parseInt(id_libro));
				DAOCarrito.getInstance().insertarCarrito_DAO(id_carrito, id_cliente, id_carrito);
				break;
			case "6":
				break;
			}
			PrintWriter out = response.getWriter();
			out.print(resultadoJSON);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
