package br.com.danichs.cliente;

import java.net.Socket;

public class ClienteTarefas {

    public static void main(String[] args) throws Exception {
        
        Socket socket = new Socket("localhost", 12345);

        System.out.println("conexão estabelecida");

        socket.close();
    }
}
