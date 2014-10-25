package dao.interfaces;

import java.util.Vector;

import beans.UsuarioBean;



public interface UsuarioDao {
	
	public boolean agregar(UsuarioBean usuario) throws Exception;
	public boolean editar(UsuarioBean usuario) throws Exception;
	public boolean eliminar(int idUsuario) throws Exception;
	public Vector<UsuarioBean> listar() throws Exception;
	public UsuarioBean validar(String usuario, String clave) throws Exception;
	public UsuarioBean ver(int idUsuario) throws Exception;

}
