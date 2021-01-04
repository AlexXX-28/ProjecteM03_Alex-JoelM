package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] table = new int[0][0];
        String[][] tableShow = new String[0][0];
        int[] arrayColumn = new int[0];
        int[] arrayRow = new int[0];
        int row = 0;
        int column = 0;
        int cellBlocked = 0;
        int totalSick = 0;
        int totalHeal = 0;
        int totalHealCompare = 0;
        int totalLockdown = 0;
        boolean tableCreate = false;
        Scanner s = new Scanner(System.in);
        String numOption = "0";
        while (!numOption.equals("7")) { //El while acabara quan al escollir l'opció 7 (Sortir)
            System.out.printf("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s", //Menu Inicial amb les diferents opcions
                    "\033[34m*************************",
                    "* \033[30m1) Carrega taulell    \033[34m*",
                    "* \033[30m2) Introduir malalts  \033[34m*",
                    "* \033[30m3) Transmitir Virus   \033[34m*",
                    "* \033[30m4) Curar malats       \033[34m*",
                    "* \033[30m5) Desplaçar malalts  \033[34m*",
                    "* \033[30m6) Mostrar informació \033[34m*",
                    "* \033[30m7) Sortir             \033[34m*",
                    "*************************\033[30m",
                    "Introduiex un numero del 1 al 7 per seleccionar l'opció: ");
            numOption = s.next();
            if (numOption.length() != 1) {
                System.out.println("\033[31mError al introduir el valor " + numOption + " desitjat, torna a intentar...\033[30m"); // Els diferents errors que puguin sortir es mostraran amb color vermell
            } else {
                switch (numOption) {
                    case "1" -> { //Creació del taulell
                        System.out.printf("%s\n%s\n", //Diferents opcions del case 1
                                "1) Taulell buit",
                                "2) Taulell amb malalts");
                        int optionCaseOne = s.nextInt(); //La variable optionCaseOne serveix per identificar quina opció s'ha escollit
                        System.out.print("Introduiex la quantitat de files: ");
                        row = s.nextInt();
                        System.out.print("Introduiex la quantitat de columnes: ");
                        column = s.nextInt();
                        table = new int[row][column];
                        tableShow = new String[row][column];
                        if (optionCaseOne == 1) { //Si la variable optionCaseOne es = 1 s'haura escollit "Taullel buit" si no, amb l'else indiquem que s'haura escollit l'opció "Taullel amb Malalts"
                            for (int i = 0; i < row; i++) {
                                for (int j = 0; j < column; j++) {
                                    table[i][j] = 0;
                                }
                            }
                        } else {
                            for (int i = 0; i < row; i++) {
                                for (int j = 0; j < column; j++) {
                                    table[i][j] = (int) (Math.random() * 11);
                                }
                            }
                        }
                        cellBlocked = column * row / 4; // Em declarat que la quantitat de cel·les bloquejades sigui el total de cel·les de la taula / 4 (Per a que no hi hagi ni poques ni masses)
                        arrayColumn = new int[cellBlocked]; // Aquest nou array es refereix a la posició de la columna de l'array real, on hi ha una cel·la bloquejada
                        arrayRow = new int[cellBlocked]; // Aquest nou array es refereix a la posició de la fila de l'array real, on hi ha una cel·la bloquejada
                        for (int i = 0; i < cellBlocked; i++) {
                            arrayColumn[i] = (int) (Math.random() * column); //Aqui es genera un numero aleatori que com a màxim sigui el numero de columnes que hi ha per a posar una X aleatoriament en la taula
                            arrayRow[i] = (int) (Math.random() * row); //El mateix que a dalt pero per a les files
                            table[arrayColumn[i]][arrayRow[i]] = 0; // El valor de les cel·les bloquejades ha de ser 0
                        }
                        tableCreate = true;
                    }
                    case "2" -> { //Afegir Malalts
                        if (tableCreate) { //Per als case del 2-6 hi ha un validador que ens permet donar missatge d'error si no s'ha creat cap taula
                            int optionCaseTwo = 1;
                            while (optionCaseTwo != 2) {
                                System.out.print("Introduiex la fila: ");
                                int insertRow = s.nextInt();
                                System.out.print("Introduiex la columna: ");
                                int insertColumn = s.nextInt();
                                System.out.print("Introdueix el valor per a la columna " + insertColumn + " de la fila " + insertRow + ": ");
                                table[insertRow - 1][insertColumn - 1] = s.nextInt();
                                System.out.printf("%s\n%s\n%s\n",
                                        "Vols continuar introduint malalts? ", //Això ens permet no sortir del case 2 i poder continuar afegint malalts
                                        "1) Si",
                                        "2) No");
                                optionCaseTwo = s.nextInt();
                            }
                        } else {
                            System.out.println("\033[31mEl taulell no s'ha creat\033[30m");
                        }
                    }
                    case "3" -> { //Transmissió del virus
                        if (tableCreate) {
                            System.out.print("Introdueix la taxa de transmissió del virus: ");
                            double rt = s.nextDouble();
                            for (int i = 0; i < row; i++) {
                                for (int j = 0; j < column; j++) {
                                    table[i][j] += Math.floor(table[i][j] * rt);
                                }
                            }
                        } else {
                            System.out.println("\033[31mEl taulell no s'ha creat\033[30m");
                        }
                    }
                    case "4" -> {
                        totalHealCompare = 0;
                        totalSick = 0;
                        if (tableCreate) {
                            System.out.printf("%s\n%s\n",
                                    "1) Curar tota la taula",
                                    "2) Curar posicio concreta");
                            int optionCaseFour = s.nextInt();
                            System.out.printf("%s\n%s\n",
                                    "1) Curar amb percentatge",
                                    "2) Curar amb valor numeric");
                            int numericOrPercentage = s.nextInt();
                            if (optionCaseFour == 1) {
                                if (numericOrPercentage == 1) {
                                    float healFloat = 0;
                                    boolean validated = false;
                                    while (!validated) {
                                        System.out.print("Introdueix el percentatge (sense el simbol %) de 0 a 100: ");
                                        healFloat = s.nextInt();
                                        if (healFloat > 100 || healFloat < 0) {
                                            System.out.println("\033[31mError al introduir el percentatge de malalts.\033[30m");
                                        } else {
                                            validated = true;
                                        }
                                        healFloat = healFloat / 100;
                                    }
                                    for (int i = 0; i < row; i++) {
                                        for (int j = 0; j < column; j++) {
                                            totalSick += table[i][j];
                                            table[i][j] -= (int) (table[i][j] * healFloat);
                                            totalHealCompare += table[i][j];
                                        }
                                    }
                                    totalHeal += totalSick - totalHealCompare;
                                } else {
                                    System.out.print("Introdueix el número de malalts a curar: ");
                                    int heal = s.nextInt();
                                    for (int i = 0; i < row; i++) {
                                        for (int j = 0; j < column; j++) {
                                            totalSick += table[i][j];
                                            table[i][j] -= heal;
                                            if (table[i][j] < 0) {
                                                table[i][j] = 0;
                                            }
                                            totalHealCompare += table[i][j];
                                        }
                                    }
                                    totalHeal += totalSick - totalHealCompare;
                                }
                            } else {
                                System.out.print("Introdueix la fila: ");
                                int insertRow = s.nextInt();
                                System.out.print("Introdueix la columna: ");
                                int insertColumn = s.nextInt();
                                if (numericOrPercentage == 1) {
                                    float healFloat = 0;
                                    boolean validated = false;
                                    while (!validated) {
                                        System.out.print("Introdueix el percentatge (sense el simbol %) de 0 a 100: ");
                                        healFloat = s.nextInt();
                                        if (healFloat > 100 || healFloat < 0) {
                                            System.out.println("\033[31mError al introduir el percentatge de malalts.\033[30m");
                                        } else {
                                            validated = true;
                                        }
                                        healFloat = healFloat / 100;
                                    }
                                    totalSick = table[insertRow - 1][insertColumn - 1];
                                    table[insertRow - 1][insertColumn - 1] -= (int) (table[insertRow - 1][insertColumn - 1] * healFloat);
                                    totalHealCompare = table[insertRow - 1][insertColumn - 1];
                                    totalHeal += totalSick - totalHealCompare;
                                } else {
                                    int healInt = 0;
                                    boolean validated = false;
                                    while (!validated) {
                                        System.out.print("Introdueix el número de malalts a curar: ");
                                        healInt = s.nextInt();
                                        if (table[insertRow - 1][insertColumn - 1] < healInt || healInt < 0) {
                                            System.out.println("\033[31mError al introduir el numero de malalts.\033[30m");
                                        } else {
                                            validated = true;
                                        }
                                    }
                                    totalSick = table[insertRow - 1][insertColumn - 1];
                                    table[insertRow - 1][insertColumn - 1] -= healInt;
                                    totalHealCompare = table[insertRow - 1][insertColumn - 1];
                                    totalHeal += totalSick - totalHealCompare;
                                }
                            }
                        } else {
                            System.out.println("\033[31mEl taulell no s'ha creat\033[30m");
                        }
                    }
                    case "5" -> {
                        if (tableCreate) {
                            int malaltsDesplasar = 0;
                            int insertRow = 0;
                            int insertColumn = 0;
                            boolean malaltsBol = false;
                            boolean keyMalaltsBol = false;
                            boolean blockedBol = false;
                            int caseFive = 1;
                            while (caseFive != 2) {
                                while (!blockedBol) {
                                    System.out.print("Introdueix la fila: ");
                                    insertRow = s.nextInt();
                                    System.out.print("Introdueix la columna: ");
                                    insertColumn = s.nextInt();
                                    if (tableShow[insertRow - 1][insertColumn - 1].equals("X")) {
                                        System.out.println("\033[31mHas introduit una cel·la bloquejada, siusplau torna a intentar.\033[30m");
                                    } else {
                                        blockedBol = true;
                                    }
                                }
                                System.out.println("Els malalts que hi han son: " + table[insertRow - 1][insertColumn - 1]);
                                while (!malaltsBol) {
                                    System.out.print("Quants malalts vols desplaçar: ");
                                    malaltsDesplasar = s.nextInt();
                                    totalLockdown += malaltsDesplasar;
                                    if (malaltsDesplasar > table[insertRow - 1][insertColumn - 1]) {
                                        System.out.println("\033[31mError al introduir el valor " + malaltsDesplasar + " supera el numero de malalts.\033[30m");
                                    } else {
                                        malaltsBol = true;
                                    }
                                }
                                while (!keyMalaltsBol) {
                                    System.out.printf("%s\n%s\n%s\n%s\n",
                                            "Instruccions per a desplaçar: ",
                                            "| Q (dalt esquerra) |   W (dalt mig)    | E (dalt dreta) |",
                                            "| A (esquerra mig)  |  (Posicio actual) | D (dreta mig)  |",
                                            "| Z (baix esquerra) |   X (baix mig)    | C (baix dreta) |");
                                    System.out.print("Introdueix el valor: ");
                                    String keyDisplacement = s.next().toLowerCase();
                                    switch (keyDisplacement) {
                                        case "q" -> {
                                            if (insertRow - 1 == 0 || insertColumn - 1 == 0) {
                                                table[insertRow - 1][insertColumn - 1] -= malaltsDesplasar;
                                            } else {
                                                if (tableShow[insertRow - 2][insertColumn - 2].equals("X")) {
                                                    System.out.println("\033[31mNo es pot desplaçar a una cel·la bloquejada\033[30m");
                                                    totalLockdown -= malaltsDesplasar;
                                                } else {
                                                    table[insertRow - 1][insertColumn - 1] -= malaltsDesplasar;
                                                    table[insertRow - 2][insertColumn - 2] += malaltsDesplasar;
                                                }
                                            }
                                            keyMalaltsBol = true;
                                        }
                                        case "w" -> {
                                            if (insertRow - 1 == 0) {
                                                table[insertRow - 1][insertColumn - 1] -= malaltsDesplasar;
                                            } else {
                                                if (tableShow[insertRow - 2][insertColumn - 1].equals("X")) {
                                                    System.out.println("\033[31mNo es pot desplaçar a una cel·la bloquejada\033[30m");
                                                    totalLockdown -= malaltsDesplasar;
                                                } else {
                                                    table[insertRow - 1][insertColumn - 1] -= malaltsDesplasar;
                                                    table[insertRow - 2][insertColumn - 1] += malaltsDesplasar;
                                                }
                                            }
                                            keyMalaltsBol = true;
                                        }
                                        case "e" -> {
                                            if (insertRow - 1 == 0 || insertColumn - 1 >= column) {
                                                table[insertRow - 1][insertColumn - 1] -= malaltsDesplasar;
                                            } else {
                                                if (tableShow[insertRow - 2][insertColumn].equals("X")) {
                                                    System.out.println("\033[31mNo es pot desplaçar a una cel·la bloquejada\033[30m");
                                                    totalLockdown -= malaltsDesplasar;
                                                } else {
                                                    table[insertRow - 1][insertColumn - 1] -= malaltsDesplasar;
                                                    table[insertRow - 2][insertColumn] += malaltsDesplasar;
                                                }
                                            }
                                            keyMalaltsBol = true;
                                        }
                                        case "a" -> {
                                            if (insertColumn - 1 == 0) {
                                                table[insertRow - 1][insertColumn - 1] -= malaltsDesplasar;
                                            } else {
                                                if (tableShow[insertRow - 1][insertColumn - 2].equals("X")) {
                                                    System.out.println("\033[31mNo es pot desplaçar a una cel·la bloquejada\033[30m");
                                                    totalLockdown -= malaltsDesplasar;
                                                } else {
                                                    table[insertRow - 1][insertColumn - 1] -= malaltsDesplasar;
                                                    table[insertRow - 1][insertColumn - 2] += malaltsDesplasar;
                                                }
                                            }
                                            keyMalaltsBol = true;
                                        }
                                        case "d" -> {
                                            if (insertColumn - 1 >= column - 1) {
                                                table[insertRow - 1][insertColumn - 1] -= malaltsDesplasar;
                                            } else {
                                                if (tableShow[insertRow - 1][insertColumn].equals("X")) {
                                                    System.out.println("\033[31mNo es pot desplaçar a una cel·la bloquejada\033[30m");
                                                    totalLockdown -= malaltsDesplasar;
                                                } else {
                                                    table[insertRow - 1][insertColumn - 1] -= malaltsDesplasar;
                                                    table[insertRow - 1][insertColumn] += malaltsDesplasar;
                                                }
                                            }
                                            keyMalaltsBol = true;
                                        }
                                        case "z" -> {
                                            if (insertRow - 1 >= row - 1 || insertColumn - 1 == 0) {
                                                table[insertRow - 1][insertColumn - 1] -= malaltsDesplasar;
                                            } else {
                                                if (tableShow[insertRow][insertColumn - 2].equals("X")) {
                                                    System.out.println("\033[31mNo es pot desplaçar a una cel·la bloquejada\033[30m");
                                                    totalLockdown -= malaltsDesplasar;
                                                } else {
                                                    table[insertRow - 1][insertColumn - 1] -= malaltsDesplasar;
                                                    table[insertRow][insertColumn - 2] += malaltsDesplasar;
                                                }
                                            }
                                            keyMalaltsBol = true;
                                        }
                                        case "x" -> {
                                            if (insertRow - 1 >= row - 1) {
                                                table[insertRow - 1][insertColumn - 1] -= malaltsDesplasar;
                                            } else {
                                                if (tableShow[insertRow][insertColumn - 1].equals("X")) {
                                                    System.out.println("\033[31mNo es pot desplaçar a una cel·la bloquejada\033[30m");
                                                    totalLockdown -= malaltsDesplasar;
                                                } else {
                                                    table[insertRow - 1][insertColumn - 1] -= malaltsDesplasar;
                                                    table[insertRow][insertColumn - 1] += malaltsDesplasar;
                                                }
                                            }
                                            keyMalaltsBol = true;
                                        }
                                        case "c" -> {
                                            if (insertRow - 1 >= row - 1 || insertColumn - 1 >= column - 1) {
                                                table[insertRow - 1][insertColumn - 1] -= malaltsDesplasar;
                                            } else {
                                                if (tableShow[insertRow][insertColumn].equals("X")) {
                                                    System.out.println("\033[31mNo es pot desplaçar a una cel·la bloquejada\033[30m");
                                                    totalLockdown -= malaltsDesplasar;
                                                } else {
                                                    table[insertRow - 1][insertColumn - 1] -= malaltsDesplasar;
                                                    table[insertRow][insertColumn] += malaltsDesplasar;
                                                }
                                            }
                                            keyMalaltsBol = true;
                                        }
                                        default -> System.out.println("\033[31mError al introduir el valor " + keyDisplacement + " desitjat, torna a intentar...\033[30m");
                                    }
                                }
                                System.out.printf("%s\n%s\n%s\n",
                                        "Vols continuar desplaçant?",
                                        "1) Si",
                                        "2) No");
                                caseFive = s.nextInt();
                                malaltsBol = false;
                                keyMalaltsBol = false;
                                blockedBol = false;
                            }
                        } else {
                            System.out.println("\033[31mEl taulell no s'ha creat\033[30m");
                        }
                    }
                    case "6" -> {
                        totalSick = 0;
                        if (tableCreate) {
                            for (int i = 0; i < row; i++) {
                                for (int j = 0; j < column; j++) {
                                    tableShow[i][j] = String.valueOf(table[i][j]);
                                    totalSick += table[i][j];
                                }
                            }
                            for (int i = 0; i < cellBlocked; i++) {
                                tableShow[arrayColumn[i]][arrayRow[i]] = "X";
                            }
                            for (int i = 0; i < row; i++) {
                                for (int j = 0; j < column; j++) {
                                    if (tableShow[i][j].equals("X")) {
                                        System.out.print("\033[31m");
                                        System.out.printf("%-5s", "X");
                                        System.out.print("\033[30m");
                                    } else {
                                        System.out.printf("%-5s", tableShow[i][j] + " ");
                                    }
                                }
                                System.out.println();
                            }
                        } else {
                            System.out.println("\033[31mEl taulell no s'ha creat\033[30m");
                        }
                        System.out.println("El total de malalts es : " + totalSick);
                        System.out.println("El total de persones curades es : " + totalHeal);
                        System.out.println("El percentatge que no ha complit el confinament es : " + totalLockdown * 100 / totalSick );
                    }
                    case "7" -> System.out.println("Fins despres \uD83D\uDE04");
                    default -> System.out.println("\033[31mError al introduir el valor " + numOption + " desitjat, torna a intentar...\033[30m");
                }
            }
        }
    }
}
