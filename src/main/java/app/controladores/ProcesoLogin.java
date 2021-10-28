package app.controladores;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.clasesDao.DAOCliente;
import app.modelo.Cliente;

/**
 * Servlet implementation class ProcesoLogin
 */
@WebServlet("/ProcesoLogin")
public class ProcesoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProcesoLogin() {

		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String user = request.getParameter("user");
		String password = request.getParameter("password");
		String mensaje = "";
		int userOk = 0;
		Cliente cliente = new Cliente();
		try {
			cliente = DAOCliente.getInstance().buscarPorUsuario(user);

			if (cliente.getUsuario().equals(user)) {
				if (password.equals(cliente.getPassword())) {
					HttpSession sesion = request.getSession();
					sesion.setAttribute("user", cliente.getUsuario());
					sesion.setAttribute("id_cliente", cliente.getId_cliente());
					request.setAttribute("cliente", cliente);
					Cookie cookieUsuario = new Cookie("user", user);
					cookieUsuario.setMaxAge(30 * 24 * 60 * 60);
					response.addCookie(cookieUsuario);
					System.out.print("Verifico usuario y contrasenia");
					request.getRequestDispatcher("tablaLibros.jsp").forward(request, response);
				}
			} else if (!cliente.getUsuario().equals(user) || !cliente.getPassword().equals(password)) {
				mensaje = "El usuario o la contrasenia son incorrectas o no existe el usuario.";
				request.setAttribute("userOk", userOk);
				request.setAttribute("mensaje", mensaje);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// doGet(request, response);
	}

}
