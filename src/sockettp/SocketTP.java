/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockettp;

import common.Request;
import common.Noticia;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

//Codigos de operacion para server y cliente: 
//1 - Mostrar Titulos
//2 - Mostrar noticia elegida
//3 - Cargar Noticia

/**
 *
 * @author gastonmira
 */
public class SocketTP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        boolean quiereSalir = false;
        iCliente cliente = new ClienteTCP("localhost", 6006);
        while (!quiereSalir) {

            System.out.println("Por favor escriba la opción para realizar una tarea y aprete Enter");
            System.out.println("1. Mostrar todas las noticias");
            System.out.println("2. Agregar noticia");
            System.out.println("3. Salir");

            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            String answer = bufferRead.readLine();

            switch (answer) {
                case "1":
                    try {
                        String titulos = cliente.Handle(new Request(1,null));
                        System.out.print("Titulos:");
                        System.out.print("\n"+titulos.replace("$;", "\n"));
                        
                        System.out.println("Elija una noticia y aprete Enter");
                        String indiceNoticia = bufferRead.readLine();
                        
                        String noticia = cliente.Handle(new Request(2,Integer.parseInt(indiceNoticia)));
                        System.out.println("Cuerpo Noticia:");
                        System.out.println(noticia);
                        
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "2":
                    try {
                        System.out.println("Escriba el titulo por favor y aprete Enter");
                        String titulo = bufferRead.readLine();

                        System.out.println("Escriba el cuerpo por favor y aprete Enter");
                        String cuerpo = bufferRead.readLine();

                        Noticia noti = new Noticia(titulo, cuerpo);

                        String respuesta = cliente.Handle(new Request(3,noti));
                        System.out.println(respuesta);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "3":
                    quiereSalir = true;
                    break;
                default:
                    System.out.println("Elija una opcion valida");
                    break;
            }
        }
    }
}
