package com.company.MP09.UF2.A3.PotGaletes;

public class Fill extends Thread {
    Pot pot;
    public Fill(String nom, Pot pot) {
        super(nom);
        this.pot = pot;
    }

    @Override
    public void run(){
        pot.mejarGaleta();
        System.out.println();
    }
}
