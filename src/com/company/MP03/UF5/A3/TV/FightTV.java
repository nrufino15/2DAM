package com.company.MP03.UF5.A3.TV;

/**
 * Created by jordi on 11/01/17.
 */
public class FightTV {
    public static void main(String[] args) {
        Comandament comandament = new Comandament();
        MembreFamilia Joan = new MembreFamilia(comandament,"Joan");
        MembreFamilia Anna = new MembreFamilia(comandament,"Anna");
        MembreFamilia Pere = new MembreFamilia(comandament,"Pere");

        Joan.start();
        Anna.start();
        Pere.start();
    }
}
