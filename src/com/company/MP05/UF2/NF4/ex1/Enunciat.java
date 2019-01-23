package com.company.MP05.UF2.NF4.ex1;
import java.util.Scanner;

/**
 *  La classe MyMath conté un únic mètode que permet calcular expressions matemàtiques, com per exemple les següents:
 *      a + b
 *      a - b * c
 *      (a - b) * c
 *      a / c - (c * (d + e))
 *
 *  Desenvolupa un joc de proves SENZILL que comprovi que les següents expressions funcionen correctament:
 *      a + b
 *      a - b
 *      a * b
 *      a / b
 *
 *    Fes proves amb números d'un sol dígit i de més d'un dígit.
 *    Fes proves amb números decimals (fes servir el punt (.) per a separar la part decimal).
 *    NO facis proves amb números negatius.
 */
public class Enunciat {
    public static  void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, write a mathematical expression:");
        String expression = scanner.nextLine();

        float result = MyMath.resolve(expression);
        System.out.println(result);
    }
}