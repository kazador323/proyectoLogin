<%@ page session="true" %>

<%
    String usuario = (String) session.getAttribute("usuario");

    if(usuario == null){
        response.sendRedirect("login.jsp");
    }
%>

<h2>Bienvenido <%= usuario %></h2>

<a href="logout.jsp">Cerrar sesión</a>