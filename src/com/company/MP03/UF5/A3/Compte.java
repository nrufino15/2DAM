package com.company.MP03.UF5.A3;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Compte {

    private float saldo;

    public synchronized void ingressar(float diners) {
        float aux;
        aux = saldo;
        aux = aux+diners;
        saldo = aux;
    }

    public synchronized void treure(float diners) {
        float aux;
        aux = saldo;
        aux = aux-diners;
        saldo = aux;
    }

    public static void main(String[] args) throws InterruptedException {

        Compte c = new Compte();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

        Runnable ingres = () -> {
            c.ingressar(100);
            System.out.println("Ingres 100");
        };

        Runnable treure = new Runnable() {
            @Override
            public void run() {
                c.treure(50);
                System.out.println("Trec 50");
            }
        };

        executor.execute(ingres);
        executor.execute(treure);

        executor.awaitTermination(4, TimeUnit.SECONDS);
        executor.shutdownNow();

        System.out.println("Saldo = " + c.saldo);
    }
}
