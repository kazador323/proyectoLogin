package cl.myconstruction.servlet;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import cl.myconstruction.util.Conexion;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        if(user == null || pass == null || user.isEmpty() || pass.isEmpty()){
            response.sendRedirect("login.jsp?error=1");
            return;
        }

        String sql = "SELECT * FROM usuarios WHERE username=? AND password=?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, user);
            ps.setString(2, pass);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    HttpSession session = request.getSession();
                    session.setAttribute("usuario", user);
                    response.sendRedirect("home.jsp");
                } else {
                    response.sendRedirect("login.jsp?error=1");
                }
            }

        } catch (Exception e) {
            response.sendRedirect("login.jsp?error=2");
        }
    }
}