package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CategoriaBean;
import beans.TipoMonedaBean;
import beans.TrabajoBean;
import dao.interfaces.CategoriaDao;
import dao.interfaces.TipoMonedaDao;
import dao.interfaces.TrabajoDao;
import daofactory.DAOFactory;

/**
 * Servlet implementation class Settings
 */
@WebServlet("/Settings")
public class Settings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Settings() {
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
		case 1:/*MOSTRAR CATEGORIA, TRABAJO Y TIPOMONEDA*/
			PrintWriter out = response.getWriter();
			try {
				
				
				DAOFactory dao =  DAOFactory.obtenerFactory(DAOFactory.MySql);
				
				
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
				request.getRequestDispatcher("/Admin/setting.jsp").forward(request, response);
			
			
			} catch (Exception e) {
				
				// TODO: handle exception
				request.setAttribute("mensaje", "error");
				request.getRequestDispatcher("/Admin/mensaje.jsp").forward(request, response);
				out.print(e.getMessage());
			}
			break;
			
		case 2: /**ELIMINAR CATEGORIA**/
			try {
				String codigo = request.getParameter("codigo");
				DAOFactory dao = 
						DAOFactory.obtenerFactory(DAOFactory.MySql);
				CategoriaDao categoria = dao.obtenerCategoria();
				boolean flag = categoria.eliminar(Integer.parseInt(codigo));
				if(flag){
					request.setAttribute("mensaje", "Categoria eliminada");
				}else{
					request.setAttribute("mensaje", "Ocurrio un error al eliminar");
				}
				request.getRequestDispatcher("/Admin/mensaje.jsp")
											.forward(request, response);
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}
			
			break;
		case 3:/**ELIMINAR TRABAJO**/
			try {
				String tip = request.getParameter("tip");
				String cat = request.getParameter("cat");
				
				DAOFactory dao = 
						DAOFactory.obtenerFactory(DAOFactory.MySql);
				TrabajoDao tipo = dao.obtenerTrabajo();
				boolean flag = tipo.eliminar(Integer.parseInt(cat),Integer.parseInt(tip));
				if(flag){
					request.setAttribute("mensaje", "Tipo Eliminado");
				}else{
					request.setAttribute("mensaje", "Ocurrio un error al eliminar Trabajo");
				}
				request.getRequestDispatcher("/Admin/mensaje.jsp")
											.forward(request, response);
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}
			break;
			
		case 4:/**ELIMINAR MONEDA**/
			try {
				String cod = request.getParameter("codigo");
				
				
				DAOFactory dao = DAOFactory.obtenerFactory(DAOFactory.MySql);
				TipoMonedaDao moneda = dao.obtenerTipoMoneda();
				boolean flag = moneda.eliminar(Integer.parseInt(cod));
				if(flag){
					request.setAttribute("mensaje", "Moneda Eliminada");
				}else{
					request.setAttribute("mensaje", "Ocurrio un error al eliminar");
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
		case 1:/**AGREGAR CATEGORIA**/
			
			try {
				
			
			String nombre = request.getParameter("Descripcion");
			CategoriaBean uncategoria = new CategoriaBean();
			uncategoria.setNomCat(nombre);
			DAOFactory dao =  DAOFactory.obtenerFactory(DAOFactory.MySql);
			CategoriaDao categoria = dao.obtenerCategoria();
			boolean flag = categoria.agregar(uncategoria);
		
		
		if(flag){
			request.setAttribute("mensaje", "Categoria Guardada");
		}else{
			request.setAttribute("mensaje", "ocurrio un error");
		}
		request.getRequestDispatcher("/Admin/mensaje.jsp").forward(request, response);
		
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			break;
		case 2:
			try {
				String nombre = request.getParameter("Descripcion");
				String idCategoria = request.getParameter("Cat");
				TrabajoBean tipo = new TrabajoBean();
				tipo.setTipoTrabajo(nombre);
				tipo.setIdCategoria(Integer.parseInt(idCategoria));
				DAOFactory dao =  DAOFactory.obtenerFactory(DAOFactory.MySql);
				TrabajoDao puesto = dao.obtenerTrabajo();
				boolean flag = puesto.agregar(tipo);
			
			if(flag){
				request.setAttribute("mensaje", "Tipo guardado");
			}else{
				request.setAttribute("mensaje", "ocurrio un error");
			}
			request.getRequestDispatcher("/Admin/mensaje.jsp").forward(request, response);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			break;
		case 3:
			try {
				String nombre = request.getParameter("Descripcion");
				TipoMonedaBean moneda = new TipoMonedaBean();
				moneda.setNomMoneda(nombre);
				DAOFactory dao =  DAOFactory.obtenerFactory(DAOFactory.MySql);
				TipoMonedaDao monedaDao= dao.obtenerTipoMoneda();
				boolean flag = monedaDao.agregar(moneda);
			
				if(flag){
					request.setAttribute("mensaje", "Moneda Agregada");
				}else{
					request.setAttribute("mensaje", "ocurrio un error");
				}
				request.getRequestDispatcher("/Admin/mensaje.jsp").forward(request, response);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	
			break;

		default:
			break;
		}
		
	}

}
