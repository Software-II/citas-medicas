package dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.BeanCitaMedica;
import dao.factory.MySqlDAOFactory;
import dao.interfaces.I_CM;

public class MySQLCMDao extends MySqlDAOFactory implements I_CM{

	@Override
	public int grabarCM(BeanCitaMedica beanCitaMedica) throws Exception {
		
		int rs=0;
		try {
			Connection con = MySqlDAOFactory.crearConexion();
			Statement stmt = con.createStatement();
			
			rs = stmt.executeUpdate("insert into CITAMEDICA (ESTADO, IDMED, IDSERV,IDPAC, FECHA) "
					+ "values (1,"+//estado
					beanCitaMedica.getIdMed()+","+//Id Paciente
					beanCitaMedica.getIdServ()+","+//Id Medico
					beanCitaMedica.getIdPac()+" ,'"+//Id Servicio
					beanCitaMedica.getFecha()+"')");//Fecha de la cita
			
			System.out.println();
						
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return rs;

	}

	@Override
	public int generarNumCitaMedica() throws Exception {
		
		return 0;
	}

	@Override
	public List<BeanCitaMedica> listarCM(int codPac) throws Exception {
		
		List<BeanCitaMedica> citasMedicas = null;
		
		try {
			Connection con = MySqlDAOFactory.crearConexion();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT C.IDCITA, C.IDSERV, S.NOMSERV, S.COSTO, C.IDMED, P.NOM, P.APEPAT, P.APEMAT, C.FECHA FROM CITAMEDICA C "
					+ "INNER JOIN SERVICIO S ON C.IDSERV = S.IDSERV "
					+ "INNER JOIN PERSONA P ON C.IDMED = P.IDPER "
					+ "WHERE IDPAC=3 AND C.ESTADO=1;");
	
			citasMedicas = new ArrayList<BeanCitaMedica>();
			BeanCitaMedica citaMedica = null;
			while(rs.next()){
				citaMedica = new BeanCitaMedica();
				citaMedica.setIdCita(rs.getInt("C.IDCITA"));
				citaMedica.setIdServ(rs.getInt("C.IDSERV"));
				citaMedica.setNomServ(rs.getString("S.NOMSERV"));
				citaMedica.setCosto(rs.getDouble("S.COSTO"));
				citaMedica.setIdMed(rs.getInt("C.IDMED"));
				citaMedica.setNomMed(rs.getString("P.NOM")+" "+rs.getString("P.APEPAT")+" "+rs.getString("P.APEMAT"));
				citaMedica.setFecha(rs.getString("C.FECHA"));
				
				citasMedicas.add(citaMedica);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return citasMedicas;
	}

	@Override
	public int confirmarCM(double saldo, BeanCitaMedica beanCitaMedica) throws Exception {
		
		int rs1=0;
		int rs2=0;
		
		if((saldo-beanCitaMedica.getCosto())<0){
			return -1;
		}
		
		try {
			Connection con = MySqlDAOFactory.crearConexion();
			Statement stmt = con.createStatement();
			
			rs1 = stmt.executeUpdate("UPDATE CITAMEDICA SET ESTADO=2 WHERE IDCITA="+beanCitaMedica.getIdCita()+";");
			rs2 = stmt.executeUpdate("UPDATE PACIENTE SET SALDO="+(saldo-beanCitaMedica.getCosto())
					+" WHERE IDPAC="+beanCitaMedica.getIdPac()+";");
						
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return rs1+rs2;
		
	}

	
	
}
