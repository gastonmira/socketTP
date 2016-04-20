/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockettp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author gastonmira
 */
public class SocketTP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //String serverName = args[0];
        //int port = Integer.parseInt(args[1]);
        System.out.println("Por favor escriba la opción para realizar una tarea y aprete Enter");
        System.out.println("1. Mostrar todas las noticias");
        System.out.println("2. Agregar noticia");
        //String answer = System.console().readLine();
        try{
	    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
	    String answer = bufferRead.readLine();
            if(answer.equals("1")) {
              //llamar al servidor
              
            } else if (answer.equals("2")) {
              //llamar al servidor
              System.out.println("Escriba la noticia por favor y aprete Enter");
              bufferRead = new BufferedReader(new InputStreamReader(System.in));
              String article = bufferRead.readLine();
              System.out.println(article);
            }
	}
	catch(IOException e)
	{
            e.printStackTrace();
	}
    }
    
}
