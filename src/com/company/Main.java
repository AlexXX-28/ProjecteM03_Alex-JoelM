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
                System.out.println("Error al introducir el valor " + numOption + " deseado, vuelve a intentar...");
            } else {
                switch (numOption) {
                    case "1":
                        System.out.printf("%s\n%s\n",
                                "1) Taulell buit",
                                "2) Taulell amb malalts");
                        int optionCaseOne = s.nextInt();
                        if (optionCaseOne == 1) {
                            System.out.print("Introduiex la quantitat de files: ");
                            row = s.nextInt();
                            System.out.print("Introduiex la quantitat de columnes: ");
                            column = s.nextInt();
                            table = new int[row][column];
                            for (int i = 0; i < row; i++) {
                                for (int j = 0; j < column; j++) {
                                    table[i][j] = 0;
                                }
                            }
                        } else {
                            System.out.print("Introduiex la quantitat de files: ");
                            row = s.nextInt();
                            System.out.print("Introduiex la quantitat de columnes: ");
                            column = s.nextInt();
                            table = new int[row][column];
                            for (int i = 0; i < row; i++) {
                                int valueRow = i + 1;
                                System.out.println("Valors de la fila " + valueRow);
                                for (int j = 0; j < column; j++) {
                                    table[i][j] = s.nextInt();
                                }
                            }
                        }
                        break;
                    case "2":
                        int optionCaseTwo = 1;
                        while (optionCaseTwo != 2){
                            System.out.print("Introduiex la fila: ");
                            int insertRow = s.nextInt();
                            System.out.print("Introduiex la columna: ");
                            int insertColumn = s.nextInt();
                            System.out.print("Introdueix el valor per a la columna "+ insertColumn + " de la fila " + insertRow + ": ");
                            table[insertRow-1][insertColumn-1] = s.nextInt();
                            System.out.printf("%s\n%s\n%s\n",
                                    "Vols continuar introduint malalts? ",
                                    "1) Si",
                                    "2) No");
                            optionCaseTwo = s.nextInt();
                        }

                        break;
                    case "3":

                        break;
                    case "4":

                        break;
                    case "5":

                        break;
                    case "6":
                        for (int i = 0; i < row; i++) {
                            for (int j = 0; j < column; j++) {
                                System.out.print(table[i][j]);
                            }
                            System.out.println();
                        }
                        break;
                    case "7":

                        break;
                    default:
                        System.out.println("Error al introducir el valor " + numOption + " deseado, vuelve a intentar...");
                }
            }

        }

    }
}
