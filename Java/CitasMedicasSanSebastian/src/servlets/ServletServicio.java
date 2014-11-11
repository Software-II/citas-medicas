package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeanServicio;
import dao.factory.DAOFactory;
import dao.interfaces.I_Servicio;

@WebServlet("/ServletServicio")
public class ServletServicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletServicio() {
        super();
    }

    public static final int BUSCAR_SERVICIO = 0;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int key = Integer.parseInt(request.getParameter("key"));
		String letra  = String.valueOf(request.getParameter("letra"));
		
		
		switch (key) {
		case BUSCAR_SERVICIO:
			
			PrintWriter out = response.getWriter();
			try {
				
				
				DAOFactory dao =  DAOFactory.getDaoFactory(DAOFactory.MySql);
				List<BeanServicio> servicios = new ArrayList<BeanServicio>();
				I_Servicio servicioDao = dao.getServicio();
				servicios= servicioDao.buscarServicio(letra);
				
		        //Gson gson = new GsonBuilder().create();
		        
				
				List<Map<String, String>> listServiciosJson = new ArrayList<Map<String, String>>();
				
				for (BeanServicio servicio : servicios) {
					Map<String, String> mapJson = new HashMap<String, String>();
					mapJson.put("idServicio", String.valueOf(servicio.getIdServicio()));
					mapJson.put("nomServ", servicio.getNomServ());
					mapJson.put("cost", String.valueOf(servicio.getCost()));
					mapJson.put("descr", servicio.getDescr());
					listServiciosJson.add(mapJson);
				}
				
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(new Gson().toJson(listServiciosJson));
			
			
			} catch (Exception e) {
				
				// TODO: handle exception
				
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
