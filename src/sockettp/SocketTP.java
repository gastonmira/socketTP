/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockettp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author gastonmira
 */
public class SocketTP {
    
    String serverName = "localhost";
    int port = 6006;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        boolean quiereSalir = false;
        while (!quiereSalir) {
            SocketTP client = new SocketTP();
            String answer;


                System.out.println("Por favor escriba la opción para realizar una tarea y aprete Enter");
                System.out.println("1. Mostrar todas las noticias");
                System.out.println("2. Agregar noticia");
                System.out.println("3. Salir");
                //String answer = System.console().readLine();


            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            answer = bufferRead.readLine();

            switch (answer) {
                case "1":
                    client.run(answer);
                    break;
                case "2":
                    System.out.println("Escriba la noticia por favor y aprete Enter");                
                    try{
                        BufferedReader bufferRead2 = new BufferedReader(new InputStreamReader(System.in));
                        String news = bufferRead2.readLine();
                        client.run(news);
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "3":
                    quiereSalir = true;
                    break;
                default:
                    System.out.println("Elija la opción 1 ó 2");
                    break;
            }   
        }
                  /*bufferRead = new BufferedReader(new InputStreamReader(System.in));
                  String article = bufferRead.readLine();
                  System.out.println(article);*/
    }
    
    public void run(String servicio) throws Exception {
        try{
           Socket client = new Socket(serverName, port);
           PrintStream PS = new PrintStream(client.getOutputStream());
           PS.println("Hola Servidor desde CLiente! Elijo opcion "+servicio);
           
           InputStreamReader IR = new InputStreamReader(client.getInputStream());
           BufferedReader BR = new BufferedReader(IR);
           
           String message = BR.readLine();
           System.out.println(message);
           client.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
