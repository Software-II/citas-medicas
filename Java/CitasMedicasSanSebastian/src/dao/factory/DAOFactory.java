package dao.factory;

import dao.interfaces.I_GenerarCM;
import dao.interfaces.I_Medico;
import dao.interfaces.I_Servicio;

public abstract class DAOFactory {
	
	public static int MySql = 1;
	public static int SqlServer = 2;
	
	public abstract I_GenerarCM getCMDao();
	public abstract I_Servicio getServicio();
	public abstract I_Medico getMedico();
	
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
