package servlets;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import beans.CategoriaBean;
import beans.OfertaLaboralBean;
import beans.PostulacionBean;
import beans.PuestoTrabajoBean;
import beans.TipoMonedaBean;
import beans.TrabajoBean;
import beans.UsuarioBean;
import dao.interfaces.CategoriaDao;
import dao.interfaces.OfertaLaboralDao;
import dao.interfaces.PostulacionDao;
import dao.interfaces.PuestoTrabajoDao;
import dao.interfaces.TipoMonedaDao;
import dao.interfaces.TrabajoDao;
import dao.interfaces.UsuarioDao;
import daofactory.DAOFactory;

/**
 * Servlet implementation class ResgitroUsuario
 */
@WebServlet(description = "Aqui se atenderan todas las peticiones del usuario", urlPatterns = { "/Usuarios" })
public class Usuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Usuarios() {
        super();
        // TODO Auto-generated constructor stub
        
        
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		try {
			HttpSession sesiones = request.getSession();
			sesiones.removeAttribute("nombreadmin");
			
			response.sendRedirect("admin/login.jsp");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int key = Integer.parseInt(request.getParameter("key"));
		
		switch (key) {
		case 1: /**AGREGAR USUARIO**/
			
			try {
				String nombre  = request.getParameter("nombre");
				String apellido = request.getParameter("apellido");
				String correo = request.getParameter("correo");
				String telefono = request.getParameter("telefono");
				String fechNac = request.getParameter("fechnac");
				String contra = request.getParameter("contra");
				String contra2 = request.getParameter("contra2");
				
				if(contra.equals(contra2)){
					UsuarioBean usuarioBean = new beans.UsuarioBean();
					
					usuarioBean.setNombre(nombre);
					usuarioBean.setApellido(apellido);
					usuarioBean.setCorreo(correo);
					usuarioBean.setTelefono(Integer.parseInt(telefono));
					usuarioBean.setFechNac(fechNac);
					usuarioBean.setContra(contra);
					usuarioBean.setEstado(1);
					
					
					
					DAOFactory dao = DAOFactory.obtenerFactory(DAOFactory.MySql);
					UsuarioDao usuario= dao.obtenerUsuario();
					boolean flag = usuario.agregar(usuarioBean);
					if(flag){
						request.setAttribute("mensaje", "Usuario Agregado");
						
						
						/*String fechaDisp = request.getParameter("text2");
						String salario   = request.getParameter("text1");
						String moneda = request.getParameter("select2");
						String portafolio = request.getParameter("textfield");*/
						
						String fechaDisp = "2000-01-01";
						String salario   = "0.00";
						String moneda = "1";
						String portafolio = "Web Personal no registrado";
						
						PostulacionBean postBean= new PostulacionBean();
						postBean.setFecDispo(fechaDisp);
						postBean.setSalario(Float.parseFloat(salario));
						postBean.setIdMoneda(Integer.parseInt(moneda));
						postBean.setCvRuta("--");
						postBean.setWebPersona(portafolio);
						
						
						PostulacionDao post= dao.obtenerPostulacion();
						
						boolean flag2 = post.agregar(postBean);
						
						
						
					}else{
						request.setAttribute("mensaje", "Ocurrio un error al Agregar Usuario");
					}
					request.getRequestDispatcher("mensaje.jsp")
												.forward(request, response);
				}else{
					request.setAttribute("mensaje", "Las contraseñas no coinciden");
					request.getRequestDispatcher("publico.jsp")
					.forward(request, response);
				}
				
				
				
			} catch (Exception e) {
				System.out.print(e.getMessage());
				JOptionPane.showMessageDialog(null, e.getMessage(), "Agregar Usuario", JOptionPane.ERROR_MESSAGE);
			}
			
			
			break;
		case 2: /** LOGIN USUARIO**/
			try {
				String correo = request.getParameter("correo");
				String contra = request.getParameter("contra");
				
				DAOFactory dao = DAOFactory.obtenerFactory(DAOFactory.MySql);
				UsuarioDao usuDao= dao.obtenerUsuario();
				UsuarioBean usu = usuDao.validar(correo, contra);
				
				Vector<OfertaLaboralBean>  ofertas= new Vector<OfertaLaboralBean>();
				OfertaLaboralDao ofertaDao= dao.obtenerOfertaLaboral();
				ofertas= ofertaDao.listar((usu.getIdUsuario()));
				
				
				
				request.setAttribute("ofertas", ofertas);
				
				
				
				
				
				
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
				
				
				PostulacionDao post = dao.obtenerPostulacion();
				PostulacionBean bean = 
						post.preactualizar((usu.getIdUsuario()));
				
				request.setAttribute("postulacion", bean);
				
				
				UsuarioDao usuDao2= dao.obtenerUsuario();
				UsuarioBean usu2 = usuDao2.ver((usu.getIdUsuario()));
				
				request.setAttribute("usuario", usu2);
				
				
				
				if(usu==null){
					response.sendRedirect("publico.jsp");
					
				}else{
					if(usu.getEstado()==1){
					HttpSession sesiones = request.getSession();
					sesiones.setAttribute("nombreausu", usu.getNombre());			
					sesiones.setAttribute("idausu", usu.getIdUsuario());
					
					request.getRequestDispatcher("Usuario/perfil.jsp").forward(request, response);
					
			
					}else{
						response.sendRedirect("Usuario/popUp.jsp");
						
					}
					}
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.print(e.getMessage());
			}
			
			
			
			break;
			
		case 3: /** USUARIO**/
			
			break;

		default:
			break;
		}
		
		
		
		
	}

}
