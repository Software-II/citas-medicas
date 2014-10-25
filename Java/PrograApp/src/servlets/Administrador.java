package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.interfaces.AdministradorDao;
import daofactory.DAOFactory;

/**
 * Servlet implementation class Adminstrador
 */
@WebServlet("/Administrador")
public class Administrador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Administrador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			HttpSession sesiones = request.getSession();
			sesiones.removeAttribute("nombreadmin");
			
			response.sendRedirect("admin/login.jsp");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			String usuario = request.getParameter("txt_user");
			String clave = request.getParameter("txt_pass");
			
			DAOFactory dao = DAOFactory.obtenerFactory(DAOFactory.MySql);
			AdministradorDao admdao= dao.obtenerAdministrador();
			String nombre = admdao.validar(usuario, clave);
			if(nombre.equals("")){
				response.sendRedirect("Admin/login.jsp");
			}else{
				HttpSession sesiones = request.getSession();
				sesiones.setAttribute("nombreadmin", nombre);
				
				response.sendRedirect("Admin/index.jsp");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		
	}

}
