/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConexionBD.ConexionBD;
import Interfaces.ICliente;
import Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 *
 * @author vivia
 */
public class ClienteDAO implements ICliente {
 
    private static final Logger LOG=Logger.getGlobal();

    public Cliente getClienteUsuarioCOntrasena(String usuario, String contrasena) {
         Cliente cliente=null;
         String sql="select e.i_num_id_emp,e.c_dni,e.c_nombres,e.c_correo,u.c_user,u.c_perfil "
                 + "from empleado e INNER JOIN usuario u ON e.i_num_id_user=u.i_num_id_user "
                 + "WHERE u.c_user=? AND u.c_password=?";
         try {
             Connection con=ConexionBD.Conectar();
             PreparedStatement ps=con.prepareStatement(sql);
             ps.setString(1, usuario);
             ps.setString(2, contrasena);
             ResultSet rs=ps.executeQuery();
             while (rs.next()) {                 
                 cliente=new Cliente();
                 cliente.setId(rs.getInt("e.i_num_id_emp"));
                 cliente.setDni(rs.getString("e.c_dni"));
                 cliente.setNombre(rs.getString("e.c_nombres"));
                 cliente.setCorreo(rs.getString("e.c_correo"));
                 cliente.setUser(rs.getString("u.c_user"));
                 cliente.setPerfil(rs.getString("u.c_perfil"));
                 
             }
             rs.close();
             ps.close();             
             con.close();             
        } catch (SQLException e) {
            LOG.info("Error getEmpleadoUserPass:".concat(e.toString()));
        }
         return cliente;
    }

    @Override
    public Cliente getClienteUsuarioContrasena(String usuario, String contrasena) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}