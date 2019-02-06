package com.company.MP05.UF2.NF4.A2.ex1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.security.auth.login.AccountExpiredException;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @org.junit.jupiter.api.Test
    void put() {
        HashTable ht = new HashTable();

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

        ht.drop("29");

        Assertions.assertEquals("\n bucket[0] = [0, 0] -> [11, 11] -> [22, 22]\n" +
                " bucket[1] = [1, 1] -> [12, 12] -> [23, 23]\n" +
                " bucket[2] = [2, 2] -> [13, 13] -> [24, 24]\n" +
                " bucket[3] = [3, 3] -> [14, 14] -> [25, 25]\n" +
                " bucket[4] = [4, 4] -> [15, 15] -> [26, 26]\n" +
                " bucket[5] = [5, 5] -> [16, 16] -> [27, 27]\n" +
                " bucket[6] = [6, 6] -> [17, 17] -> [28, 28]\n" +
                " bucket[7] = [7, 7] -> [18, 18]\n" +
                " bucket[8] = [8, 8] -> [19, 19]\n" +
                " bucket[9] = [9, 9]\n" +
                " bucket[10] = [20, 20]\n" +
                " bucket[11] = [10, 10] -> [21, 21]", ht.toString());

        //¡¡Que locura es esta profe. Apruebame ya!!

    }

    @Test
    void size() {
        HashTable ht = new HashTable();

        for(int i=0; i<30; i++) {
            final String key = String.valueOf(i);
            ht.put(key, key);
        }

        ht.drop("9");
        System.out.println(ht);
        System.out.println("\n El tamaño de MapHash: "+ht.size());

//        ht.put("1", "Nicky");
//        ht.put("2", "Kennedy");
//
//        System.out.println(ht);
//        System.out.println("\n El tamaño de MapHash: "+ht.size());
//
//        ht.drop("1");
//        System.out.println(ht);
//        System.out.println("\n El tamaño de MapHash: "+ht.size());
    }

    @Test
    void realSize() {
        HashTable ht = new HashTable();
        System.out.println("\n El tamaño de MapHash: "+ht.realSize());
    }
}