package com.company.MP03.UF5.A3;

public class Casa {
    public static void main(String[] args) {
        Comandament c = new Comandament();
        MembreFamilia m1 = new MembreFamilia("Dani",c);
        MembreFamilia m2 = new MembreFamilia("Javi",c);
        MembreFamilia m3 = new MembreFamilia("Nicky",c);
        MembreFamilia m4 = new MembreFamilia("Hambrosio",c);

        m1.start();
        m2.start();
        m3.start();
        m4.start();
    }
}
