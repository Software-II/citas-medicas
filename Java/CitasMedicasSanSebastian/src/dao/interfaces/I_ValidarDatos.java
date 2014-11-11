package dao.interfaces;


import beans.BeanPaciente;

public interface I_ValidarDatos {

	public BeanPaciente buscarPacientePorDNI(String dni) throws Exception;
	public BeanPaciente buscarPacientePorHuella() throws Exception;
	public BeanPaciente obtenerDatos(String dato);
}
