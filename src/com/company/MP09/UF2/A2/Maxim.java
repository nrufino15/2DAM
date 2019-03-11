package com.company.MP09.UF2.A2;

import java.util.concurrent.ForkJoinPool;

public class Maxim {

    public static void main(String[] args) {
        short[] data = createArray(100000000);

        short[] data2 = {1,2,40,500};
        // Mira el número de processadors
        int processadors = Runtime.getRuntime().availableProcessors();
        System.out.println("Num de processadors: " + processadors);

         System.out.println("Inici càlcul");
         ForkJoinPool pool = new ForkJoinPool(processadors);
         int inici=0;
         int fi= data.length;

         MaximTask tasca = new MaximTask(data, inici, fi);
         long time = System.currentTimeMillis();

         // crida la tasca i espera que es completin
         int result1 = pool.invoke(tasca);

         // màxim
         int result= tasca.join();

         System.out.println("Temps utilitzat:" +(System.currentTimeMillis()-time));
         System.out.println ("Màxim es " + result);
    }

    private static short [] createArray(int size){
        short[] ret = new short[size];
        for(int i=0; i<size; i++){
            ret[i] = (short) (1000 * Math.random());
            if(i==((short)(size*0.9))){
                ret[i]=1005;
            }
        }
        return ret;
    }
}
