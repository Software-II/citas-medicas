package dao.interfaces;

import java.util.Vector;

import beans.PostulacionBean;

;

public interface PostulacionDao {
	
	public boolean agregar(PostulacionBean postulacion) throws Exception;
	public boolean editar(PostulacionBean postulacion) throws Exception;
	public boolean eliminar(int idPostulacion) throws Exception;
	public Vector<PostulacionBean> listar() throws Exception;
	public PostulacionBean preactualizar(int idPos) throws Exception;

}
