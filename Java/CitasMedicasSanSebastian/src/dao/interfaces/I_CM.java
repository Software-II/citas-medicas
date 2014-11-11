package dao.interfaces;

import java.util.List;

import beans.BeanCitaMedica;

public interface I_CM {

	public int grabarCM(BeanCitaMedica beanCitaMedica) throws Exception;
	public int generarNumCitaMedica()throws Exception;
	public List<BeanCitaMedica> listarCM (int codPac) throws Exception;
	public int confirmarCM(double saldo, BeanCitaMedica beanCitaMedica) throws Exception;
}
