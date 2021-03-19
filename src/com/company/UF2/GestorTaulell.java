package com.company.UF2;

import jdk.jshell.execution.Util;

import java.util.Scanner;

public class GestorTaulell {
    Scanner s = new Scanner(System.in);
    Utils u = new Utils();
    Interficie i = new Interficie();

    public int[][] setSizeTable(int row,int column){
        row = u.validarEnter("Introdueix la quantitat de files: ", i.returnErrorVermell("Error en introduir el valor desitjat, torna a intentar..."));
        column = u.validarEnter("Introdueix la quantitat de columnes: ", i.returnErrorVermell("Error en introduir el valor desitjat, torna a intentar..."));
    return new int[row][column];
    }

    public void createTable(int option){
        do {
            i.mostrarOpcions(new String[]{"Taulell buit", "Taulell amb malalts"});
            option = u.validarEnter(Interficie.returnSentenceCyan("Selecciona una de les seguents opcions: "), Interficie.returnErrorVermell("Error en introduir l'opció"));
        } while (option != 1 && option != 2);
    }
    public void carregarDades(int[][] table, int row, int column, int option) {
        if (option == 1) {
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
    }
    public void insertSick(int[][]table, int insertRow, int insertColumn){
        table[insertRow-1][insertColumn-1] = s.nextInt();
    }
    public void transmitSick(int[][]table, int row, int column){
        double rt = s.nextDouble();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                table[i][j] += Math.floor(table[i][j] * rt); // El calcul s'ha d'arrodonir cap a baix, ja que no poden haver ex: 1,5 persones malaltes per tant amb el Math.floor 1,5 = 1
            }
        }
    }

}
