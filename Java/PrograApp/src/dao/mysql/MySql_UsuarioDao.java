package dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import beans.UsuarioBean;
import dao.interfaces.UsuarioDao;
import daofactory.MySqlDAOFactory;

public class MySql_UsuarioDao extends MySqlDAOFactory implements UsuarioDao{

	public boolean agregar(UsuarioBean usuario) throws Exception{
		
		boolean flag = false;
		try {
			Connection con = MySqlDAOFactory.crearConexion();
			Statement stmt = con.createStatement();
			
			String query= "insert into Usuario (nombre,apellidos,fechNac, telefono, correo, contra, estado) values ('dota','peru','2000-01-01',12345678,'hola@hola.com',444,1);";
			//int filas= stmt.executeUpdate(query);
			
			int filas = stmt.executeUpdate("insert into Usuario (nombre, apellidos,fechNac, telefono, correo, contra, estado) values "
					+ "('"+usuario.getNombre()+"','"+usuario.getApellido()+"','"+usuario.getFechNac()+"',"+usuario.getTelefono()+",'"+usuario.getCorreo()+"','"+usuario.getContra()+"',"+usuario.getEstado()+");");
			if(filas == 1){
				flag = true;
			}
			
			
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
			JOptionPane.showMessageDialog(null, e.getMessage(), "ola", JOptionPane.ERROR_MESSAGE);
		}
		
		return flag;
	}
	public boolean editar(UsuarioBean usuario) throws Exception{
		return false;
	}
	public boolean eliminar(int idUsuario) throws Exception{
		return false;
	}
	public Vector<UsuarioBean> listar() throws Exception{
		return null;
	}
	
	@Override
	public UsuarioBean validar(String correo, String contrasena) throws Exception {
		// TODO Auto-generated method stub
		
		UsuarioBean usuario = null;
		try {
			Connection con = MySqlDAOFactory.crearConexion();
			Statement stmt = con.createStatement();
			ResultSet rs =
					stmt.executeQuery("select nombre, idUsuario , estado " +
					"from Usuario " +
					"where correo ='"+correo+"' " +
					"and contra='"+contrasena+"'");
			if(rs.next()){
				usuario = new UsuarioBean();
				usuario.setIdUsuario(rs.getInt("idUsuario"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setEstado(rs.getInt("estado"));
			}						
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}		
		return usuario;
	}
	
	public UsuarioBean ver(int idUsuario) throws Exception{
		UsuarioBean usuario = null;
		try {
			Connection con = MySqlDAOFactory.crearConexion();
			Statement stmt = con.createStatement();
			ResultSet rs =
					stmt.executeQuery("select nombre,apellidos, telefono, correo " +
					"from Usuario " +
					"where idUsuario ="+idUsuario+";");
			if(rs.next()){
				usuario = new UsuarioBean();
				
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellido(rs.getString("apellidos"));
				usuario.setTelefono(rs.getInt("telefono"));
				usuario.setCorreo(rs.getString("correo"));
			}						
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}		
		return usuario;
		
	}
	
	
}
