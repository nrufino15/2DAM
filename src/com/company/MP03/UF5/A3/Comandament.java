package com.company.MP03.UF5.A3;

public class Comandament {
    private boolean lliure;
    private  int canal;

    public Comandament(){
        lliure = true;
    }

    public synchronized void agafar() {
        while (!lliure) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lliure = false;
            notifyAll();
        }
    }

    public synchronized void deixar() {
        lliure = true;
        notifyAll();
    }

    public synchronized void setCanal(int v) {
        canal = v;
    }

    public  synchronized int getCanal(){
        return canal;
    }
}
