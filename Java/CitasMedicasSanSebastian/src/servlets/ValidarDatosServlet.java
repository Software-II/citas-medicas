package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import beans.BeanCitaMedica;
import beans.BeanHistoriaMedica;
import beans.BeanPaciente;
import dao.factory.DAOFactory;
import dao.interfaces.I_HistoriaMedica;
import dao.interfaces.I_ValidarDatos;
import Arduino.Arduino;

import java.util.Enumeration;

import gnu.io.*;
/**
 * Servlet implementation class HuellaServlet
 */
@WebServlet("/validarDatos")
public class ValidarDatosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	CommPortIdentifier ports;
	Arduino arduino = new Arduino();
    public ValidarDatosServlet() {
        super();
        

        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String dato=request.getParameter("tipo");
	
		if(dato.equalsIgnoreCase("1")){
			String dni=request.getParameter("dni");
		
			BeanPaciente obj= new BeanPaciente();
			BeanHistoriaMedica obj2= new BeanHistoriaMedica();
			
			try {
				
				DAOFactory dao=DAOFactory.getDaoFactory(DAOFactory.MySql);	
				I_ValidarDatos interfaz=dao.getValidarDatos();
				obj=interfaz.buscarPacientePorDNI(dni);
				System.out.println("IDPAC: "+obj.getIdPaciente());
				DAOFactory dao1=DAOFactory.getDaoFactory(DAOFactory.MySql);	
				I_HistoriaMedica interfaz2=dao1.getHistoriaMedica();
				obj2=interfaz2.buscarHistorialMedico(obj.getIdPaciente());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			if(obj!=null && obj2!=null){
				System.out.println("obj1: "+obj.getNombre());
				System.out.println("obj2: "+obj2.getIdHistria());
				
				 HttpSession sesion = request.getSession();
				 sesion.setAttribute("paciente", obj);
				 request.setAttribute("historia", obj2);
				request.getRequestDispatcher("/MenuPpalP.jsp").forward(request, response);
			}else{
			
				String mensaje="Paciente no registrado, Porfavor Registrarse en ADMINISION";
				request.setAttribute("mensaje", mensaje);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			
		}else if ( dato.equals("2")){
			
			
		
		SerialPortEventListener evento = new SerialPortEventListener() {
			
			@Override
			public void serialEvent(SerialPortEvent arg0) {
				//String mensaje ="";
				if(arduino.MessageAvailable()==true){
				
					String data=arduino.PrintMessage();
					if(data.equals("0")){
						String entrar=arduino.PrintMessage();
						if(Integer.parseInt(entrar)>20){
							try {
								request.getRequestDispatcher("/MenuPpalP.jsp").forward(request, response);
							} catch (ServletException | IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}else{
							try {
								request.getRequestDispatcher("/index.html").forward(request, response);
							} catch (ServletException | IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							};
						}
					}
					
				}
			}
		};
		
		try {
			arduino.ArduinoRXTX("COM3", 2000, 9600, evento);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else{
		     
			HttpSession sesion=request.getSession();
			
			sesion.removeAttribute("paciente");
			
			response.sendRedirect("index.jsp");


		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
	}

}
