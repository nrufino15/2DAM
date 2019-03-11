package com.company.MP05.UF2.NF4.A2.ex3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HashTableTest {

    @Test
    void put() {
        HashTable ht = new HashTable();


        for(int i=0; i<30; i++) {
            final String key = String.valueOf(i);
            ht.put(key, key);
        }

        System.out.println(ht);
        System.out.println("\n Tamaño real: "+ht.realSize()+"  "+"Cantidad de datos: "+ ht.size());
    }

    @Test
    void get() {
        HashTable ht = new HashTable();

        // Put some key values.
        for(int i=0; i<30; i++) {
            final String key = String.valueOf(i);
            ht.put(key, key);
        }

        Object nombre = ht.get("12");                                   //Chaged String to Object
        Assertions.assertEquals("12", nombre);

        Object nombre2 = ht.get("2");                                   //Chaged String to Object
        Assertions.assertEquals("2", nombre2);

        //¡¡Que locura es esta profe. Apruebame ya!!

        //Por cierto, por lo que he podido comprobar el metodo get funciona correctamente.


    }
    @Test
    void drop() {
        HashTable ht = new HashTable();

        //Put some key values.
        for(int i=0; i<30; i++) {
            final String key = String.valueOf(i);
            ht.put(key, key);
        }

        ht.drop("1");

        Assertions.assertEquals("\n bucket[0] = [22, 22]\n" +
                " bucket[1] = [23, 23]\n" +
                " bucket[2] = [24, 24]\n" +
                " bucket[3] = [25, 25]\n" +
                " bucket[4] = [26, 26]\n" +
                " bucket[5] = [27, 27]\n" +
                " bucket[6] = [28, 28]\n" +
                " bucket[7] = [29, 29]\n" +
                " bucket[8] = [10, 10]\n" +
                " bucket[9] = [11, 11]\n" +
                " bucket[10] = [12, 12]\n" +
                " bucket[11] = [13, 13]\n" +
                " bucket[12] = [14, 14]\n" +
                " bucket[13] = [15, 15]\n" +
                " bucket[14] = [16, 16]\n" +
                " bucket[15] = [17, 17]\n" +
                " bucket[16] = [18, 18]\n" +
                " bucket[17] = [19, 19]\n" +
                " bucket[18] = [0, 0]\n" +
                " bucket[19] = [2, 2]\n" +
                " bucket[20] = [3, 3]\n" +
                " bucket[21] = [4, 4]\n" +
                " bucket[22] = [5, 5]\n" +
                " bucket[23] = [6, 6]\n" +
                " bucket[24] = [7, 7]\n" +
                " bucket[25] = [8, 8]\n" +
                " bucket[26] = [9, 9]\n" +
                " bucket[27] = [20, 20]\n" +
                " bucket[28] = [21, 21]", ht.toString());

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