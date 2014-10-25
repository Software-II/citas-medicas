package dao.mysql;

import java.util.Vector;

import beans.TrabajoPostulacionBean;
import dao.interfaces.TrabajoPostulacionDao;
import daofactory.MySqlDAOFactory;

public class MySql_TrabajoPostulacionDao extends MySqlDAOFactory implements TrabajoPostulacionDao{

	public boolean agregar(TrabajoPostulacionBean trabajoPostulacion) throws Exception{
		return false;
	}
	public boolean editar(TrabajoPostulacionBean trabajoPostulacion) throws Exception{
		return false;
	}
	public boolean eliminar(int idTrabajoPostulacion) throws Exception{
		return false;
	}
	public Vector<TrabajoPostulacionBean> listar() throws Exception{
		return null;
	}
	
	
}
