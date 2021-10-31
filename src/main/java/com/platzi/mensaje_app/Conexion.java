package com.platzi.mensaje_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public Connection getConexion(){
        Connection conexion = null;
        try{
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app","root","");
        }catch (SQLException e){
            System.out.println(e);
        }
        return conexion;
    }
}

