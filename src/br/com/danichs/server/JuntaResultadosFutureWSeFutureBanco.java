package br.com.danichs.server;

import java.io.PrintStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class JuntaResultadosFutureWSeFutureBanco implements Callable<Void>{

    private Future<String> futureWs;
    private Future<String> futureBanco;
    private PrintStream saidaCliente;

    public JuntaResultadosFutureWSeFutureBanco(Future<String> futureWs, Future<String> futureBanco, PrintStream saidaCliente) {

        this.futureWs = futureWs;
        this.futureBanco = futureBanco;
        this.saidaCliente = saidaCliente;

    }

    @Override
    public Void call() throws Exception{

        System.out.println("Aguardando resultados do future WS e Banco");

        try {
            String numeroMagico = this.futureWs.get(15, TimeUnit.SECONDS);
            String numeroMagico2 = this.futureBanco.get(15, TimeUnit.SECONDS);

            this.saidaCliente.println("Resultado comando c2 : " + numeroMagico + "," + numeroMagico2);

        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            System.out.println("Timeout: Cancelando execucao do comando c2");
            this.saidaCliente.println("Timeout na execucao do comando C2");
            this.futureWs.cancel(true);
            this.futureBanco.cancel(true);
        }

        System.out.println("Finalizou JuntaResultadosFutureWsEFutureBanco");
        return null;
    }
}
