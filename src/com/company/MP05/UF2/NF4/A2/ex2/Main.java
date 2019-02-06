package com.company.MP05.UF2.NF4.A2.ex2;

public class Main {
    public static void main(String[] args) {          // Main class extracted from the HashTable class with the option to extract class with refactor.
        HashTable hashTable = new HashTable();

        // Put some key values.
        for (int i = 0; i < 30; i++) {
            final String key = String.valueOf(i);
            hashTable.put(key, key);
        }

        // Print the HashTable structure
        HashTable.log("****   HashTable  ***");
        HashTable.log(hashTable.toString());
        HashTable.log("\nValue for key(20) : " + hashTable.get("20"));
    }
}