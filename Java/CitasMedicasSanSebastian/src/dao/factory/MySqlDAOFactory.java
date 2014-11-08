package dao.factory;

import java.sql.Connection;
import java.sql.DriverManager;

import dao.interfaces.I_GenerarCM;
import dao.interfaces.I_Medico;
import dao.interfaces.I_Servicio;
import dao.mysql.MySQLGenerarCMDao;
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
	public I_GenerarCM getCMDao() {
		return new MySQLGenerarCMDao();
	}

	@Override
	public I_Servicio getServicio() {
		return new MySQLServicioDao();
	}
	
	@Override
	public I_Medico getMedico() {
		return new MySQLMedicoDao();
	}
	
}
