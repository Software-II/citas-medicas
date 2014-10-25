
<%@page import="beans.TrabajoBean"%>
<%@page import="beans.PuestoTrabajoBean"%>
<%@page import="beans.CategoriaBean"%>
<%@page import="beans.TipoMonedaBean"%>
<%@page import="java.util.Vector"%>
<%
	if(session.getAttribute("nombreadmin") == null){
		response.sendRedirect("login.jsp");
	}
%>

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
<body>
        <header>
                <img class="logo" src="Admin/img/DOta.jpg" /><h1>Nombre de la empresa</h1> <h2>Administrador </h2><img class="user" src="Admin/img/usuario.jpg">
                
        </header>
        <section class="catego">
                <label>
                        <select><%for(int i=0; i<categorias.size(); i++) {%>
                                <option value="<%=categorias.get(i).getIdCat()%>"><%=categorias.get(i).getNomCat()%></option>
                                <%
								}
								%>
                        </select>
                </label>

                <label>
                        <select><%for(int i=0; i<tipos.size(); i++) {%>
                                <option value="<%=tipos.get(i).getIdTrabajo()%>"><%=tipos.get(i).getTipoTrabajo()%></option>
                                <%
								}
								%>
                        </select>
                </label>
        </section>

        <section class="lista">

                <div class="linea"><div class="titulo1">CATEGORIA</div><div class="desc1">DESCRIPCION</div><div class="opcion1">Opciones</div><hr></div>
				<%for(int i=0; i<puestos.size(); i++) {%>
                <div class="linea"><div class="titulo"><%=puestos.get(i).getCategoria()+" - "%> <%=puestos.get(i).getTrabajo()%></div>
                <div class="desc"><%=puestos.get(i).getDescripcion()%></div>
                <div class="opcion">
                <a class="activatorEdit" href="#mod"><img class="ico" src="Admin/img/editar.png"></a>
                <a href="<%=request.getContextPath() %>/Puestos?key=2&&codigo=<%=puestos.get(i).getIdPuestoTrabajo()%>"><img class="ico"  src="Admin/img/eliminar.png"></a>
                </div><hr></div>
                <%
				}
				%>
        </section>

       

        <!-- The overlay and the box -->
        <div class="overlay" id="overlay" style="display:none;"></div>
        <div class="box" id="boxAdd">
            <a class="boxclose" id="boxcloseAdd"></a>
            
           <form class="formulario" method="post" action="<%=request.getContextPath() %>/Puestos">
           <input type="hidden" value="1" name="key" /> 
                 <label>
                        <select name="catego"><%for(int i=0; i<categorias.size(); i++) {%>
                                <option value="<%=categorias.get(i).getIdCat()%>"><%=categorias.get(i).getNomCat()%></option>
                                <%
								}
								%>
                        </select>
                </label>
                <label>
                        <select name="tipo"><%for(int i=0; i<tipos.size(); i++) {%>
                                <option value="<%=tipos.get(i).getIdTrabajo()%>"><%=tipos.get(i).getTipoTrabajo()%></option>
                                <%
								}
								%>
                        </select>
                </label>

                <textarea placeholder="Descripcion" name="descripcion"></textarea>
               
                <input type="text" placeholder="Salario" name="salario">

                <label>
                        <select name="moneda"><%for(int i=0; i<monedas.size(); i++) {%>
								<option value="<%=monedas.get(i).getIdTipoMoneda()%>"><%=monedas.get(i).getNomMoneda() %> </option>
								<%
								}
								%>
                        </select>
                </label>
            
                <input type="Date" placeholder="Disponibilidad" name="inicio">
                
                <input type="number" min="1" max="30" placeholder="Dias" name="dias">
                
                <input type="hidden" name="estado" value="1">
                
                <input type="submit" class="boton" value="Ok">
                

           </form>
        </div>

        <div class="box" id="boxEdit">
            <a class="boxclose" id="boxcloseEdit"></a>
            
           <form class="formulario">
                 <label>
                        <select><%for(int i=0; i<categorias.size(); i++) {%>
                                <option value="<%=categorias.get(i).getIdCat()%>"><%=categorias.get(i).getNomCat()%></option>
                                <%
								}
								%>
                        </select>
                </label>
                <label>
                        <select><%for(int i=0; i<tipos.size(); i++) {%>
                                <option value="<%=tipos.get(i).getIdTrabajo()%>"><%=tipos.get(i).getTipoTrabajo()%></option>
                                <%
								}
								%>
                        </select>
                </label>

                <textarea placeholder="Descripcion"></textarea>
               
                <input type="text" placeholder="Salario">

                <label>
                        <select><%for(int i=0; i<monedas.size(); i++) {%>
								<option value=<%=monedas.get(i).getIdTipoMoneda()%>><%=monedas.get(i).getNomMoneda() %> </option>
								<%
								}
%>s
                        </select>
                </label>
            
                <input type="Date" placeholder="Disponibilidad">
                
                <input type="number" min="1" max="30" placeholder="Dias ">
                
                <input type="button" class="boton" value="Ok">
                

           </form>
        </div>
        <footer>
                <input id="activatorAdd" type="button" value="Agregar" class="boton">

        </footer>

</body>
</html>