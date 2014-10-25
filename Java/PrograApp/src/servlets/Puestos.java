package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import beans.CategoriaBean;
import beans.PuestoTrabajoBean;
import beans.TipoMonedaBean;
import beans.TrabajoBean;
import dao.interfaces.CategoriaDao;
import dao.interfaces.OfertaLaboralDao;
import dao.interfaces.PuestoTrabajoDao;
import dao.interfaces.TipoMonedaDao;
import dao.interfaces.TrabajoDao;
import daofactory.DAOFactory;

/**
 * Servlet implementation class RegitroPuesto
 */
@WebServlet("/Puestos")
public class Puestos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Puestos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		int key = Integer.parseInt(request.getParameter("key"));
		
		switch (key) {
		case 1:/*LISTAR PUESTOS */
			PrintWriter out = response.getWriter();
			try {
				
				
				DAOFactory dao =  DAOFactory.obtenerFactory(DAOFactory.MySql);
				Vector<PuestoTrabajoBean> puestos= new Vector<PuestoTrabajoBean>();
				PuestoTrabajoDao puesto= dao.obtenerPuestoTrabajo();
				puestos= puesto.listar();
				
				Vector<CategoriaBean> categorias = new Vector<CategoriaBean>();
				CategoriaDao categoria= dao.obtenerCategoria();
				categorias= categoria.listar();
				
				Vector<TrabajoBean> tipos= new Vector<TrabajoBean>();
				TrabajoDao tipo = dao.obtenerTrabajo();
				
				tipos= tipo.listar();
				
				
				Vector<TipoMonedaBean> monedas = new Vector<TipoMonedaBean>();
				TipoMonedaDao moneda = dao.obtenerTipoMoneda();
				
				monedas = moneda.listar();
				
				request.setAttribute("monedas", monedas);
				request.setAttribute("categorias", categorias);
				request.setAttribute("tipos", tipos);
				request.setAttribute("puestos", puestos);
				request.getRequestDispatcher("/Admin/puestos.jsp").forward(request, response);
			
			
			} catch (Exception e) {
				
				// TODO: handle exception
				request.setAttribute("mensaje", "error");
				request.getRequestDispatcher("/Admin/mensaje.jsp").forward(request, response);
				out.print(e.getMessage());
			}
			break;
			
		case 2:/*ELIMINAR ELIMINAR PUESTO*/
			try {
				String codigo = request.getParameter("codigo");
				DAOFactory dao = DAOFactory.obtenerFactory(DAOFactory.MySql);
				PuestoTrabajoDao puesto = dao.obtenerPuestoTrabajo();
				boolean flag = puesto.eliminar(Integer.parseInt(codigo));
				if(flag){
					request.setAttribute("mensaje", "Puesto eliminada");
				}else{
					request.setAttribute("mensaje", "Ocurrio un error al eliminar, revisar Foreing Key");
				}
				request.getRequestDispatcher("/Admin/mensaje.jsp")
											.forward(request, response);
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}
			
			
			
			break;

		default:
			break;
		}
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int key = Integer.parseInt(request.getParameter("key"));
		
		switch (key) {
		case 1:/*AGREGAR PUESTOS */
			try {
				String catego = request.getParameter("catego");
				String tipo   = request.getParameter("tipo");
				String descripcion = request.getParameter("descripcion");
				String salario = request.getParameter("salario");
				String moneda = request.getParameter("moneda");
				String inicio = request.getParameter("inicio");
				String dias = request.getParameter("dias");
				String estado = request.getParameter("estado");
				
				PuestoTrabajoBean puestoBean= new PuestoTrabajoBean();
				puestoBean.setIdCategoria(Integer.parseInt(catego));
				puestoBean.setIdTrabajo(Integer.parseInt(tipo));
				puestoBean.setDescripcion(descripcion);
				puestoBean.setSalario(Float.parseFloat(salario));
				puestoBean.setIdTipoMoneda(Integer.parseInt(moneda));
				puestoBean.setFechaInicio(inicio);
				puestoBean.setDiasDis(Integer.parseInt(dias));
				puestoBean.setEstado(Integer.parseInt(estado));
				
				DAOFactory dao = DAOFactory.obtenerFactory(DAOFactory.MySql);
				PuestoTrabajoDao puesto = dao.obtenerPuestoTrabajo();
				boolean flag = puesto.agregar(puestoBean);
				
				OfertaLaboralDao ofertaDao = dao.obtenerOfertaLaboral();
				flag=ofertaDao.agregar(puestoBean.getIdCategoria(), 
						puestoBean.getIdTrabajo());
				
				
				
				
				if(flag){
					request.setAttribute("mensaje", "Puesto Agregado");
				}else{
					request.setAttribute("mensaje", "Ocurrio un error al Agregar ");
				}
				request.getRequestDispatcher("/Admin/mensaje.jsp")
											.forward(request, response);
			} catch (Exception e) {
				System.out.print(e.getMessage());
				JOptionPane.showMessageDialog(null, e.getMessage(), "Agregar Puesto", JOptionPane.ERROR_MESSAGE);
			}
			break;
			
		case 2:/*MODIFICAR ELIMINAR PUESTO*/
			
			break;

		default:
			break;
		}
		
	}

}
