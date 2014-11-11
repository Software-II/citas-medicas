package dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import beans.BeanCitaMedica;
import beans.BeanHistoriaMedica;
import beans.BeanMedico;
import beans.BeanPaciente;
import dao.factory.MySqlDAOFactory;
import dao.interfaces.I_CM;
import dao.interfaces.I_HistoriaMedica;

public class MySQLHistoriaMedicaDAO extends MySqlDAOFactory implements I_HistoriaMedica{


	@Override
	public BeanHistoriaMedica buscarPacientePorHuella() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BeanHistoriaMedica buscarHistorialMedico(int id) throws Exception {
		// TODO Auto-generated method stub
		try {
			Connection con = MySqlDAOFactory.crearConexion();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM citasmedicas.HISTORIAMEDICA where HISTORIAMEDICA.IDPAC='"+id+"' ");
			
			BeanHistoriaMedica objHM = null;
			while(rs.next()){
				objHM= new BeanHistoriaMedica();
				objHM.setIdHistria(rs.getInt("IDHISTORIA"));
			}
			return objHM;
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return null;
		

	}

	
}
