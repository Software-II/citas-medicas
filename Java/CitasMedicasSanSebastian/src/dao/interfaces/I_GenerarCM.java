package dao.interfaces;

import beans.BeanCitaMedica;

public interface I_GenerarCM {

	public void grabarCM(BeanCitaMedica beanCitaMedica) throws Exception;
	public int generarNumCitaMedica()throws Exception;
}
