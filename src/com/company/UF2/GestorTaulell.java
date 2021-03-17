package com.company.UF2;

import java.util.Scanner;

public class GestorTaulell {

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
        Scanner s = new Scanner(System.in);
        table[insertRow-1][insertColumn-1] = s.nextInt();
    }
}
