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

import com.google.gson.Gson;

import beans.BeanMedico;
import dao.factory.DAOFactory;
import dao.interfaces.I_Medico;

@WebServlet("/ServletMedico")
public class ServletMedico extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final int BUSCAR_MEDICO = 0;
	
    public ServletMedico() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int key = Integer.parseInt(request.getParameter("key"));
		String codServ  = String.valueOf(request.getParameter("codServ"));
		String nombre = String.valueOf(request.getParameter("nombre"));
		
		switch (key) {
		case BUSCAR_MEDICO:
			
			PrintWriter out = response.getWriter();
			try {
				
				
				DAOFactory dao =  DAOFactory.getDaoFactory(DAOFactory.MySql);
				List<BeanMedico> medicos= new ArrayList<BeanMedico>();
				I_Medico medicoDao = dao.getMedico();
				medicos= medicoDao.buscarMedicoXServicio(codServ, nombre);
				
		        
				List<Map<String, String>> listMedicosJson = new ArrayList<Map<String, String>>();
				
				for (BeanMedico medico : medicos) {
					Map<String, String> mapJson = new HashMap<String, String>();
					mapJson.put("idMed",String.valueOf(medico.getIdMed()));
					mapJson.put("nombre", medico.getNombre());
					mapJson.put("apePat",medico.getApePat());
					mapJson.put("apeMat",medico.getApeMat());
					mapJson.put("horario", medico.getHorario());
					mapJson.put("cap", String.valueOf(medico.getCap()));
					listMedicosJson.add(mapJson);
				}
				
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(new Gson().toJson(listMedicosJson));
			
			
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
		// TODO Auto-generated method stub
	}

}
