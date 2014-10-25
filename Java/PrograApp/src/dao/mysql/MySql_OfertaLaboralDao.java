package dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import beans.OfertaLaboralBean;
import beans.PostulacionBean;
import dao.interfaces.OfertaLaboralDao;
import daofactory.MySqlDAOFactory;

public class MySql_OfertaLaboralDao extends MySqlDAOFactory implements OfertaLaboralDao{

	
	public boolean agregar(int idCategoria, int idTrabajo) throws Exception{
		boolean flag = false;
		try {
			Connection con = MySqlDAOFactory.crearConexion();
			Statement stmt = con.createStatement();
			
			ResultSet rs =stmt.executeQuery("select count(idPostulacion) "
					+ "from TrabajoPostulacion where idCategoria="+idCategoria+" and idTrabajo="+idTrabajo+";");
			int cant=0;
			
			if(rs.next()){
				cant=rs.getInt(1);
			}
			
			rs =stmt.executeQuery("select max(idPuestoTrabajo) from PuestoTrabajo;");
			int idPuestoTrabajo=0;
			
			if(rs.next()){
				idPuestoTrabajo=rs.getInt(1);
			}
			

			JOptionPane.showMessageDialog(null, idPuestoTrabajo, "Agregar Usuario", JOptionPane.ERROR_MESSAGE);
			
			int[] usuarios= new int[cant];
			
			rs =stmt.executeQuery("select idPostulacion "
					+ "from TrabajoPostulacion where idCategoria="+idCategoria+" and idTrabajo="+idTrabajo+"; ");
			
			int j=0;
			while(rs.next()){
				usuarios[j]=rs.getInt("idPostulacion");
				j++;
			}
			
			
			int filas=0;
			for(int i=0; i<usuarios.length; i++){
				filas +=stmt.executeUpdate("insert into OfertasLaborales "
						+ "(idPuestoTrabajo, idPostulacion, estado) "
						+ "values("+idPuestoTrabajo+","+usuarios[i]+",1);");
			}
			
			
			
			if (filas >= 1) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return flag;
	}
	public boolean editar(OfertaLaboralBean ofertaLaboral) throws Exception{
		return false;
	}
	public boolean eliminar(int idOfertaLaboral) throws Exception{
		return false;
	}
	public Vector<OfertaLaboralBean> listar(int idUsuario) throws Exception{
		
		
		Vector<OfertaLaboralBean> ofertas = new Vector<OfertaLaboralBean>();
		try {
			Connection con = MySqlDAOFactory.crearConexion();
			Statement stmt = con.createStatement();
			ResultSet rs =stmt.executeQuery("select PT.idCategoria,PT.idPuestoTrabajo, OL.idPostulacion, C.descripcion, T.tipoTrabajo , PT.descripcion from OfertasLaborales OL "
					+ "inner join Postulacion P on OL.idPostulacion=P.idPostulacion "
					+ "inner join PuestoTrabajo PT on OL.idPuestoTrabajo=PT.idPuestoTrabajo "
					+ "inner join Trabajo T on PT.idCategoria=T.idCategoria and PT.idTrabajo=T.idTrabajo "
					+ "inner join Categoria C on T.idCategoria=C.idCategoria "
					+ "where OL.estado='1' and P.idUsuario='"+idUsuario+"';");
			
			
			OfertaLaboralBean oferta=null;
			while(rs.next()){
				oferta= new OfertaLaboralBean();
				oferta.setIdCategoria(rs.getInt("PT.idCategoria"));
				oferta.setIdTrabajo(rs.getInt("PT.idPuestoTrabajo"));
				oferta.setIdPostulacion(rs.getInt("OL.idPostulacion"));
				oferta.setCategoria(rs.getString("C.descripcion"));
				oferta.setTrabajo(rs.getString("T.tipoTrabajo"));
				oferta.setDescripcion(rs.getString("PT.descripcion"));
				
				ofertas.add(oferta);
			}	
			
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
			JOptionPane.showMessageDialog(null, "no sql", "Agregar Usuario", JOptionPane.ERROR_MESSAGE);
		}
		return ofertas;
	}
}
