package dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import beans.CategoriaBean;
import dao.interfaces.CategoriaDao;
import daofactory.MySqlDAOFactory;

public class MySql_CateoriaDao extends MySqlDAOFactory implements CategoriaDao {
	
	public boolean agregar(CategoriaBean categoria) throws Exception{
		boolean flag = false;
		try {
			Connection con = MySqlDAOFactory.crearConexion();
			Statement stmt = con.createStatement();
			int filas = stmt.executeUpdate("insert into Categoria(descripcion) values('"+categoria.getNomCat()+"');");
			
			if (filas == 1) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return flag;
	}
	public boolean editar(CategoriaBean categoria) throws Exception{
		boolean flag = false;
		try {
			Connection con = MySqlDAOFactory.crearConexion();
			Statement stmt = con.createStatement();
			int filas = stmt.executeUpdate("update categoria " +
					"set nomCat='"+categoria.getNomCat()+"' " +
					"where idCat="+ categoria.getIdCat());
			if(filas == 1){
				flag = true;
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}
	public boolean eliminar(int idCategoria) throws Exception{
		boolean flag = false;
		try {
			Connection con = MySqlDAOFactory.crearConexion();
			Statement stmt = con.createStatement();
			int filas = stmt.executeUpdate("delete from " +
					" Categoria where idCategoria=" + idCategoria);
			if(filas == 1){
				flag = true;
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}
	public Vector<CategoriaBean> listar() throws Exception{
		Vector<CategoriaBean> categoria = null;
		try {
			Connection con = MySqlDAOFactory.crearConexion();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from Categoria");
			
			categoria = new Vector<CategoriaBean>();
			CategoriaBean unbean = null;
			while(rs.next()){
				unbean = new CategoriaBean();
				unbean.setIdCat(rs.getInt(1));
				unbean.setNomCat(rs.getString(2));
				categoria.add(unbean);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return categoria;
	}

}
