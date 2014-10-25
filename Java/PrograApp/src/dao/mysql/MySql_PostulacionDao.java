package dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import beans.PostulacionBean;
import dao.interfaces.PostulacionDao;
import daofactory.MySqlDAOFactory;

public class MySql_PostulacionDao extends MySqlDAOFactory implements PostulacionDao{
	
	
	
	public boolean agregar(PostulacionBean postulacion) throws Exception{
		boolean flag = false;
		try {
			Connection con = MySqlDAOFactory.crearConexion();
			Statement stmt = con.createStatement();
			int filas = stmt.executeUpdate("insert into Postulacion (idUsuario,idMoneda,fechDispo,fechPostulacion,salario,cvRuta, webPersona)"
					+ " values((select max(idUsuario) from Usuario),"+
					postulacion.getIdMoneda()+",CURDATE(),CURDATE(),"+
					postulacion.getSalario()+",'"+postulacion.getCvRuta()+"','"+postulacion.getWebPersona()+"')");
		
			if (filas == 1) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
			
		}
		return flag;
	}
	public boolean editar(PostulacionBean postulacion) throws Exception{
		boolean flag = false;
		try {
			Connection con = MySqlDAOFactory.crearConexion();
			Statement stmt = con.createStatement();
			int filas = stmt.executeUpdate("update Postulacion " +
					"set idMoneda="+postulacion.getIdMoneda()+", " +
					"set fechDispo='"+postulacion.getFecDispo()+"', " +
					"set salario="+postulacion.getSalario()+", " +
					"set cvRuta='"+postulacion.getCvRuta()+"', " +
					"set webPersona='"+postulacion.getWebPersona()+"', " +
					"where idPostulacion="+ postulacion.getIdPostulacion());
			if(filas == 1){
				flag = true;
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}
	public boolean eliminar(int idPostulacion) throws Exception{
		return false;
	}
	public Vector<PostulacionBean> listar() throws Exception{
		Vector<PostulacionBean> post = new Vector<PostulacionBean>();
		try {
			Connection con = MySqlDAOFactory.crearConexion();
			Statement stmt = con.createStatement();
			ResultSet rs =stmt.executeQuery("select idPostulacion from Postulacion");
			
			PostulacionBean pos=null;
			while(rs.next()){
				pos= new PostulacionBean();
				pos.setIdPostulacion(rs.getInt("idPostulacion"));
				post.add(pos);
			}	
			
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return post;
	}
	
	@Override
	public PostulacionBean preactualizar(int idPos) throws Exception {
		PostulacionBean post = null;
		try {
			Connection con = MySqlDAOFactory.crearConexion();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select idPostulacion,idUsuario,idMoneda,fechDispo,fechPostulacion,salario,cvRuta, webPersona " +
					"from Postulacion where idUsuario=" + idPos);
			if(rs.next()){
				post = new PostulacionBean();
				post.setIdPostulacion(rs.getInt("idPostulacion"));
				post.setIdUsuario(rs.getInt("idUsuario"));
				post.setIdMoneda(rs.getInt("idMoneda"));
				post.setFecDispo(rs.getString("fechDispo"));
				post.setFecPostulacion(rs.getString("fechPostulacion"));
				post.setSalario(rs.getFloat("salario"));
				post.setCvRuta(rs.getString("cvRuta"));
				post.setWebPersona(rs.getString("webPersona"));
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return post;
	}
	
	
}
