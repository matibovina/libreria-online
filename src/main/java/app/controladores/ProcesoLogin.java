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

import app.modelo.Cliente;

/**
 * Servlet implementation class ProcesoLogin
 */
@WebServlet("/ProcesoLogin")
public class ProcesoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	//SERVIDOR PARA PROCESAR EL LOG IN DEL USUARIO
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String user = request.getParameter("user");
		String password = request.getParameter("password");
		String mensaje = "";
		String vista = "";
		Cliente cliente = new Cliente();
		try {
			
				if(cliente.booleanUsuario(user)) { //SI EL USUARIO EXISTE CREA INSTANCIA DE CLIENTE
					cliente  = cliente.buscarPorUsuario(user);
					if(cliente.booleanPassword(password)) {
					HttpSession sesion = request.getSession();
					sesion.setAttribute("user", cliente.getUsuario());
					sesion.setAttribute("id_cliente", cliente.getId_cliente()); //GUARDA VALORES COMO ATRIBUTE DE LA SESION
					request.setAttribute("cliente", cliente);
					Cookie cookieUsuario = new Cookie("user", user);
					cookieUsuario.setMaxAge(30 * 24 * 60 * 60);
					response.addCookie(cookieUsuario);
					vista = "tablaLibros.jsp";
					}
			} else { 
			mensaje = "El usuario o la contrasenia son incorrectas o no existe el usuario.";
			request.setAttribute("mensaje", mensaje);
			vista = "login.jsp";
		} 
			request.getRequestDispatcher(vista).forward(request, response);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
