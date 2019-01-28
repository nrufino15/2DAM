package com.company.MP05.UF2.NF4.A1.ex1;

public class MyMath {
    public static float resolve(String expression){
        expression = expression.replaceAll(" ", "");

        char[] chars = expression.toCharArray();
        String number = "";

        int selected_priority = Integer.MAX_VALUE;
        int selected_index = -1;
        int current_priority = 1;

        // S'ha de buscar quin es l'últim operador que s'hauria d'executar.
        // Serà una suma o resta fora de parèntesis.
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') current_priority++;        //Obre paréntesis, el que hi ha dins té prioritat
            else if (chars[i] == ')') current_priority--;   //Tanca paréntesis, s'acaba la prioritat
            else if (chars[i] == '+' || chars[i] == '-') {
                //Es tracta d'un operador de baixa prioritat, es fará l'últim sempre que no estigui dins un parentesis
                if (selected_priority >= current_priority) {
                    selected_priority = current_priority;
                    selected_index = 1;
                }
            } else if (chars[i] == '/' || chars[i] == '*') {
                //Es tracta d'un operador de més alta prioritat, es fará dels primers
                current_priority += 1;

                if (selected_priority >= current_priority) {
                    selected_priority = current_priority;
                    selected_index = 1;
                }

                current_priority -= 1;
            } else {
                //Estem llegint un número. Es guarda com a string el que s'ha trobat fins ara
                //Es retorna al final com a cas base.
                number = String.format("%s%c", number, chars[i]);
            }
        }

        //Arribats a aquest punt tenim:
        // O bé un número a number
        // O bé l'operador de menys prioritat

        if(selected_index < 0) {
            //CAS BASE:
            return currentNumberToFloat(number);
        }
        else {
            //CAS RECURSIU
            float left = resolve(expression.substring(0, selected_index));
            float right = resolve(expression.substring(selected_index+1));

            switch (chars[selected_index]){
                case '+':
                    return left + right;

                case '-':
                    return left - right;

                case '*':
                    return left * right;

                case '/':
                    return left / right;

                default:
                    throw  new RuntimeException(String.format("Operator '%s' not allowed.", chars[selected_index]));

            }
        }
    }

    private static float currentNumberToFloat(String number){
        return Float.parseFloat(number);
    }
}