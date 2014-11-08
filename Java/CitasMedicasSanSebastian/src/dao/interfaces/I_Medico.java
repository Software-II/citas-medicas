package dao.interfaces;

import java.util.List;

import beans.BeanMedico;;

public interface I_Medico {

	public List<BeanMedico> buscarMedicoXServicio(String codServ, String nombre)throws Exception;
	
}
