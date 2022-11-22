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
public class Cliente {

    public static void main(String[] args) {
        try {
            int puerto = 6789;
            String host = "localhost";
            DataInputStream entrada = null;
            Socket socketTCP = new Socket(host, puerto);
            entrada = new DataInputStream(socketTCP.getInputStream());
            System.out.println(entrada.readUTF());
            
            DataOutputStream salida = null;
            
            salida = new DataOutputStream(socketTCP.getOutputStream());
            salida.writeUTF("Muchas Gracias");


        } catch (Exception ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
