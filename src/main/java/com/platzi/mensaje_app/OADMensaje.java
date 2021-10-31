package com.platzi.mensaje_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//objeto de acceso a datos de mensaje
public class OADMensaje {

    public static void crearMensajeBD(Mensaje mensaje) {

        Conexion conexionBD = new Conexion();

        try(Connection connection =  conexionBD.getConexion())  {
            PreparedStatement  ps = null;
            try{
                String query="INSERT INTO mensajes ( mensaje, autor_mensaje) VALUES (?,?)";
                ps = connection.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor_mensaje());
                ps.executeUpdate();
                System.out.println("mensaje creado");

            }catch(SQLException ex){
                System.out.println(ex);
            }
        }catch(SQLException e){
            System.out.println(e);
        }

    }

    public static void leerMensajeBD(){

    }

    public static void borrarMensajeBD(int id_mensaje){

    }

    public static void actualizarMensajeBD(Mensaje mensaje){

    }
}
