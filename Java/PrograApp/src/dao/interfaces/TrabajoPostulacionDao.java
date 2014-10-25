package dao.interfaces;

import java.util.Vector;

import beans.TrabajoPostulacionBean;

;

public interface TrabajoPostulacionDao {
	
	public boolean agregar(TrabajoPostulacionBean trabajoPostulacion) throws Exception;
	public boolean editar(TrabajoPostulacionBean trabajoPostulacion) throws Exception;
	public boolean eliminar(int idTrabajoPostulacion) throws Exception;
	public Vector<TrabajoPostulacionBean> listar() throws Exception;

}
