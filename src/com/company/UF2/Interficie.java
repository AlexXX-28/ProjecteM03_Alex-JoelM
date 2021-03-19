package com.company.UF2;


import java.util.Scanner;

public class Interficie {

    Scanner s = new Scanner(System.in);
    public static final String RESET = "\033[0m";
    public static final String VERMELL = "\033[31m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";
    public static final String YELLOW = "\u001B[33m";


    public static void mostrarMenu(String[] menu){
        printSentenceBlue("*************************\n");
        for (int i = 0; i < menu.length; i++) {
            printSentenceBlue("* ");
            System.out.print(menu[i]);
            printSentenceBlue("*\n");
        }
        printSentenceBlue("*************************\n");
    }

    public static void mostrarOpcions(String missatge1,String missatge2){
        System.out.println("1) " + missatge1);
        System.out.println("2) " + missatge2);
    }

    public int validateRepeat(String sentence){
        int opcio;
        do {
            System.out.println(sentence);
            mostrarOpcions("Si", "No");
            System.out.print("Opció: ");
            opcio = s.nextInt();
        }while (opcio != 1 && opcio != 2);
        return opcio;
    }
    public static void showTable(int[][] array){
        for (int i = 0; i < array.length ; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("%-5s" ,array[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void printSentence(String sentence){
        System.out.print(sentence);
    }
    public static void printSentenceBlue(String sentence){
        System.out.print(BLUE + sentence + RESET);
    }
    public static String returnErrorVermell(String sentence){
        return (VERMELL + sentence + RESET);
    }
    public static void printErrorVermell(String sentence){
        System.out.print(VERMELL + sentence + RESET);
    }
    public static String returnSentenceCyan(String sentence){
        return (CYAN + sentence + RESET); }
    public static void printSentenceCyan(String sentence){
        System.out.print(CYAN + sentence + RESET);
    }
}
