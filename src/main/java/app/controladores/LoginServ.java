package app.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class LoginServ
 */
@WebServlet("/LoginServ")
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String opcion = request.getParameter("opcion");
		String mensaje = "";
		if ("1".equals(opcion)) { //SI LA OPCION ES 1 REDIRIJE A LOG IN

			Cookie[] listaCookies = request.getCookies();
			for (Cookie cookie : listaCookies) {
				if (cookie.getName().equals("user")) {
					request.setAttribute("user", cookie.getValue());
				}
			}
			request.getRequestDispatcher("login.jsp").forward(request, response);

		}
		else if ("2".equals(opcion)) { //SI LA OPCION ES 2 REDIRIJE A REGISTRO DE USUARIO

			Cookie[] listaCookies = request.getCookies();
			for (Cookie cookie : listaCookies) {
				if (cookie.getName().equals("user")) {
					request.setAttribute("user", cookie.getValue());
				}
			}
			request.getRequestDispatcher("register.jsp").forward(request, response);

		} 
		else {
			mensaje = "No se puede acceder a LogIn en este momento.";
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

	}

}
