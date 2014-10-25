package daofactory;

import java.sql.Connection;
import java.sql.DriverManager;

import dao.interfaces.AdministradorDao;
import dao.interfaces.CategoriaDao;
import dao.interfaces.OfertaLaboralDao;
import dao.interfaces.PostulacionDao;
import dao.interfaces.PuestoTrabajoDao;
import dao.interfaces.TipoMonedaDao;
import dao.interfaces.TrabajoDao;
import dao.interfaces.TrabajoPostulacionDao;
import dao.interfaces.UsuarioDao;
import dao.mysql.MySql_AdministradorDao;
import dao.mysql.MySql_CateoriaDao;
import dao.mysql.MySql_OfertaLaboralDao;
import dao.mysql.MySql_PostulacionDao;
import dao.mysql.MySql_PuestoTrabajoDao;
import dao.mysql.MySql_TipoMonedaDao;
import dao.mysql.MySql_TrabajoDao;
import dao.mysql.MySql_TrabajoPostulacionDao;
import dao.mysql.MySql_UsuarioDao;

public class MySqlDAOFactory extends DAOFactory{
	
	public static Connection crearConexion() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/prograAppDB";
			con = DriverManager.getConnection(url, "root", "root");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}

		return con;
	}
	
	@Override
	public CategoriaDao obtenerCategoria(){
		return new MySql_CateoriaDao();
	}
	
	@Override
	public OfertaLaboralDao obtenerOfertaLaboral(){
		return new MySql_OfertaLaboralDao();
	}
	
	@Override
	public PostulacionDao obtenerPostulacion(){
		return new MySql_PostulacionDao();
	}
	
	@Override
	public PuestoTrabajoDao obtenerPuestoTrabajo(){
		return new MySql_PuestoTrabajoDao();
	}
	
	@Override
	public TipoMonedaDao obtenerTipoMoneda(){
		return new MySql_TipoMonedaDao();
	}
	
	@Override
	public TrabajoDao obtenerTrabajo(){
		return new MySql_TrabajoDao();
	}
	
	@Override
	public TrabajoPostulacionDao obtenerTrabajoPostulacion(){
		return new MySql_TrabajoPostulacionDao();
	}
	
	@Override
	public UsuarioDao obtenerUsuario(){
		return new MySql_UsuarioDao();
	}
	@Override
	public AdministradorDao obtenerAdministrador() {
		return new MySql_AdministradorDao();
	}

}
