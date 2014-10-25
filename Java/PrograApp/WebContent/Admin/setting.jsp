<%
	if(session.getAttribute("nombreadmin") == null){
		response.sendRedirect("login.jsp");
	}
%>

<%@page import="beans.TrabajoBean"%>
<%@page import="beans.CategoriaBean"%>
<%@page import="beans.TipoMonedaBean"%>
<%@page import="java.util.Vector"%>
<!DOCTYPE html>
<html lang="es">
<head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width = device-width, initial-scale=1, maximum-scale=1">
        <title>Puestos</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script src="Admin/js/nav.js"></script>
        <link rel="stylesheet" type="text/css" href="Admin/css/style.css">
</head>
<%
	Vector<CategoriaBean> categorias= (Vector)request.getAttribute("categorias");
%>
<%
	Vector<TrabajoBean> tipos= (Vector)request.getAttribute("tipos");
%>
<%
	Vector<TipoMonedaBean> monedas= (Vector)request.getAttribute("monedas");
%>
<body>
        <header>
                <img class="logo" src="Admin/img/DOta.jpg" /><h1>Nombre de la empresa</h1> <h2>Administrador </h2><img class="user" src="Admin/img/usuario.jpg">
                
        </header>


        <section class="settings" >
            <div class="linea"><div class="titulo1">CATEGORIA</div><div class="desc1"></div><div class="opcion1">Opciones</div><hr></div>
			<%for(int i=0; i<categorias.size(); i++) {%>
            <div class="linea"><div class="titulo"><%=categorias.get(i).getNomCat()%> </div>
            <div class="desc"></div><div class="opcion">
            <a class="activatorEditCategoria" href="#mod"><img class="ico" src="Admin/img/editar.png"></a>
            <a href="<%=request.getContextPath() %>/Settings?key=2&&codigo=<%=categorias.get(i).getIdCat()%>"><img class="ico"  src="Admin/img/eliminar.png"></a></div><hr></div>
             <%
					}
				%>

             <input id="activatorAddCategoria" type="button" value="Agregar" class="boton">




        </section>
        <section class="settings" >
             <div class="linea"><div class="titulo1">Tipo</div><div class="desc1"></div><div class="opcion1">Opciones</div><hr></div>

            
           <%for(int i=0; i<tipos.size(); i++) {%>
             <div class="linea"><div class="titulo"><%=tipos.get(i).getTipoTrabajo()%></div>
             <div class="desc"></div><div class="opcion">
             <a class="activatorEditTipo" href="#mod"><img class="ico" src="Admin/img/editar.png"></a>
             <a href="<%=request.getContextPath() %>/Settings?key=3&&cat=<%=tipos.get(i).getIdCategoria()%>&&tip=<%=tipos.get(i).getIdTrabajo()%>"><img class="ico"  src="Admin/img/eliminar.png"></a></div><hr></div>
             <%
					}
				%>
				<input id="activatorAddTipo" type="button" value="Agregar" class="boton">
        </section>
        <section class="settings" >
             <div class="linea"><div class="titulo1">Moneda</div><div class="desc1"></div><div class="opcion1">Opciones</div><hr></div>

            
            <%for(int i=0; i<monedas.size(); i++) {%>
             <div class="linea"><div class="titulo"><%=monedas.get(i).getNomMoneda() %>  </div>
             <div class="desc"></div><div class="opcion">
             <a class="activatorEditMoneda" href="#mod"><img class="ico" src="Admin/img/editar.png"></a>
             <a href="<%=request.getContextPath() %>/Settings?key=4&&codigo=<%=monedas.get(i).getIdTipoMoneda()%>"><img class="ico"  src="Admin/img/eliminar.png"></a></div><hr></div>
             <%
					}
				%>
				<input id="activatorAddMoneda" type="button" value="Agregar" class="boton">
        </section>


         <!-- The overlay and the box -->

         <!-- AGREGAR CATEGORIA -->

        <div class="overlay" id="overlay" style="display:none;"></div>
        <div class="box" id="boxAddCategoria">
            <a class="boxclose" id="boxcloseAddCategoria"></a>
            
           <form class="formulario" method="post" action="<%=request.getContextPath() %>/Settings">
           <input type="hidden" value="1" name="key" /> 
            <h2>Agregar Categoria</h2>
                <input type="text" placeholder="Nombre de la categoria" name="Descripcion">
                <input type="submit" class="boton" value="Ok">
           </form>
        </div>
        <!-- MODIFICAR CATEGORIA-->
        <div class="box" id="boxEditCategoria">
            <h2>Editar Categoria</h2>
            <a class="boxclose" id="boxcloseEditCategoria"></a>
            
           <form class="formulario">
                <input type="text" placeholder="Modificar Nombre">
                <input type="button" class="boton" value="Ok">
           </form>
        </div>

        <!-- AGREGAR TRABAJO -->
        
        <div class="box" id="boxAddTipo">
            <a class="boxclose" id="boxcloseAddTipo"></a>
            
           <form class="formulario" method="post" action="<%=request.getContextPath() %>/Settings">
           <input type="hidden" value="2" name="key" /> 
            <h2>Agregar Tipo Trabajo</h2>
                 <label>
                        <select name="Cat"><%for(int i=0; i<categorias.size(); i++) {%>
                                <option value="<%=categorias.get(i).getIdCat()%>"><%=categorias.get(i).getNomCat()%></option>
                                <%
								}
								%>
                        </select>
                </label><br>
                <input type="text" placeholder="Tipo Trabajo" name="Descripcion">
                <input type="submit" class="boton" value="Ok">
           </form>
        </div>

        <!-- EDITAR TRABAJO -->
        
        <div class="box" id="boxEditTipo">
            <a class="boxclose" id="boxcloseEditTipo"></a>
            
           <form class="formulario">
            <h2>Editar Tipo Trabajo</h2>
                <label>
                        <select><%for(int i=0; i<categorias.size(); i++) {%>
                                <option value="<%=categorias.get(i).getIdCat()%>"><%=categorias.get(i).getNomCat()%></option>
                                <%
								}
								%>
                        </select>
                </label>
                <input type="text" placeholder="Modificar tipo trabajo">
                <input type="button" class="boton" value="Ok">
            </form>
        </div>


        <!-- AGREGAR TIPOMONEDA-->
        
        <div class="box" id="boxAddMoneda">
            <a class="boxclose" id="boxcloseAddMoneda"></a>
            
           <form class="formulario"  method="post" action="<%=request.getContextPath() %>/Settings">
            <input type="hidden" value="3" name="key" /> 
            <h2>Agregar Moneda</h2>
                <input type="text" placeholder="Nombre Moneda" name="Descripcion">
                <input type="submit" class="boton" value="Ok">
            </form>
        </div>

        <!-- EDITAR TIPOMONEDA -->
        <div class="box" id="boxEditMoneda">
            <a class="boxclose" id="boxcloseEditMoneda"></a>
            
           <form class="formulario">
           <h2>Editar Moneda</h2>                               
                <input type="text" placeholder="Modificar Moneda">
                <input type="button" class="boton" value="Ok">
           </form>
        </div>

        <footer>
                <!--<input id="activatorAddSet" type="button" value="Agregar" class="boton">-->

        </footer>

</body>
</html>