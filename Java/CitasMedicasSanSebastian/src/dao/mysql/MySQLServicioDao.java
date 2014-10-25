package dao.mysql;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import beans.BeanServicio;
import dao.factory.MySqlDAOFactory;
import dao.interfaces.I_Servicio;

public class MySQLServicioDao  extends MySqlDAOFactory implements I_Servicio{

	@Override
	public List<BeanServicio> buscarServicio(String key) throws Exception {
		
		List<BeanServicio> servicios = null;
		
		try {
			Connection con = MySqlDAOFactory.crearConexion();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT IDSERV, NOMSERV, COSTO, DESCR FROM SERVICIO WHERE NOMSERV LIKE '"+key+"%';");
			
			servicios = new ArrayList<BeanServicio>();
			BeanServicio servicio = null;
			while(rs.next()){
				servicio = new BeanServicio();
				servicio.setIdServicio(rs.getInt("IDSERV"));
				servicio.setNomServ(rs.getString("NOMSERV"));
				servicio.setCost(rs.getDouble("COSTO"));
				servicio.setDescr(rs.getString("DESCR"));
				servicios.add(servicio);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return servicios;
		
	}

}
