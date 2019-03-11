package com.company.MP09.UF2.A3.TV;

public class Banc {

    public static void main(String[] args) throws InterruptedException {
        Banc2 banc = new Banc2();
        Thread op1 = null;
        Thread op2 = null;
        for(int i= 0; i < 1000; i++) {
            op1 = new Thread(() -> banc.ingres(100));
            op2 = new Thread(() -> banc.treu(50));
            op1.start();
            op2.start();
        }

        Thread.sleep(8000);

        System.out.println("Total saldo: " + banc.getSaldo());
    }
}
