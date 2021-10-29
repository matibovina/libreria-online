package app.controladores;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.clasesDao.DAOCliente;
import app.modelo.Cliente;

/**
 * Servlet implementation class ProcesoRegisroServ
 */
@WebServlet("/ProcesoRegisroServ")
public class ProcesoRegisroServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcesoRegisroServ() {
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
		Cliente cliente = new Cliente();
		int id_cliente = 0;
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String fechanac = request.getParameter("fechaNacimiento");
		String email = request.getParameter("email");
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		String password1 = request.getParameter("password1");
		String mensaje = "";
		
		System.out.println(nombre + " " + apellido + " " + fechanac + " " + email + " " + user + " " + password);
		
		
		try {
			if(nombre.length() == 0|| apellido.length() == 0 || fechanac.length() == 0 || email.length() == 0 || user.length() == 0 || password.length() == 0|| password1.length() == 0) {
				mensaje = "Los campos no pueden estar vacios.";
				System.out.println(mensaje);
				request.setAttribute("mensaje", mensaje);
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
			else if(DAOCliente.getInstance().booleanUsuario(user)) {
				System.out.println("Se comprobo usuario");
				mensaje = "El usuario ya existe. Intente nuevamente";
				request.setAttribute("mensaje", mensaje);
				request.getRequestDispatcher("register.jsp").forward(request, response);
			} else if(DAOCliente.getInstance().booleanEmail(email)) {
				System.out.println("Se comprobo mail");
				mensaje = "El email ya existe en nuestra base de datos. Intente nuevamente";
				request.setAttribute("mensaje", mensaje);
				request.getRequestDispatcher("register.jsp").forward(request, response);
			} else if(!password.equals(password1)) {
				System.out.println("Se comprobo contrasenia");
				mensaje = "Las password no coinciden.";
				request.setAttribute("mensaje", mensaje);
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
			else {
				id_cliente = DAOCliente.getInstance().buscarUltimoId();
				cliente = new Cliente(id_cliente, nombre, apellido, fechanac, email, user, password);
				DAOCliente.getInstance().insertarCliente_DAO(cliente);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} 

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
