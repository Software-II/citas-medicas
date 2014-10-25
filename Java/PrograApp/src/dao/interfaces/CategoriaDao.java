package dao.interfaces;

import java.util.Vector;

import beans.CategoriaBean;

public interface CategoriaDao {
	
	public boolean agregar(CategoriaBean categoria) throws Exception;
	public boolean editar(CategoriaBean categoria) throws Exception;
	public boolean eliminar(int idCategoria) throws Exception;
	public Vector<CategoriaBean> listar() throws Exception;
	

}
