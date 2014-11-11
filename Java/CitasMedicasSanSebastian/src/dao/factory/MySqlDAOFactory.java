package dao.factory;

import java.sql.Connection;
import java.sql.DriverManager;

import dao.interfaces.I_CM;
import dao.interfaces.I_HistoriaMedica;
import dao.interfaces.I_Medico;
import dao.interfaces.I_Servicio;
import dao.interfaces.I_ValidarDatos;
import dao.mysql.MySQLCMDao;
import dao.mysql.MySQLMedicoDao;
import dao.mysql.MySQLServicioDao;

public class MySqlDAOFactory extends DAOFactory{

	public static Connection crearConexion() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/citasmedicas";
			con = DriverManager.getConnection(url, "root", "root");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}

		return con;
	}

	@Override
	public I_CM getCMDao() {
		return new MySQLCMDao();
	}

	@Override
	public I_Servicio getServicio() {
		return new MySQLServicioDao();
	}
	
	@Override
	public I_Medico getMedico() {
		return new MySQLMedicoDao();
	}

	@Override
	public I_HistoriaMedica getHistoriaMedica() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public I_ValidarDatos getValidarDatos() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
