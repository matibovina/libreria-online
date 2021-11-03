package app.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CerrarSesionServ
 */
@WebServlet("/CerrarSesionServ")
public class CerrarSesionServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    //SERVLET PARA OBTENER LA CANTIDAD DE FILAS QUE TIENE LA TABLA CARRITO
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		sesion.invalidate();
		System.out.println("llega a cierre sesion");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		HttpSession sesion = request.getSession();
		sesion.invalidate(); //Cierra sesion y redirije al index
		System.out.println("llega a cierre sesion");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
