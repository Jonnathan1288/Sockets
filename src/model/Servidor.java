/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Servidor {

    public static void main(String[] args) {
        try {
            int puerto = 6789;
            Socket conexionCliente;
            DataOutputStream salida = null;
            
            ServerSocket socketTCP = new ServerSocket(puerto);
            conexionCliente = socketTCP.accept();
            
            System.out.println("Cliente: "+conexionCliente.getInetAddress().getHostName()+" conectado");
            
            //Data inputstream y datainputstream comunicación entre C-S.
            salida = new DataOutputStream(conexionCliente.getOutputStream());
            salida.writeUTF("Holaaa, tu solicitud fue aceptada..");
            
            //Salida de la infogrmacion
            DataInputStream entrada = null;
            entrada = new DataInputStream(conexionCliente.getInputStream());
            System.out.println(entrada.readUTF());
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
