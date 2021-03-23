package com.company.UF2;


public class Interficie {
    public static final String RESET = "\033[0m";
    public static final String VERMELL = "\033[31m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";
    public static final String YELLOW = "\u001B[33m";

    public static void showMenu(int tableActive) {
        String[] menu = {
                " MENÚ taulell -> "+tableActive+"/"+(Taulell.TablesSize)+"\t\t",
                "1. Carregar Taulell   \t",
                "2. Introduir malalts  \t",
                "3. Transmitir Virus   \t",
                "4. Curar malats       \t",
                "5. Desplaçar malalts  \t",
                "6. Mostrar informació \t",
                "7. Configuració       \t",
                "8. Seleccionar taulell\t",
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

    public static void showOptions(String[] missatges) {
        for (int i = 0; i < missatges.length; i++) {
            System.out.println(i + 1 + ") " + missatges[i]);
        }
    }

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
        System.out.println("El percentatge que no ha complit el confinament es :" + table.getTotalNoConf() / 100 * totalSick);
    }

    public static void showOptionMove() {
        System.out.printf("%s\n%s\n%s\n%s\n",
                "Instruccions per a desplaçar: ",
                "| Q (dalt esquerra) |   W (dalt mig)    | E (dalt dreta) |",
                "| A (esquerra mig)  |  (Posicio actual) | D (dreta mig)  |",
                "| Z (baix esquerra) |   X (baix mig)    | C (baix dreta) |");
    }

    public static void printSentence(String sentence) {
        System.out.print(sentence);
    }

    public static void printSentenceBlue(String sentence) {
        System.out.print(BLUE + sentence + RESET);
    }

    public static String returnErrorVermell(String sentence) {
        return (VERMELL + sentence + RESET);
    }

    public static void printErrorVermell(String sentence) {
        System.out.print(VERMELL + sentence + RESET);
    }

    public static String returnSentenceCyan(String sentence) {
        return (CYAN + sentence + RESET);
    }

    public static void printSentenceCyan(String sentence) {
        System.out.print(CYAN + sentence + RESET);
    }
    
}
