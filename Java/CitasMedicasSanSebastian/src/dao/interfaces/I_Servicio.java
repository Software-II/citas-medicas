package dao.interfaces;

import java.util.List;

import beans.BeanServicio;

public interface I_Servicio {

	public List<BeanServicio> buscarServicio(String key) throws Exception;
	
}
