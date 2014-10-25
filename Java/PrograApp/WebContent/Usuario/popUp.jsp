<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
¿Desea desbloquear su cuenta?

<form action="<%=request.getContextPath() %>/Usuario">
<a href="<%=request.getContextPath() %>/Usuario?funcion=desbloquear&usu=<%=session.getAttribute("idausu") %>">Desbloquea   </a>
<a href="<%=request.getContextPath() %>/Usuario?funcion=cancelar">cancelar </a>
</form>
</body>
</html>