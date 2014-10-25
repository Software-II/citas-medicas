package dao.interfaces;

import java.util.Vector;

import beans.PuestoTrabajoBean;



public interface PuestoTrabajoDao {

	public boolean agregar(PuestoTrabajoBean puestoTrabajo) throws Exception;
	public boolean editar(PuestoTrabajoBean puestoTrabajo) throws Exception;
	public boolean eliminar(int idPuestoTrabajo) throws Exception;
	public Vector<PuestoTrabajoBean> listar() throws Exception;
}
