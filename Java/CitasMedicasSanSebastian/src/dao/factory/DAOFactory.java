package dao.factory;

import dao.interfaces.I_CM;
import dao.interfaces.I_HistoriaMedica;
import dao.interfaces.I_Medico;
import dao.interfaces.I_Servicio;
import dao.interfaces.I_ValidarDatos;

public abstract class DAOFactory {
	
	public static int MySql = 1;
	public static int SqlServer = 2;
	
	public abstract I_CM getCMDao();
	public abstract I_Servicio getServicio();
	public abstract I_Medico getMedico();
	public abstract I_HistoriaMedica getHistoriaMedica();
	public abstract I_ValidarDatos getValidarDatos();
	
	public static DAOFactory getDaoFactory(int origen){
		switch (origen) {
			case 1:
				//retornar el DAOFactory Mysql
				//return new MySqlDAOFactory();
				return new MySqlDAOFactory();
			case 2:
				//retornar el DAOFactory SqlServer
			default:
				return null;
		}
	}

}
