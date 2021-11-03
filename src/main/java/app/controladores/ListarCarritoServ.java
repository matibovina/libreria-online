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
 * Servlet implementation class ListarCarritoServ
 */
@WebServlet("/ListarCarritoServ")
public class ListarCarritoServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarCarritoServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			accionesCarrito(request, response);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			accionesCarrito(request, response);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//SERVIDOR PARA CONTROLAR LAS ACCIONES DEL CARRITO - BORRAR
	protected void accionesCarrito(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
		String listaJSON = "";
		String opcion = request.getParameter("opcion"); 
		Carrito carrito = new Carrito();
		HttpSession sesion = request.getSession();
		int id_cliente = Integer.parseInt((sesion.getAttribute("id_cliente").toString()));
		String id_libro = request.getParameter("id_libro");
		if("1".equals(opcion)) {
			carrito.borrarItemCarrito(Integer.parseInt(id_libro), id_cliente);
			//DAOCarrito.getInstance().borrarItemCarrito(Integer.parseInt(id_libro), id_cliente);
		
		}
		listaJSON = carrito.listarCarritoJSON(id_cliente);
		//listaJSON = DAOCarrito.getInstance().listarCarritoJSON(id_cliente);
		
		
		PrintWriter out = response.getWriter();
		out.print(listaJSON);
	}
}

