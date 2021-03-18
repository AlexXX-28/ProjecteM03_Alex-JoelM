package com.company.UF2;


import java.util.Scanner;

public class Interficie {

    Scanner s = new Scanner(System.in);
    public static final String RESET = "\033[0m";
    public static final String VERMELL = "\033[31m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";
    public static final String YELLOW = "\u001B[33m";

    /**
     * Mostra la informació d'un array per pantalla de forma simple
     * @param dades Array d'string amb informació
     */
    public static void mostrarDades(String[] dades){

    }

    /**
     * Mostra per pantalla les diferents opcions que formen el menú
     * que es rep com a paràmetre. La primera posició de l'array menú és el
     * títol del mateix mentre que la resta són les opcions. Aquesta variable
     * ja ve inicialitzada des del codi que en fa la crida.
     * @param menu Conté les diferents opcions que es mostraran per pantalla a
     * l'usuari.
     */
    public static void mostrarMenu(String[] menu){
        for (int i = 0; i < menu.length; i++) {
            System.out.println(menu[i]);
        }
    }

    /**
     * Mostra la informació per pantalla de forma simple
     * @param missatge1 Missatge1 a mostrar per pantalla
     * @param missatge2 Missatge2 a mostrar per pantalla
     */
    public static void mostrarOpcions(String missatge1,String missatge2){
        System.out.println("1) " + missatge1);
        System.out.println("2) " + missatge2);
    }

    public int validateRepeat(){
        int opcio;
        do {
            System.out.println("Vols continuar introduint malalts?");
            mostrarOpcions("Si", "No");
            System.out.print("Opció: ");
            opcio = s.nextInt();
        }while (opcio != 1 && opcio != 2);
        return opcio;
    }
    public static void showTable(int[][] array){
        for (int i = 0; i < array.length ; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void printSentence(String sentence){
        System.out.println(sentence);
    }

    public static String returnErrorVermell(String sentence){
        return (VERMELL + sentence + RESET);
    }
    public static void printErrorVermell(String sentence){
        System.out.println(VERMELL + sentence + RESET);
    }
    public static String printCyan(String sentence){
        return (CYAN + sentence + RESET);
    }
    
}
