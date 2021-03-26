package com.company.UF2;

import java.util.Scanner;

/**
 * La classe Utils serveix per a la validació
 * @author Àlex Sàez
 * @author Joel Maria Montes
 */

public class Utils {

    /**
     * Ens permet validar si l'entrada es un tipus "int" i també si aquest esta dins dels rangs
     * tot i que també podem no tenir en compte els rangs
     * @param sentences Es la variable que ens permet mostrar un missatge
     * @param min Es el rang minim
     * @param max Es el rang maxim
     * @return Retorna el enter que previament s'ha posat si ha pasat la validació
     */
    public static int validateEnterLimits(String sentences,int min,int max) {
        Scanner s = new Scanner(System.in);
        int ret;
        boolean correct;
        do {
            do {
                Interficie.printSentence(sentences);
                correct = s.hasNextInt();
                if (!correct) {
                    s.next();
                    Interficie.printErrorVermell("Error a de ser un valor numeric, torna a intentar...\n");
                }
            } while (!correct);
            ret = s.nextInt();
            if (max < min){
                break;
            } else {
                if ((ret > max || ret < min)) {
                    Interficie.printErrorVermell("Error el valor esta fora del rang("+min+"-"+max+") torna a intentar.\n");
                }
            }

        } while (ret > max || ret < min);
        s.nextLine();
        return ret;
    }

    /**
     * Ens permet validar si es una String, i si aquesta esta dins del rang
     * @param sentences Es la variable que ens permet mostrar un missatge
     * @param rang Ens indica el rang que no ha de passar la String
     * @return Retorna la String que previament s'ha posat si ha passat la validació
     */
    public static String validateStringRange(String sentences, String[] rang){
        Scanner s = new Scanner(System.in);
        String sentenceRange;
        boolean correct;
        boolean correctRang = false;
        do {
            do {
                Interficie.printSentence(sentences);
                correct = s.hasNextInt();
                if (correct) {
                    s.next();
                    Interficie.printErrorVermell("Error a de ser un valor NO numeric, torna a intentar...\n");
                }
            } while (correct);
            sentenceRange = s.next();
            for (int i = 0; i < rang.length ; i++) {
                if (rang[i].equals(sentenceRange)){
                    correctRang = true;
                }
            }
            if (!correctRang){
                Interficie.printErrorVermell("Error fora del rang\n");
            }
        }while (!correctRang);
        return sentenceRange;
    }
}
