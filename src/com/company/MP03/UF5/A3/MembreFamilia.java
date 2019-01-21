package com.company.MP03.UF5.A3;

public class MembreFamilia extends Thread {

    private Comandament comandament;

    public MembreFamilia(String nom, Comandament c) {
        super(nom);
        comandament = c;
    }

    @Override
    public void run() {
        for (;;) {
            comandament.agafar();
            comandament.setCanal((int)(Math.random()*100));
            //Mirar tele
            System.out.println(getName() + " Mirando la tele canal: " + comandament.getCanal());
            try {
                Thread.sleep((long) (Math.random() * 5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            comandament.deixar();
            //Descansar
            try {
                Thread.sleep((long) (Math.random() * 10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
