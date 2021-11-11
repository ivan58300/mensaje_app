package com.platzi.mensaje_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

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
        Conexion db_connect = new Conexion();

        PreparedStatement ps = null;
        ResultSet rs = null;

        try(Connection conexion = db_connect.getConexion())  {
            String query="SELECT * FROM mensajes";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();

            //mostrar los datos del mensaje
            while(rs.next()){
                System.out.println("ID: "+rs.getInt("id_mensaje"));
                System.out.println("Mensaje: "+rs.getString("mensaje"));
                System.out.println("Autor: "+rs.getString("autor_mensaje"));
                System.out.println("Fecha: "+rs.getString("fecha_mensaje"));
                System.out.println("");
            }
        }catch(SQLException e){
            System.out.println("no se pudieron recuperar los mensajes");
            System.out.println(e);
        }

    }

    public static void borrarMensajeBD(int id_mensaje){
        Conexion db_connect = new Conexion();
        //El try catch es para validar si tenemos una conexión exitosa
        try(Connection conexion = db_connect.getConexion())  {
            //preparar la sentencia
            PreparedStatement ps =null;
            //consultar base de datos
            try {
                String query="DELETE FROM mensajes WHERE id_mensaje = ?";
                ps=conexion.prepareStatement(query);
                ps.setInt(1, id_mensaje);
                //operacion de transacción que borra un dato de la base de datos
                ps.executeUpdate();
                System.out.println("el mensaje ha sido borrado");
            }catch(SQLException e) {
                //mostrar la exepcion
                System.out.println(e);
                System.out.println("no se pudo borrar el mensaje");
            }


        }catch(SQLException e){
            System.out.println(e);
        }

    }

    public static void actualizarMensajeBD(Mensaje mensaje){
        Conexion db_connect = new Conexion();

        try(Connection conexion = db_connect.getConexion())  {
            PreparedStatement ps = null;

            try{
                //actualizar base de datos
                String query="UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?";
                ps=conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setInt(2, mensaje.getId_mensaje());
                //se ejecuta el comando en el base de datos
                ps.executeUpdate();
                System.out.println("mensaje se actualizó correctamente");
            }catch(SQLException ex){
                System.out.println(ex);
                System.out.println("no se pudo actualizar el mensaje");
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
