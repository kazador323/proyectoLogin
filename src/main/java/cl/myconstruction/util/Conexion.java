package cl.myconstruction.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    public static Connection getConexion() {
    	Connection con = null;

    	try {
    	    Class.forName("com.mysql.cj.jdbc.Driver");
    	    con = DriverManager.getConnection(
    	        "jdbc:mysql://localhost:3306/myconstruction?useSSL=false&serverTimezone=UTC",
    	        "root",
    	        ""
    	    );

    	    System.out.println("✅ Conexión exitosa");

    	} catch (Exception e) {
    	    System.out.println("❌ Error conexión");
    	    e.printStackTrace();
    	}
		return con;
}
}