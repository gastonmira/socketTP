/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockettp;

/**
 *
 * @author juan.dapice
 */
public interface iCliente {
 
    String MostrarTitulos() throws Exception;
    String MostrarNoticia(String indiceNoticia) throws Exception;
    String CargarNoticia(Noticia noti) throws Exception;
}
