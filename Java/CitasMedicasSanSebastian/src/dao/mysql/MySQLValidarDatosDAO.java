package dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


import beans.BeanPaciente;
import dao.factory.MySqlDAOFactory;
import dao.interfaces.I_ValidarDatos;

public class MySQLValidarDatosDAO extends MySqlDAOFactory implements I_ValidarDatos{

	@Override
	public BeanPaciente buscarPacientePorDNI(String dni) throws Exception {
		// TODO Auto-generated method stub
		
		try {
			Connection con = MySqlDAOFactory.crearConexion();
			Statement stmt = con.createStatement();
			//ResultSet rs = stmt.executeQuery("SELECT * FROM PERSONA,PACIENTE  where PERSONA.DNI="+dni+" and PERSONA.IDPER=PACIENTE.IDPAC ");
			ResultSet rs = stmt.executeQuery("SELECT * FROM PERSONA,PACIENTE  where PERSONA.DNI=12345678 and  PERSONA.IDPER=PACIENTE.IDPAC;");
			
			BeanPaciente objPac = null;
			while(rs.next()){
				objPac = new BeanPaciente();
				objPac.setIdPaciente(rs.getInt("PACIENTE.IDPAC"));
				objPac.setNombre(rs.getString("PERSONA.NOM"));
				objPac.setDni(rs.getInt("PERSONA.DNI"));
				objPac.setApellido(rs.getString("PERSONA.APEPAT"));
				objPac.setSaldo(rs.getDouble("PACIENTE.SALDO"));
			}
			
			return objPac;
		} catch (Exception e) {
			System.out.println("this is de message: ");
			System.out.print(e.getMessage());
		}
		
		return null;
		

	}

	@Override
	public BeanPaciente buscarPacientePorHuella() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BeanPaciente obtenerDatos(String dato) {
		// TODO Auto-generated method stub
		return null;
	}

		
}
