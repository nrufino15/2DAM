package com.company.MP05.UF2.NF4.A2.ex1;

import org.junit.jupiter.api.Assertions;

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
    }

    @org.junit.jupiter.api.Test
    void drop() {
    }
}