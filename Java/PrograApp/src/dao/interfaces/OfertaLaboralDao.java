package dao.interfaces;

import java.util.Vector;

import beans.OfertaLaboralBean;



public interface OfertaLaboralDao {
	
	
	public boolean agregar(int idCategoria, int idTrabajo) throws Exception;
	public boolean editar(OfertaLaboralBean ofertaLaboral) throws Exception;
	public boolean eliminar(int idOfertaLaboral) throws Exception;
	public Vector<OfertaLaboralBean> listar(int idPostulacion) throws Exception;

}
