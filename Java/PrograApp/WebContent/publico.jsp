<!DOCTYPE html>
<html lang="es">
<head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width = device-width, initial-scale=1, maximum-scale=1">
        <title>GDAYX</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script src="Admin/js/nav.js"></script>
        <link rel="stylesheet" type="text/css" href="Admin/css/style.css">
</head>

<body>
        <header>
                <img class="logo" src="Admin/img/DOta.jpg" /><h1>Nombre de la empresa</h1> 
                <form class="formulario" method="post" action="<%=request.getContextPath() %>/Usuarios">
                <input type="hidden" name="key" value="2">
                <input style="width: 150px; height: inherit; position: absolute; top: 25px; left: 50%;" type="text" name="correo" placeholder="correo">
                <input style="width: 150px; height: inherit; position: absolute; top: 25px; left: 62%;"type="password" name="contra" placeholder="contraseña">
                <input style="width: 150px; height: inherit; position: absolute; top: 20px; left: 74%;" type="submit" value="ingresar" class="boton">
                <a href="<%=request.getContextPath() %>/Admin/login.jsp">Administrador</a>
                </form>
                
                
        </header>

                <section class="informacion">
                        <img src="Admin/img/DOta.jpg" width="90%" style="position: relative;
top: 72px; width=90%; ">
                </section>
                <section class="registro">

                        <form class="formulario" method="post" action="<%=request.getContextPath() %>/Usuarios">
                               <input type="hidden" name="key" value="1">
                                <input name="nombre" type="text" placeholder="Nombre" required>
                                <input name="apellido" type="text" placeholder="Apellido" required>
                                <input name="correo" type="email" placeholder="correo" required>
                                <input name="telefono" type="text" placeholder="telefono" required>
                                <input name="fechnac" type="date" required>
                                <input name="contra" type="password" placeholder="contraseña" required>
                                <input name="contra2" type="password" placeholder="confirmar contraseña" required><br>
                                <input type="submit" class="boton" value="Registrarse">

                        </form>

                </section>



        <footer>
                <!--<input id="activatorAddSet" type="button" value="Agregar" class="boton">-->

        </footer>

</body>
</html>