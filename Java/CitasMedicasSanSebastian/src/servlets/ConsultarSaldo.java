package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeanPaciente;
import dao.factory.DAOFactory;
import dao.interfaces.I_ValidarDatos;

/**
 * Servlet implementation class ConsultarSaldo
 */
@WebServlet("/consultarSaldo")
public class ConsultarSaldo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultarSaldo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String dato=request.getParameter("idPac");
		DAOFactory dao = DAOFactory.getDaoFactory(DAOFactory.MySql);
		I_ValidarDatos intefaz = dao.getValidarDatos();
		BeanPaciente objPac=intefaz.obtenerDatos(dato);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
