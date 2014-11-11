package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeanCitaMedica;

import com.google.gson.Gson;

import dao.factory.DAOFactory;
import dao.interfaces.I_CM;

@WebServlet("/ServletCM")
public class ServletCM extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final int GUARDAR_CITAMEDICA =0;   
    public static final int LISTAR_CITASMEDICAS = 1;   
    public static final int CONFIRMAR_CITAMEDICA = 2;
	
    public ServletCM() {
        super();
    }

    public int parseInt(String str){
    	try{
    		return Integer.parseInt(str);
    	}catch(Exception e){
    		return 0;
    	}
    }
    
    public double parseDouble(String str){
    	try {
			return Double.parseDouble(str);
		} catch (Exception e) {
			return 0.0;
		}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int key = parseInt(request.getParameter("key"));
		int idServ  = parseInt(request.getParameter("idServ"));
		int idMed = parseInt(request.getParameter("idMed"));
		int idCita = parseInt(request.getParameter("idCita"));
		String fecha = request.getParameter("fecha");
		int idPac = parseInt(request.getParameter("idPac"));
		double costo = parseDouble(request.getParameter("costo"));
		double saldo = parseDouble(request.getParameter("saldo"));
		
		
		
		
		PrintWriter out = response.getWriter();
		
		switch (key) {
		case GUARDAR_CITAMEDICA:
			
			try {
				
				int result=0;
				DAOFactory dao =  DAOFactory.getDaoFactory(DAOFactory.MySql);
				I_CM cita = dao.getCMDao();
				
				result= cita.grabarCM(new BeanCitaMedica(0,1,idMed,idServ,idPac,fecha,"","",0));
				
				List<Map<String, String>> listCMJson = new ArrayList<Map<String, String>>();
				Map<String, String> mapJson = new HashMap<String, String>();
				mapJson.put("resssult",String.valueOf(result));
				listCMJson.add(mapJson);
				
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(new Gson().toJson(listCMJson));
			
			} catch (Exception e) {
				String res = "{ e: '"+e.getMessage()+"', key2: 'value2' }";
				out.print(res);
				out.flush();
			}
			break;
		
		case LISTAR_CITASMEDICAS : 
			
			try {
				
				List<BeanCitaMedica> citasMedicas = new ArrayList<BeanCitaMedica>();
				DAOFactory dao =  DAOFactory.getDaoFactory(DAOFactory.MySql);
				I_CM cita = dao.getCMDao();
				citasMedicas = cita.listarCM(idPac);
				
				List<Map<String, String>> listCMJson = new ArrayList<Map<String, String>>();
				
				for (BeanCitaMedica citaMedica : citasMedicas) {
					Map<String, String> mapJson = new HashMap<String, String>();
					mapJson.put("idCita", String.valueOf(citaMedica.getIdCita()));
					mapJson.put("idServ", String.valueOf(citaMedica.getIdServ()));
					mapJson.put("nomServ", citaMedica.getNomServ());
					mapJson.put("costo", String.valueOf(citaMedica.getCosto()));
					mapJson.put("idMed", String.valueOf(citaMedica.getIdMed()));
					mapJson.put("nomMed", citaMedica.getNomMed());
					mapJson.put("fecha", citaMedica.getFecha());
					
					listCMJson.add(mapJson);
				}
				
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(new Gson().toJson(listCMJson));
			
			
			} catch (Exception e) {
				String res = "{ e: '"+e.getMessage()+"', key2: 'value2' }";
				out.print(res);
				out.flush();
			}
			
			break;
			
		case CONFIRMAR_CITAMEDICA:	
			
			try {
				
				int result=0;
				DAOFactory dao =  DAOFactory.getDaoFactory(DAOFactory.MySql);
				I_CM cita = dao.getCMDao();
				
				result= cita.confirmarCM(saldo, new BeanCitaMedica(idCita,1,idMed,idServ,idPac,fecha,"","",costo));
				
				Map<String, String> mapJson = new HashMap<String, String>();
				
				mapJson.put("result",String.valueOf(result));
				
				
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(new Gson().toJson(mapJson));
			
			} catch (Exception e) {
				String res = "{ e: '"+e.getMessage()+"', key2: 'value2' }";
				out.print(res);
				out.flush();
			}
			
			break;
		default:
			break;
		}

		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
