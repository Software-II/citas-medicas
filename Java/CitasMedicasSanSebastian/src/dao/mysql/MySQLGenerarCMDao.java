package dao.mysql;

import beans.BeanCitaMedica;
import dao.interfaces.I_GenerarCM;
import dao.factory.MySqlDAOFactory;

public class MySQLGenerarCMDao extends MySqlDAOFactory implements I_GenerarCM{

	@Override
	public void grabarCM(BeanCitaMedica beanCitaMedica) throws Exception {
		
	}

	@Override
	public int generarNumCitaMedica() throws Exception {
		
		return 0;
	}

	
	
}
