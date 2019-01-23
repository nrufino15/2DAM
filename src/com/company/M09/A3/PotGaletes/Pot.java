package com.company.M09.A3.PotGaletes;

public class Pot {
    private boolean lliure, galetas;
    private short numGaletes;

    public void pot(){
        lliure = true;
        galetas = false;
        numGaletes = 0;
    }

    public synchronized void mejarGaleta(){
        while (!lliure || !galetas) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lliure = true;
        numGaletes--;
        if (numGaletes == 0) {galetas = false;}
        lliure = true;
        notifyAll();
    }

    public synchronized void omplir(short i){
        while (!lliure || galetas) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lliure = false;
        numGaletes = i;
        galetas = true;
        lliure = true;
        notifyAll();
    }
}
