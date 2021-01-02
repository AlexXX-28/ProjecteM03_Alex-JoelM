package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] table = new int[0][0];
        int row = 0;
        int column = 0;
        Scanner s = new Scanner(System.in);
        String numOption = "0";
        while (!numOption.equals("7")) {
            System.out.printf("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s",
                    "1) Carrega taulell",
                    "2) Introduir malalts",
                    "3) Transmitir Virus",
                    "4) Curar malats",
                    "5) Desplaçar malalts",
                    "6) Mostrar informació",
                    "7) Sortir",
                    "Introduiex un numero del 1 al 7 per seleccionar l'opció: ");
            numOption = s.next();
            if (numOption.length() != 1) {
                System.out.println("Error al introduir el valor " + numOption + " desitjat, torna a intentar...");
            } else {
                switch (numOption) {
                    case "1":
                        System.out.printf("%s\n%s\n",
                                "1) Taulell buit",
                                "2) Taulell amb malalts");
                        int optionCaseOne = s.nextInt();
                        System.out.print("Introduiex la quantitat de files: ");
                        row = s.nextInt();
                        System.out.print("Introduiex la quantitat de columnes: ");
                        column = s.nextInt();
                        table = new int[row][column];
                        if (optionCaseOne == 1) {
                            for (int i = 0; i < row; i++) {
                                for (int j = 0; j < column; j++) {
                                    table[i][j] = 0;
                                }
                            }
                        } else {
                            for (int i = 0; i < row; i++) {
                                for (int j = 0; j < column; j++) {
                                    table[i][j] = (int) (Math.random()*11);
                                }
                            }
                        }
                        break;
                    case "2":
                        int optionCaseTwo = 1;
                        while (optionCaseTwo != 2) {
                            System.out.print("Introduiex la fila: ");
                            int insertRow = s.nextInt();
                            System.out.print("Introduiex la columna: ");
                            int insertColumn = s.nextInt();
                            System.out.print("Introdueix el valor per a la columna " + insertColumn + " de la fila " + insertRow + ": ");
                            table[insertRow - 1][insertColumn - 1] = s.nextInt();
                            System.out.printf("%s\n%s\n%s\n",
                                    "Vols continuar introduint malalts? ",
                                    "1) Si",
                                    "2) No");
                            optionCaseTwo = s.nextInt();
                        }
                        break;
                    case "3":
                        System.out.print("Introdueix la taxa de transmissió del virus: ");
                        double rt = s.nextDouble();
                        for (int i = 0; i < row; i++) {
                            for (int j = 0; j < column; j++) {
                                table[i][j] += Math.floor(table[i][j] * rt);
                            }
                        }
                        break;
                    case "4":
                        System.out.printf("%s\n%s\n",
                                "1) Curar tota la taula",
                                "2) Curar posicio concreta");
                        int optionCaseFour = s.nextInt();
                        System.out.printf("%s\n%s\n",
                                "1) Curar amb percentatge",
                                "2) Curar amb valor numeric");
                        int numericOrPercentage = s.nextInt();
                        if (optionCaseFour == 1) {
                            System.out.print("Introdueix el percentatge (sense el simbol %): ");
                            float heal = s.nextFloat() / 100;
                            if (numericOrPercentage == 1) {
                                for (int i = 0; i < row; i++) {
                                    for (int j = 0; j < column; j++) {
                                        table[i][j] = (int) (table[i][j] * heal);
                                    }
                                }
                            } else {
                                for (int i = 0; i < row; i++) {
                                    for (int j = 0; j < column; j++) {
                                        table[i][j] = (int) (table[i][j] - heal);
                                    }
                                }
                            }
                        } else {
                            System.out.print("Introdueix el numero de cura: ");
                            double heal = s.nextDouble();
                            System.out.print("Introduiex la fila: ");
                            int insertRow = s.nextInt();
                            System.out.print("Introduiex la columna: ");
                            int insertColumn = s.nextInt();
                            if (numericOrPercentage == 1) {
                                table[insertRow - 1][insertColumn - 1] -= Math.floor(table[insertRow - 1][insertColumn - 1] * heal);
                            } else {
                                table[insertRow - 1][insertColumn - 1] -= Math.floor(table[insertRow - 1][insertColumn - 1] - heal);
                            }
                        }
                        break;
                    case "5":
                        boolean malaltsBol = false;
                        boolean keyMalaltsBol = false;
                        int malaltsDesplasar = 0;
                        System.out.print("Introdueix la fila: ");
                        int insertRow = s.nextInt();
                        System.out.print("Introdueix la columna: ");
                        int insertColumn = s.nextInt();
                        System.out.println("Els malalts que hi han son: " + table[insertRow - 1][insertColumn - 1]);
                        while (!malaltsBol) {
                            System.out.print("Quants malalts vols desplaçar: ");
                            malaltsDesplasar = s.nextInt();
                            if (malaltsDesplasar > table[insertRow - 1][insertColumn - 1]) {
                                System.out.println("Error al introduir el valor " + malaltsDesplasar + " supera el maxim permes.");
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
                                        table[insertRow - 1][insertColumn - 1] -= malaltsDesplasar;
                                        table[insertRow - 2][insertColumn - 2] += malaltsDesplasar;
                                    }
                                    keyMalaltsBol = true;
                                }
                                case "w" -> {
                                    if (insertRow - 1 == 0) {
                                        table[insertRow - 1][insertColumn - 1] -= malaltsDesplasar;
                                    } else {
                                        table[insertRow - 1][insertColumn - 1] -= malaltsDesplasar;
                                        table[insertRow - 2][insertColumn - 1] += malaltsDesplasar;
                                    }
                                    keyMalaltsBol = true;
                                }
                                case "e" -> {
                                    if (insertRow - 1 == 0 || insertColumn - 1 >= column) {
                                        table[insertRow - 1][insertColumn - 1] -= malaltsDesplasar;
                                    } else {
                                        table[insertRow - 1][insertColumn - 1] -= malaltsDesplasar;
                                        table[insertRow - 2][insertColumn] += malaltsDesplasar;
                                    }
                                    keyMalaltsBol = true;
                                }
                                case "a" -> {
                                    if (insertColumn - 1 == 0) {
                                        table[insertRow - 1][insertColumn - 1] -= malaltsDesplasar;
                                    } else {
                                        table[insertRow - 1][insertColumn - 1] -= malaltsDesplasar;
                                        table[insertRow - 1][insertColumn - 2] += malaltsDesplasar;
                                    }
                                    keyMalaltsBol = true;
                                }
                                case "d" -> {
                                    if (insertColumn - 1 >= column - 1) {
                                        table[insertRow - 1][insertColumn - 1] -= malaltsDesplasar;
                                    } else {
                                        table[insertRow - 1][insertColumn - 1] -= malaltsDesplasar;
                                        table[insertRow - 1][insertColumn] += malaltsDesplasar;
                                    }
                                    keyMalaltsBol = true;
                                }
                                case "z" -> {
                                    if (insertRow - 1 >= row - 1 || insertColumn - 1 == 0) {
                                        table[insertRow - 1][insertColumn - 1] -= malaltsDesplasar;
                                    } else {
                                        table[insertRow - 1][insertColumn - 1] -= malaltsDesplasar;
                                        table[insertRow][insertColumn - 2] += malaltsDesplasar;
                                    }
                                    keyMalaltsBol = true;
                                }
                                case "x" -> {
                                    if (insertRow - 1 >= row - 1) {
                                        table[insertRow - 1][insertColumn - 1] -= malaltsDesplasar;
                                    } else {
                                        table[insertRow - 1][insertColumn - 1] -= malaltsDesplasar;
                                        table[insertRow][insertColumn - 1] += malaltsDesplasar;
                                    }
                                    keyMalaltsBol = true;
                                }
                                case "c" -> {
                                    if (insertRow - 1 >= row - 1 || insertColumn - 1 >= column - 1) {
                                        table[insertRow - 1][insertColumn - 1] -= malaltsDesplasar;
                                    } else {
                                        table[insertRow - 1][insertColumn - 1] -= malaltsDesplasar;
                                        table[insertRow][insertColumn] += malaltsDesplasar;
                                    }
                                    keyMalaltsBol = true;
                                }
                                default -> System.out.println("Error al introduir el valor " + keyDisplacement + " desitjat, torna a intentar...");
                            }
                        }
                        break;
                    case "6":
                        for (int i = 0; i < row; i++) {
                            for (int j = 0; j < column; j++) {
                                System.out.print(table[i][j] + " ");
                            }
                            System.out.println();
                        }
                        break;
                    case "7":
                        System.out.println("Fins despres :D");
                        break;
                    default:
                        System.out.println("Error al introduir el valor " + numOption + " desitjat, torna a intentar...");
                }
            }

        }

    }
}
