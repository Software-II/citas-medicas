package dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import beans.TipoMonedaBean;
import dao.interfaces.TipoMonedaDao;
import daofactory.MySqlDAOFactory;

public class MySql_TipoMonedaDao extends MySqlDAOFactory implements TipoMonedaDao{

	public boolean agregar(TipoMonedaBean tipoMoneda) throws Exception{
		boolean flag = false;
		try {
			Connection con = MySqlDAOFactory.crearConexion();
			Statement stmt = con.createStatement();
			int filas = stmt.executeUpdate("insert into TipoMoneda (descripcion,estado) values('"+tipoMoneda.getNomMoneda()+"',1);");
			
			if (filas == 1) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return flag;
	}
	public boolean editar(TipoMonedaBean tipoMoneda) throws Exception{
		return false;
	}
	public boolean eliminar(int idTipoMoneda) throws Exception{
		boolean flag = false;
		try {
			Connection con = MySqlDAOFactory.crearConexion();
			Statement stmt = con.createStatement();
			int filas = stmt.executeUpdate("delete from " +
					" TipoMoneda where idMoneda=" + idTipoMoneda);
			if(filas == 1){
				flag = true;
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}
	public Vector<TipoMonedaBean> listar() throws Exception{
		Vector<TipoMonedaBean> monedas = new Vector<TipoMonedaBean>();
		try {
			Connection con = MySqlDAOFactory.crearConexion();
			Statement stmt = con.createStatement();
			ResultSet rs =stmt.executeQuery("select * from TipoMoneda;");
			
			
			while(rs.next()){
				
				TipoMonedaBean moneda= new TipoMonedaBean();
				moneda.setIdTipoMoneda(rs.getInt(1));
				moneda.setNomMoneda(rs.getString(2));
				
				monedas.add(moneda);
				
			
			}	
			
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return monedas;
	}
	
	
}
