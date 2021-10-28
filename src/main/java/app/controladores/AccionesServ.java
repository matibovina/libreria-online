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
		//AccionesLibros(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AccionesLibros(request, response);
	}
	protected void AccionesLibros(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		int id_cliente = Integer.parseInt((sesion.getAttribute("id_cliente").toString())) ;
		int contadorCarrito = 0;
		String resultadoJSON = "";
		String opcion = request.getParameter("opcion");
		String buscador = request.getParameter("buscador");
		String id_libro = request.getParameter("id_libro");
		String precio = request.getParameter("precio");
		int id_carrito = 0;
		Carrito carrito = null;
		PrintWriter out = response.getWriter();

		try {
			switch(opcion) {
			case "1":
				resultadoJSON = DAOLibro.getInstance().listarIsbnJSON(buscador);
				break;
			case "2":
				resultadoJSON = DAOLibro.getInstance().listarTituloJSON(buscador);
				break;
			case "3":
				DAOLibro.getInstance().editarLibro_DAO(Integer.parseInt(id_libro), Double.parseDouble(precio));
			break;
			case "4":
				DAOLibro.getInstance().borrarLibro(Integer.parseInt(id_libro));
				break;
			case "5":
				
				id_carrito = DAOCarrito.getInstance().buscarUltimoIdCarrito();
				Libro libro = DAOLibro.getInstance().buscarPorIdLibro(Integer.parseInt(id_libro));
				carrito = new Carrito(id_carrito, id_cliente, Integer.parseInt(id_libro), libro.getTitulo(), libro.getPrecio());
				DAOCarrito.getInstance().insertarCarrito_DAO(carrito);
				
				contadorCarrito = DAOCarrito.getInstance().contadorCarrito(id_cliente);
				System.out.println("Contador carrito" + contadorCarrito);
				out.print(contadorCarrito);
				break;
			case "6":
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
