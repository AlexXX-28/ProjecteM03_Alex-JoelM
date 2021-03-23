package com.company.UF2;

import java.util.Random;

public class Taulell {
    private int row;
    private int column;
    private int[][] table;
    private int totalHeal;
    private int totalNoConf;
    public static int TablesSize = 0;

    public int getTotalNoConf(){
        return totalNoConf;
    }

    public void addTotalNoConf(int totalNoConf){
        this.totalNoConf += totalNoConf;
    }

    public int getTotalHeal() {
        return totalHeal;
    }

    public void addTotalHeal(int heal){
        this.totalHeal += heal;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int files) {
        this.row = files;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getCell(int i, int j) {
        return table[i][j];
    }

    public void setCell(int i, int j, int value) {
        this.table[i][j] = value;
    }

    public void addCell(int i, int j, int value){
        this.table[i][j] += value;
    }

    public void createTaulellRandom() {
        this.table = new int[row][column];
        this.totalHeal = 0;
        Random r = new Random();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                table[i][j] = r.nextInt(14) - 3;// el porcentage de X q habra sera numero negativos.
            }
        }
    }

    public void createTaulellBuit() {
        this.table = new int[row][column];
        this.totalHeal = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                table[i][j] = 0;
            }
        }
    }
}
