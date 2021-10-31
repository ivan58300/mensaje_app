package com.platzi.mensaje_app;

import java.util.Scanner;

public class ServicioMensaje {

    public static void  crearMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String mensaje = sc.nextLine();

        System.out.println("tu nombre");
        String nombre = sc.nextLine();

        Mensaje registro = new Mensaje();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(nombre);
        OADMensaje.crearMensajeBD(registro);
    }

    public static void listaMensaje(){

    }

    public static void borrarMensaje(){

    }

    public static void editarMensaje(){

    }
}
