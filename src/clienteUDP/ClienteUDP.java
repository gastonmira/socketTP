/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteUDP;

import common.Request;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import sockettp.iCliente;

/**
 *
 * @author gastonmira
 */
public class ClienteUDP implements iCliente {
    
    public int port;
    
    public ClienteUDP(int port) {
        this.port = port;
    }
    
    @Override
    public String Handle(Request req) throws Exception {
        String response = "";
        try{
            DatagramSocket clientUDP = new DatagramSocket();
            ByteArrayOutputStream outPutStream = new ByteArrayOutputStream();
            InetAddress IPAddress = InetAddress.getByName("localhost");
            ObjectOutputStream os = new ObjectOutputStream(outPutStream);
            os.writeObject(req);
            byte[] data = outPutStream.toByteArray();
            DatagramPacket sendPacket = new DatagramPacket(data,data.length,IPAddress,port);
            clientUDP.send(sendPacket);
            
            byte[] incomingData = new byte[1024];
            DatagramPacket incomingPacket = new DatagramPacket(incomingData, incomingData.length);
            clientUDP.receive(incomingPacket);
            response = String.valueOf(incomingPacket.getData());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return response; 
    }
    
}
