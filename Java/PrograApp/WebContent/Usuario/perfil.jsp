
<%@page import="beans.TrabajoBean"%>
<%@page import="beans.PuestoTrabajoBean"%>
<%@page import="beans.CategoriaBean"%>
<%@page import="beans.TipoMonedaBean"%>
<%@page import="beans.PostulacionBean"%>
<%@page import="beans.UsuarioBean"%>
<%@page import="beans.OfertaLaboralBean"%>
<%@page import="java.util.Vector"%>
<%@page import="javax.swing.JOptionPane"%>




<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>

<meta charset="utf-8" />
        <meta name="viewport" content="width = device-width, initial-scale=1, maximum-scale=1">
        <title>GDAYXs</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script src="Admin/js/nav.js"></script>
        <link rel="stylesheet" type="text/css" href="Admin/css/style.css">

</head>


<%
	Vector<PuestoTrabajoBean> puestos= (Vector)request.getAttribute("puestos");
%>
<%
	Vector<CategoriaBean> categorias= (Vector)request.getAttribute("categorias");
%>
<%
	Vector<TrabajoBean> tipos= (Vector)request.getAttribute("tipos");
%>
<%
	Vector<TipoMonedaBean> monedas= (Vector)request.getAttribute("monedas");
%>
<%
	Vector<OfertaLaboralBean> ofertas= (Vector)request.getAttribute("ofertas");
%>
<%  PostulacionBean postulacion= (PostulacionBean)request.getAttribute("postulacion");%>
<%  UsuarioBean usuario= (UsuarioBean)request.getAttribute("usuario");%>
<body>
		<header>
		<img class="logo" src="Admin/img/DOta.jpg" /><h1>Nombre de la empresa</h1><h2><%=session.getAttribute("nombreausu") %> </h2><img class="user" src="Admin/img/usuario.jpg"> 
		</header>
		
		<div style="text-align: center; width: 1000px; margin: 0px auto;">
		<section style=" padding-top:40px; width:45%; height:90%;  display: inline-block; margin-left: 10px;">
		
			<h2>Datos Personales</h2>
			<form class="formulario" method="post" action="<%=request.getContextPath() %>/Usuarios">
			<input type="hidden" name="key" value="1">
            <input name="nombre" type="text" placeholder="<%=usuario.getNombre()%>" required>
            <input name="apellido" type="text" placeholder="<%=usuario.getApellido()%>" required>
            <input name="correo" type="email" placeholder="<%=usuario.getCorreo()%>" required>
            <input name="telefono" type="text" placeholder="<%=usuario.getTelefono()%>" required>
            <input name="fechnac" type="date" required>
            <input name="contra" type="password" placeholder="contraseña" required>
            <input type="submit" class="boton" value="Actualizar">
			<br><br>
			<hr>
			</form>
			<br><br>
			
			
			<form class="formulario" method="post" action="<%=request.getContextPath() %>/Puestos">
		
			<h2>Perfil Postulante</h2>
           <input type="hidden" value="1" name="key" /> 
                
				<label>
                        <select name="moneda"><%for(int i=0; i<monedas.size(); i++) {
                        	
                        		if(i+1==postulacion.getIdMoneda()){
                        			//JOptionPane.showMessageDialog(null, postulacion.getIdMoneda(), "Agregar Usuario", JOptionPane.ERROR_MESSAGE);
                        			  %>
      								<option value="<%=monedas.get(i).getIdTipoMoneda()%>" selected><%=monedas.get(i).getNomMoneda() %> </option>
      								<%
                        		}else{
                        			%>
    								<option value="<%=monedas.get(i).getIdTipoMoneda()%>"><%=monedas.get(i).getNomMoneda() %> </option>
    								<%
                        		}
                        
								}
								%>
                        </select>
                </label>
                <input type="text" placeholder="<%=postulacion.getSalario()%>" name="salario">
                <input type="Date" placeholder="<%=postulacion.getFecDispo()%> name="inicio">
                <input type="url" placeholder="<%=postulacion.getWebPersona()%>" name="web">
				<input type="file" style="width: 90%; margin-left: -10%;" placeholder="<%=postulacion.getCvRuta()%>">
                <input type="submit" class="boton" value="Actualizar">
                <br><br>
                <hr>
           </form>
           <br><br>
           
           <form class="formulario" method="post" action="<%=request.getContextPath() %>/Puestos" style="overflow: scroll; height: 175px;">
		
		<h2>Tipo de Trabajo</h2>
		
		 		<label style="position: relative; top: 0px; left: -150px;">
                        <select name="catego"><%for(int i=0; i<categorias.size(); i++) {%>
                                <option value="<%=categorias.get(i).getIdCat()%>"><%=categorias.get(i).getNomCat()%></option>
                                <%
								}
								%>
                        </select>
                </label>
                <label style="position: relative; top: -45px; left: 60px;">
                        <select name="tipo"><%for(int i=0; i<tipos.size(); i++) {%>
                                <option value="<%=tipos.get(i).getIdTrabajo()%>"><%=tipos.get(i).getTipoTrabajo()%></option>
                                <%
								}
								%>
                        </select>
                </label>
                <input style="position: relative; top: -45px; left: 70px;" type="submit" class="boton" value="Agregar">
                <div style="width: 80%;" class="titulo">Este es el titulo</div><a>del</a><br>
                <div style="width: 80%;" class="titulo">Este es el titulo</div><a>del</a><br>
                <div style="width: 80%;" class="titulo">Este es el titulo</div><a>del</a><br>
                <div style="width: 80%;" class="titulo">Este es el titulo</div><a>del</a><br>
                <div style="width: 80%;" class="titulo">Este es el titulo</div><a>del</a><br>
                
                <br><br>
			<hr>
           </form> 
		
		</section>
		
		
		
		
		
		
		<!-- LISTAR LO QUE ESTA AGREGADO -->
		
		
		<section style=" padding-top:40px; width:45%; height:1000px; 
		 display: inline-block;  position:relative; top:0px; overflow: scroll; margin-left: 10px;">
	
			<h2>Mis Ofertas</h2>
			
			<!-- LISTAR LAS OFERTAS LABORALES -->
			<%for(int i=0; i<ofertas.size(); i++) {
				
			%>
			
			<article class="trabajos">
			<br><br>
			<div class="titulo"><%=ofertas.get(i).getCategoria()%> - <%=ofertas.get(i).getTrabajo()%> </div>
			<div class="desc"><%=ofertas.get(i).getDescripcion()%></div>
			<a>X</a>
			</article>
			<%}
			
			%>
		
		</section>
		
		
		
		</div>

</body>
</html>