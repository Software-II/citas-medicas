<%@page import="java.util.Date"%>
<%@page import="beans.BeanPaciente"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% BeanPaciente objPaciente=(BeanPaciente)session.getAttribute("paciente"); %>

<!--
Generar Citas Medicas V.3
-->
<!DOCTYPE html>
<html>
<head>
    <% if(objPaciente==null){ %>
    	<script>
		alert('Inicie Sesion por favor!');
		document.location.href = '${pageContext.request.contextPath}/index.jsp';
	</script>
		
    <%} %>
    <%  %>
    <%String nombre =(String)request.getParameter("nombrePac"); %>
	<%int nro=Integer.parseInt(request.getParameter("nroHM")); %>
	<%double saldo=Double.parseDouble(request.getParameter("saldo")); %>
	<title>gui</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/fonts.css">
<!-- 	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script> -->
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/GenerarCM.js"></script>
</head>
<body>

	<section>
		<div class="cen"></div>
		<div class="min"></div>
		<!--<p class="bienvenido">Centro de Salud San Sebastian</p>-->
		<p class="indicacion">Centro de Salud San Sebastian</p>
		<div class="contenedor">
			<div class="row">
			<div>     </div><div class="item1">Bienvenido(a) Sr(a) <strong><%=nombre %></strong></div>
				<div class="item1">Nro Historria M&eacute;dica: <strong>000<%=nro %></strong></div>
				
				<div class="item2">Saldo: <strong><%=saldo %></strong></div>
			</div>
			<div class="row">
<%
			 Date d = new Date(); %>
				<div class="item1">Fecha: <strong id="fecha-cita"><%=(d.getDay()+9) %>-<%=(d.getMonth()+1) %>-<%=(d.getYear()+1900) %></strong></div>
				<div class="item2">Hora: <strong id="hora-cita"><%=d.getHours() %>:<%=d.getMinutes() %></strong></div>
			</div>
			<div class="row">
				
				<div class="item2"><div onclick="salir(1,<%=objPaciente.getDni() %>)" class="botonMenu">Salir</div></div>
				<!--<div class="item3"><div onclick="openBuscarMedico()" class="botonMenu">Buscar M&eacute;dico</div></div>-->
			</div>
		</div>
	</section>

	

	
</body>
</html>