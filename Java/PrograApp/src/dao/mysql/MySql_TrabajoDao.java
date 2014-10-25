package dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import beans.TrabajoBean;
import dao.interfaces.TrabajoDao;
import daofactory.MySqlDAOFactory;

public class MySql_TrabajoDao extends MySqlDAOFactory implements TrabajoDao{
	
	public boolean agregar(TrabajoBean trabajo) throws Exception{
		boolean flag = false;
		try {
			Connection con = MySqlDAOFactory.crearConexion();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select max(idTrabajo)+1 from Trabajo where idCategoria="+trabajo.getIdCategoria()+";");
			int nuevo=0;
			if(rs.next()){
				nuevo=rs.getInt(1);
			}
			
			int filas = stmt.executeUpdate("insert into Trabajo(idCategoria,idTrabajo,tipoTrabajo) values ("+trabajo.getIdCategoria()
					+","+nuevo+",'"+trabajo.getTipoTrabajo()+"');");
			
			if (filas == 1) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return flag;
	}
	public boolean editar(TrabajoBean trabajo) throws Exception{
		return false;
	}
	public boolean eliminar(int idCategoria,int idTrabajo) throws Exception{
		boolean flag = false;
		try {
			Connection con = MySqlDAOFactory.crearConexion();
			Statement stmt = con.createStatement();
			int filas = stmt.executeUpdate("delete from " +
					" Trabajo where idCategoria=" + idCategoria+" and idTrabajo="+idTrabajo);
			if(filas == 1){
				flag = true;
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}
	public Vector<TrabajoBean> listar() throws Exception{
		Vector<TrabajoBean> tipos = null;
		try {
			Connection con = MySqlDAOFactory.crearConexion();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select idTrabajo, idCategoria, tipoTrabajo from Trabajo;");
			
			tipos = new Vector<TrabajoBean>();
			TrabajoBean unbean = null;
			while(rs.next()){
				unbean = new TrabajoBean();
				unbean.setIdTrabajo(rs.getInt(1));
				unbean.setIdCategoria(rs.getInt(2));
				unbean.setTipoTrabajo(rs.getString(3));
				tipos.add(unbean);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return tipos;
	}

}
