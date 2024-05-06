package br.com.danichs.server;

import java.net.Socket;

public class DistribuirTarefas implements Runnable {

    private Socket socket;

    public DistribuirTarefas(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        System.out.println("Distribuindo tarefas para " + socket.getPort());

        try {
            Thread.sleep(20000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
