package dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dao.interfaces.AdministradorDao;
import daofactory.MySqlDAOFactory;

public class MySql_AdministradorDao 
			extends MySqlDAOFactory
				implements AdministradorDao{

	@Override
	public String validar(String usu, String clave) throws Exception {
		// TODO Auto-generated method stub
		String nombre = "";
		try {
			Connection con = MySqlDAOFactory.crearConexion();
			Statement stmt = con.createStatement();
			ResultSet rs =
					stmt.executeQuery("select nombre " +
					"from Administrador " +
					"where idAdmin ='"+usu+"' " +
					"and contra='"+clave+"'");
			if(rs.next()){
				nombre = rs.getString("nombre");
			}						
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}		
		return nombre;
	}
	
	

}
