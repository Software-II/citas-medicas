package daofactory;

import dao.interfaces.AdministradorDao;
import dao.interfaces.CategoriaDao;
import dao.interfaces.OfertaLaboralDao;
import dao.interfaces.PostulacionDao;
import dao.interfaces.PuestoTrabajoDao;
import dao.interfaces.TipoMonedaDao;
import dao.interfaces.TrabajoDao;
import dao.interfaces.TrabajoPostulacionDao;
import dao.interfaces.UsuarioDao;


public abstract class DAOFactory {

	public static int MySql = 1;
	public static int SqlServer = 2;
	
	public abstract CategoriaDao obtenerCategoria();
	public abstract OfertaLaboralDao obtenerOfertaLaboral();
	public abstract PostulacionDao obtenerPostulacion();
	public abstract PuestoTrabajoDao obtenerPuestoTrabajo();
	public abstract TipoMonedaDao obtenerTipoMoneda();
	public abstract TrabajoDao obtenerTrabajo();
	public abstract TrabajoPostulacionDao obtenerTrabajoPostulacion();
	public abstract UsuarioDao obtenerUsuario();
	public abstract AdministradorDao obtenerAdministrador();
	

	
	
	public static DAOFactory obtenerFactory(int origen){
		switch (origen) {
			case 1:
				//retornar el DAOFactory Mysql
				//return new MySqlDAOFactory();
				return new MySqlDAOFactory();
			case 2:
				//retornar el DAOFactory SqlServer
			default:
				return null;
		}
	}
	
	
}
