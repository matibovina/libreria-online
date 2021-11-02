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
import app.modelo.Carrito;

/**
 * Servlet implementation class contadorCarritoServ
 */
@WebServlet("/contadorCarritoServ")
public class contadorCarritoServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public contadorCarritoServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesion = request.getSession();
		int id_cliente = Integer.parseInt((sesion.getAttribute("id_cliente").toString())) ;
		Carrito carrito = new Carrito();
		int contadorCarrito = 0;
		try {
			contadorCarrito = carrito.contadorCarrito(id_cliente);
			//contadorCarrito = DAOCarrito.getInstance().contadorCarrito(id_cliente);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		PrintWriter out = response.getWriter();

		out.print(contadorCarrito);
		
		//doGet(request, response);
	}

}
