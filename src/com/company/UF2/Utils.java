package com.company.UF2;

import java.util.Scanner;

public class Utils {

    public static int validateEnterLimits(String sentences,int min,int max) {
        Scanner s = new Scanner(System.in);
        int ret;
        boolean correct;
        do {
            do {
                System.out.print(sentences);
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
    public static String validateStringRange(String sentences, String[] rang){
        Scanner s = new Scanner(System.in);
        String sentenceRange;
        boolean correct;
        boolean correctRang = false;
        do {
            do {
                System.out.print(sentences);
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
