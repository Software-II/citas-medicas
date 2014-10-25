<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<script src="Admin/js/nav.js"></script>
        <link rel="stylesheet" type="text/css" href="Admin/css/style.css">
</head>
<body>

<div id="wrapper">
            <div id="content" style="text-align:center;width:950px;">
            	<form name="frm_usuario" method="post" action="<%=request.getContextPath() %>/Administrador">
            	<table cellpadding="0" cellspacing="0" style="width:50%">
            		<tr>
						<td colspan="2"><strong>INICIO DE SESION</strong></td>
	            	</tr>
	            	<tr>
	            		<td>Usuario:</td><td><input name="txt_user" type="text" style="width:150px;" /></td>
	            	</tr>
	            	<tr>
	            		<td>Clave:</td><td><input name="txt_pass" type="password"  style="width:150px;" /></td>
	            	</tr>
					<tr>
						<td colspan="2"><input type="submit" name="btn_login" value="ingresar" /></td>
	            	</tr>
				</table>
				</form>
            </div>
        </div>

<label>Admin 12345</label>



</body>
</html>