package com.company.MP09.UF1.A3.PotGaletes;

public class Pare extends Thread {
    Pot pot;
    public Pare(String nom, Pot pot){
        super(nom);
        this.pot = pot;
    }

    @Override
    public void run(){
        pot.omplir((short) 10);
        System.out.println(getName() + " he omplet el pot amd 10 galetas");
    }
}
