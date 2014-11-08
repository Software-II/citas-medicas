package dao.mysql;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import beans.BeanMedico;
import dao.factory.MySqlDAOFactory;
import dao.interfaces.I_Medico;

public class MySQLMedicoDao extends MySqlDAOFactory implements I_Medico{

	@Override
	public List<BeanMedico> buscarMedicoXServicio(String codServ, String nombre) throws Exception {
		
		List<BeanMedico> medicos = null;
		
		try {
			Connection con = MySqlDAOFactory.crearConexion();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT A.IDMED, P.NOM, P.APEPAT, P.APEMAT, A.HORAINI, A.HORAFIN, A.CAPATEN FROM ATENCION A "
					+ "INNER JOIN PERSONA P ON  A.IDMED = P.IDPER "
					+ "WHERE A.IDSERV = '"+codServ+"' and ( P.NOM like '"+nombre+"%' or P.APEPAT like '"+nombre+"%');");
			
			medicos = new ArrayList<BeanMedico>();
			BeanMedico medico = null;
			while(rs.next()){
				medico = new BeanMedico();
				medico.setIdMed(rs.getInt("A.IDMED"));
				medico.setNombre(rs.getString("P.NOM"));
				medico.setApePat(rs.getString("P.APEPAT"));
				medico.setApeMat(rs.getString("P.APEMAT"));
				medico.setHorario(rs.getString("A.HORAINI")+" - "+rs.getString("A.HORAFIN"));
				medico.setCap(rs.getInt("A.CAPATEN"));
				
				medicos.add(medico);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return medicos;
	}
	
	

}
