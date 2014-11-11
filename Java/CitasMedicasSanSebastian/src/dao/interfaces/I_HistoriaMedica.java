package dao.interfaces;


import beans.BeanCitaMedica;
import beans.BeanHistoriaMedica;
import beans.BeanPaciente;

public interface I_HistoriaMedica {

	public BeanHistoriaMedica buscarHistorialMedico(int i) throws Exception;
	public BeanHistoriaMedica buscarPacientePorHuella() throws Exception;
}
