package com.mycompany.sysdistp001;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

    public static void main(String[] args) throws IOException {
        
        //Host del servidor
        final String HOST = "192.168.1.9"; //ponemos el ip de la maquina que nos conectaremos.
        //Puerto del servidor
        final int PORT = 5000;
        DataInputStream in;
        DataOutputStream out;

        try {
            //Creo el socket para conectarme con el cliente
            Socket sc = new Socket(HOST, PORT);

            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());
            
            //Envio un mensaje al cliente
            out.writeUTF("-Cliente: ¡Hola Servidor, yo soy el cliente!-");
            
            //Recibo el mensaje del servidor
            String mensaje = in.readUTF();
            
            System.out.println(mensaje);
            
            sc.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
