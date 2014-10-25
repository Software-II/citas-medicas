package dao.interfaces;

import java.util.Vector;

import beans.TrabajoBean;



public interface TrabajoDao {

	
	public boolean agregar(TrabajoBean trabajo) throws Exception;
	public boolean editar(TrabajoBean trabajo) throws Exception;
	public boolean eliminar(int idCategoria, int idTrabajo) throws Exception;
	public Vector<TrabajoBean> listar() throws Exception;
}
