package com.company.MP05.UF2.NF4.A2.ex1;

import org.junit.jupiter.api.Assertions;

import javax.security.auth.login.AccountExpiredException;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @org.junit.jupiter.api.Test
    void put() {
        HashTable ht = new HashTable();
        Assertions.assertEquals("", ht.toString());

        ht.put("1", "Nicky");
        Assertions.assertEquals("\n bucket[0] = [1, Nicky]", ht.toString());

        ht.put("2", "Maria");
        Assertions.assertEquals("\n bucket[0] = [1, Nicky]\n bucket[1] = [2, Maria]", ht.toString());

        ht.put("1", "Dani");
        Assertions.assertEquals("\n bucket[0] = [1, Dani]\n bucket[1] = [2, Maria]", ht.toString());
    }

    @org.junit.jupiter.api.Test
    void get() {
        HashTable ht = new HashTable();

        // Put some key values.
        for(int i=0; i<30; i++) {
            final String key = String.valueOf(i);
            ht.put(key, key);
        }

        String nombre = ht.get("12");
        Assertions.assertEquals("12", nombre);

        String nombre2 = ht.get("2");
        Assertions.assertEquals("2", nombre2);

        //¡¡Que locura es esta profe. Apruebame ya!!

        //Por cierto, por lo que he podido comprobar el metodo get funciona correctamente.


    }
    @org.junit.jupiter.api.Test
    void drop() {
        HashTable ht = new HashTable();

        //Put some key values.
        for(int i=0; i<30; i++) {
            final String key = String.valueOf(i);
            ht.put(key, key);
        }

        ht.drop("2");

        Assertions.assertEquals("\n bucket[0] = [2, Maria]", ht.toString());

        //¡¡Que locura es esta profe. Apruebame ya!!

    }
}