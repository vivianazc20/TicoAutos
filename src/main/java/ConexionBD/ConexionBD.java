/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author vivia
 */
public class ConexionBD {
    

    //Connection con;
    private static final String URL = "jdbc:mysql://localhost:3306/bd_ticoautos?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "root";

  
    public static Connection Conectar() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de Conexion a Base de Datos : " + e);
        }
        return con;

    }
}
