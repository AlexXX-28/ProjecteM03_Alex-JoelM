package com.company.UF2;

/**
 * La classe Interficie serveix per a mostrar informació per pantalla/consola
 * @author Alex Saez
 * @author Joel Maria Montes
 */
public class Interficie {
    /**
     * Les constants que ens permeten tenir un nom identificatiu als diferents colors
     */
    public static final String RESET = "\033[0m";
    public static final String VERMELL = "\033[31m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";

    /**
     * Ens permet mostrar el menú amb les diferents opcions
     * @param tableActive Serveix per a identificar quin es el taulell seleccionat
     */
    public static void showMenu(int tableActive) {
        String[] menu = {
                " MENÚ taulell -> "+tableActive+"/"+(Taulell.TablesSize)+"\t\t",
                "1. Carregar Taulell   \t",
                "2. Introduir malalts  \t",
                "3. Transmitir Virus   \t",
                "4. Curar malats       \t",
                "5. Desplaçar malalts  \t",
                "6. Mostrar informació \t",
                "7. Seleccionar taulell\t",
                "8. Buidar taulell     \t",
                "0. Sortir             \t"
        };
        printSentenceBlue("*****************************\n");
        for (int i = 0; i < menu.length; i++) {
            printSentenceBlue("* ");
            System.out.print(menu[i]);
            printSentenceBlue("*\n");
        }
        printSentenceBlue("*****************************\n");
    }

    /**
     * Ens permet mostrar les diferents opcions que es poden seleccionar
     * @param missatges Es el missatge que s'ha de dir alhora de mostrar les opcions
     */
    public static void showOptions(String[] missatges) {
        for (int i = 0; i < missatges.length; i++) {
            System.out.println(i + 1 + ") " + missatges[i]);
        }
    }

    /**
     * Ens permet mostar l'estat actual del taulell amb l'informació extra
     * @param table Es la classe Taulell que ens permet tenir l'informació de la taula seleccionada
     */
    public static void showTable(Taulell table) {
        int totalSick = 0;
        for (int i = 0; i < table.getRow(); i++) {
            for (int j = 0; j < table.getColumn(); j++) {
                if (table.getCell(i,j) < 0){
                    System.out.printf("%s",returnErrorVermell("X\t"));
                } else {
                    totalSick += table.getCell(i,j);
                    System.out.printf("%s", table.getCell(i,j) + "\t");
                }

            }
            System.out.println();
        }
        System.out.println("El total de malalts es : " + totalSick);
        System.out.println("El total de persones curades es : " + table.getTotalHeal());
        System.out.println("El percentatge que no ha complit el confinament es : " + table.getTotalNoConf() / 100 * totalSick);
    }

    /**
     * Ens permet mostrar l'esquema visual per a les diferents opcions del "Desplaçar Malalts"
     */
    public static void showOptionMove() {
        System.out.printf("%s\n%s\n%s\n%s\n",
                "Instruccions per a desplaçar: ",
                "| Q (dalt esquerra) |   W (dalt mig)    | E (dalt dreta) |",
                "| A (esquerra mig)  |  (Posicio actual) | D (dreta mig)  |",
                "| Z (baix esquerra) |   X (baix mig)    | C (baix dreta) |");
    }

    /**
     * Ens permet mostrar una frase
     * @param sentence Es la variable de la frase que volem mostrar
     */
    public static void printSentence(String sentence) {
        System.out.print(sentence);
    }

    /**
     * Ens permet mostrar una frase amb el color "BLAU"
     * @param sentence Es la variable de la frase que volem mostrar
     */
    public static void printSentenceBlue(String sentence) {
        System.out.print(BLUE + sentence + RESET);
    }

    /**
     * Ens permet retornar una String d'un missatge d'errorn en "VERMELL"
     * @param sentence Es la variable de la frase que volem mostrar
     * @return Retorna la variable "sentence" de "VERMELL"
     */
    public static String returnErrorVermell(String sentence) {
        return (VERMELL + sentence + RESET);
    }

    /**
     * Ens permet mostrar un error amb color "VERMELL"
     * @param sentence Es la variable de la frase que volem mostrar
     */
    public static void printErrorVermell(String sentence) {
        System.out.print(VERMELL + sentence + RESET);
    }

    /**
     * Ens permet retornar una String de color "CYAN"
     * @param sentence Es la variable de la frase que volem mostrar
     * @return Retorna la variable "sentence" de color "CYAN"
     */
    public static String returnSentenceCyan(String sentence) {
        return (CYAN + sentence + RESET);
    }

    /**
     * Ens permet mostrar una frase de color "CYAN"
     * @param sentence Es la variable de la frase que volem mostrar
     */
    public static void printSentenceCyan(String sentence) {
        System.out.print(CYAN + sentence + RESET);
    }
    
}
