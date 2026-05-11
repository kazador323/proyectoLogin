<!DOCTYPE html>
<html>
<head>
    <title>Login - My Construction</title>
</head>
<body>

<h2>Login My Construction</h2>

<form action="login" method="post">
    <label>Usuario:</label><br>
    <input type="text" name="username" required><br><br>

    <label>Contraseña:</label><br>
    <input type="password" name="password" required><br><br>

    <input type="submit" value="Ingresar">
</form>

<%
    if(request.getParameter("error") != null){
%>
    <p style="color:red;">Usuario o contraseña incorrectos</p>
<%
    }
%>

</body>
</html>