package com.platzi.mensaje_app;

import java.util.Scanner;

public class Inicio {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion;

        do{
            System.out.println("__________________________");
            System.out.println(" Aplicacion de mensajes");
            System.out.println(" 1.- Crear mensaje");
            System.out.println(" 2.- Listar  mensajes");
            System.out.println(" 3.- Editar mensaje");
            System.out.println(" 4.- Eliminar mensaje");
            System.out.println(" 5.- Salir");
            //leer la opcion del usuario
            opcion  = sc.nextInt();

            switch (opcion){
                case 1:
                    ServicioMensaje.crearMensaje();
                    break;
                case 2:
                    ServicioMensaje.listaMensaje();
                    break;
                case 3:
                    ServicioMensaje.editarMensaje();
                    break;
                case 4:
                    ServicioMensaje.borrarMensaje();
                    break;
                default:
                    break;
            }

        }while (opcion != 5);


    }
}
