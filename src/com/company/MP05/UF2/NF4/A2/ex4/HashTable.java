package com.company.MP05.UF2.NF4.A2.ex4;

// Original source code: https://gist.github.com/amadamala/3cdd53cb5a6b1c1df540981ab0245479
// Modified by Fernando Porrino Serrano for academic purposes.
// Modified by Nicky Kennedy Rufino Correa student of Fernano Porrino Serrano.

import java.util.ArrayList;

public class HashTable {
    private int INITIAL_SIZE = 16;
    private int size = 0;
    private HashEntry[] entries = new HashEntry[INITIAL_SIZE];

    public int size(){
        return this.size;
    }

    public int realSize(){
        return this.INITIAL_SIZE;
    }

    /***
     * This method checks that there is no collision of data in our HashMap, making that if it detects any collision, it re-executes itself until there are no more collisions.
     * @param key Unique identification number to store a data obtained from the HashTableTest class.
     * @param value Value obtained by the HashTableTest class that is linked with the unique key.
     */
    private void colision(String key, Object value){                   // New code added, in which we double the size of the hash so that there are no collisions.
        INITIAL_SIZE=INITIAL_SIZE*2;
        HashEntry[] he = new HashEntry[INITIAL_SIZE];

        for (int i = 0; i <entries.length ; i++) {
            if ( entries[i] != null){
                HashEntry tmp = entries[i];
                int hash = getHash(tmp.key);
                if (he[hash] == null){
                    he[hash] = tmp;
                }else {
                    colision(key, value);
                }
            }
        }
        entries = he;
        put(key, value);
    }

    /***
     * This method insert data in our HashMap with their respective keys and values.
     * @param key Unique identification number to store a data obtained from the HashTableTest class.
     * @param value Value obtained by the HashTableTest class that is linked with the unique key.
     */
    public void put(String key, Object value) {                         // Old code: String key, String value
        int hash = getHash(key);
        final HashEntry hashEntry = new HashEntry(key, value);

        if(entries[hash] == null) {
            entries[hash] = hashEntry;
            size++;                                                     // Add a value to the size method.
        } else {
            HashEntry temp = entries[hash];
            if (temp.key == key){
                temp.value= value;
                entries[hash]=temp;
            }else {
                colision(key, value);
            }
        }

        /*else if (entries[hash].key == hashEntry.key){                   // Added new else if so that in the case of entering a repeated key that updates the value.
            entries[hash].value = hashEntry.value;                      // We say that the old [hash] .value entries are equal to the new ones entered.
            size++;                                                     // Add a value to the size method.
        } else {
            HashEntry temp = entries[hash];
            while(temp.next != null)
                temp = temp.next;

            temp.next = hashEntry;
            hashEntry.prev = temp;
            size++;                                                     // Add a value to the size method.
        }*/
    }

    /***
     * This method allows us to obtain any value of our HashMap having collisions or not.
     * @param key Unique identification number to store a data obtained from the HashTableTest class.
     * @return Returns 'null' if the element is not found.
     */
    public Object get(String key) {
        int hash = getHash(key);
        if(entries[hash] != null) {
            HashEntry temp = entries[hash];

            temp = getHashEntry(key, temp);                             // Line generated by the refactor to use the new method created.

            return temp.value;
        }

        return null;
    }

    /***
     * Method created with the refactor option. This method runs through our HashMap to find the key passed by parameter.
     * @param key Unique identification number to store a data obtained from the HashTableTest class.
     * @param temp Temporal value where the obtained data is stored.
     * @return Returns the value obtained from traversing the HashMap.
     */
    private HashEntry getHashEntry(String key, HashEntry temp) {        // New method created from extracting the method with refactor.
        while (!temp.key.equals(key))
            temp = temp.next;
        return temp;
    }

    /***
     * This method will remove an element of our HashMap with the unique key.
     * @param key Unique identification number to store a data obtained from the HashTableTest class.
     */
    public void drop(String key) {
        int hash = getHash(key);
        if(entries[hash] != null) {

            HashEntry temp = entries[hash];
            temp = getHashEntry(key, temp);

            if(temp.next != null && temp.prev == null){                 // Old code: if(temp.prev == null) entries[hash] = null; The new code what it does is to check if temp.next is different to null and if the temp.prev is null.
                entries[hash] = temp.next;                              // Old code: entries[hash] = null; The new code that allows us to say is that current entries[hash] is equal to the next one, thus eliminating the current one.
                size--;                                                 // Subtract a value from the size method.
            } else if (temp.next == null && temp.prev == null) {        // New code added by the need to delete an element of the Bucket whose value is only equal to one, in this case we will only erase that value from the buket without causing errors.
                entries[hash] = null;                                   // The selected value becomes null.
                size--;                                                 // Subtract a value from the size method.
            } else{
                if(temp.next != null) {
                    temp.next.prev = temp.prev;
                    size--;                                             // Subtract a value from the size method.
                }
                temp.prev.next = temp.next;
                size--;                                                 // Subtract a value from the size method.
            }
        }
    }

    private int getHash(String key) {
        // piggy backing on java string
        // hashcode implementation.
        return key.hashCode() % INITIAL_SIZE;
    }

    private class HashEntry {
        String key;
        Object value;

        // Linked list of same hash entries.
        HashEntry next;
        HashEntry prev;

        public HashEntry(String key, Object value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }

        @Override
        public String toString() {
            return "[" + key + ", " + value + "]";
        }
    }

    @Override
    public String toString() {
        int bucket = 0;
        //bucket++;
        StringBuilder hashTableStr = new StringBuilder();
        for (HashEntry entry : entries) {
            if(entry == null) {
                continue;
            }
            hashTableStr.append("\n bucket[")
                    .append(bucket)
                    .append("] = ")
                    .append(entry.toString());
            bucket++;
            HashEntry temp = entry.next;
            while(temp != null) {
                hashTableStr.append(" -> ");
                hashTableStr.append(temp.toString());
                temp = temp.next;
            }
        }
        return hashTableStr.toString();
    }

    public ArrayList<String> getCollisionsForKey(String key) {
        return getCollisionsForKey(key, 1);
    }

    public ArrayList<String> getCollisionsForKey(String key, int quantity){
        /*
          Main idea:
          alphabet = {0, 1, 2}

          Step 1: "000"
          Step 2: "001"
          Step 3: "002"
          Step 4: "010"
          Step 5: "011"
           ...
          Step N: "222"

          All those keys will be hashed and checking if collides with the given one.
        * */

        final char[] alphabet = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        ArrayList<Integer> newKey = new ArrayList();
        ArrayList<String> foundKeys = new ArrayList();

        newKey.add(0);
        int collision = getHash(key);
        int current = newKey.size() -1;

        while (foundKeys.size() < quantity){
            //building current key
            String currentKey = "";
            for(int i = 0; i < newKey.size(); i++)
                currentKey += alphabet[newKey.get(i)];

            if(!currentKey.equals(key) && getHash(currentKey) == collision)
                foundKeys.add(currentKey);

            //increasing the current alphabet key
            newKey.set(current, newKey.get(current)+1);

            //overflow over the alphabet on current!
            if(newKey.get(current) == alphabet.length){
                int previous = current;
                do{
                    //increasing the previous to current alphabet key
                    previous--;
                    if(previous >= 0)  newKey.set(previous, newKey.get(previous) + 1);
                }
                while (previous >= 0 && newKey.get(previous) == alphabet.length);

                //cleaning
                for(int i = previous + 1; i < newKey.size(); i++)
                    newKey.set(i, 0);

                //increasing size on underflow over the key size
                if(previous < 0) newKey.add(0);

                current = newKey.size() -1;
            }
        }

        return  foundKeys;
    }

    public static void log(String msg) {                                // Modified code: Converted protect to public.
        System.out.println(msg);
    }
}