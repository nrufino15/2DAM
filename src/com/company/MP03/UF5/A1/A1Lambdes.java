package com.company.MP03.UF5.A1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class A1Lambdes {
    public static void main(String[] args) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("d/MM/yyy");
        Persona p1 = new Persona("Arya", Persona.Genere.DONA, LocalDate.parse("25/12/2002",format) );
        Persona p2 = new Persona("Tyrion", Persona.Genere.HOME, LocalDate.parse("12/10/1980",format));
        Persona p3 = new Persona("Cersei", Persona.Genere.DONA, LocalDate.parse("10/01/1984",format));
        Persona p4 = new Persona("Eddard", Persona.Genere.HOME, LocalDate.parse("24/04/1974",format));
        Persona p5 = new Persona("Sansa", Persona.Genere.DONA, LocalDate.parse("24/04/1992",format));
        Persona p6 = new Persona("Jaime", Persona.Genere.HOME, LocalDate.parse("24/04/1979",format));
        Persona p7 = new Persona("Khal", Persona.Genere.HOME, LocalDate.parse("10/08/1979",format));
        Persona p8 = new Persona("Daenerys", Persona.Genere.DONA, LocalDate.parse("12/11/1992",format));

        Persona[] lpers = {p1,p2,p3,p4,p5,p6,p7,p8};
        List<Persona> llista_persones;
        llista_persones = new ArrayList<>(Arrays.asList(lpers));
        Map<Integer,Integer> mapPersones = new HashMap<>();

        // 1 - Canviar a lambda
        System.out.println("\n1");
        Collections.sort(llista_persones, new Comparator<Persona>() {
            @Override
            public int compare(Persona o1, Persona o2) {
                if(o1.getNom().charAt(0) >= o2.getNom().charAt(0)) return 1;
                else return -1;
            }
        });

        /* ---------- Respueta del 1 ---------- */
        System.out.println("\n1");
        llista_persones.sort((o1, o2) -> o2.getNom().compareTo(o1.getNom()));


        // 2 - Canviar a Lambda
        System.out.println("\n2");
        for(Persona p: llista_persones) {
            System.out.println(p);
        }

        /* ---------- Respueta del 2 ---------- */
        System.out.println("\n2");
        System.out.println();
        llista_persones.forEach(persona -> System.out.println(persona));

        // 3 - Canvia a classe anònima
        System.out.println("\n3");
        //ordenació alfabètica inversa del nom
        llista_persones.sort((o1,o2) -> o2.getNom().compareTo(o1.getNom()));

        /* ---------- Respuesta 3 ---------- */
        System.out.println("\n3");
        Collections.sort(llista_persones, new Comparator<Persona>() {
            @Override
            public int compare(Persona o1, Persona o2) {
                if (o1.getNom().charAt(0) >= o2.getNom().charAt(0)) return 1;
                else return -1;
            }
        });

        // 4 - Canvia per una crida al mètode per referència que hagis creat tu
        System.out.println("\n4");
        for(Persona p: llista_persones) {
            System.out.println(p);
        };

        /* ---------- Respuesta 4 ----------*/
        /* Usa el metodo que esta definido al final del codigo: imprimir */
        System.out.println("\n4");
        llista_persones.forEach(A1Lambdes::imprimir);


        // 5 - Omplir map. Canviar per un forEach amb lambda
        System.out.println("\n5");
        for(Persona per : llista_persones) {
            mapPersones.put(per.getAge(),1);
        }

        /* ---------- Respuesta 5 ---------- */
        System.out.println("\n5");
        llista_persones.forEach(persona -> mapPersones.put(persona.getAge(),1));

        // 6 - Canvia per un recorregut forEach amb lambda
        System.out.println("\n6");
        for(Map.Entry entry : mapPersones.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        /* ---------- Respuesta 6 ---------- */
        System.out.println("\n6");
        mapPersones.entrySet().forEach(integerIntegerEntry -> System.out.println(integerIntegerEntry.getKey() + " : " + integerIntegerEntry.getValue()));

        /* 7 -
            Esbrina com s'utilitzen els mètodes de map següents
                map.putIfAbsent
                map.computeIfAbsent
                map.computeIfPresent
             per tal d'afegir correctament la feqrëncia d'edat de les persones.

             Si vols fes-ho primer sense els mètodes anomenats i sense lambdes
             i després amb els mètodes i amb lambdes

             Exemple de sortida:
                34 anys -> 1
                38 anys -> 1
                39 anys -> 2
                26 anys -> 2
                44 anys -> 1
                15 anys -> 1

         */

        // 8 - llistat de persones DONA amb lambda

        // 9 - Llistat dels dos HOMES més joves

        // 10- Esborrar del llistat les persones entre 30 i 40 anys (amb lambda)

    }

    /* ---------- Respuesta 4 ----------*/
    public static void imprimir(Persona p) {
        System.out.println(p);
    }
}
