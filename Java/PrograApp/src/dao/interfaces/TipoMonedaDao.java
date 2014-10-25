package dao.interfaces;

import java.util.Vector;

import beans.TipoMonedaBean;



public interface TipoMonedaDao {
	
	public boolean agregar(TipoMonedaBean tipoMoneda) throws Exception;
	public boolean editar(TipoMonedaBean tipoMoneda) throws Exception;
	public boolean eliminar(int idTipoMoneda) throws Exception;
	public Vector<TipoMonedaBean> listar() throws Exception;

}
