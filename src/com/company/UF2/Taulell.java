package com.company.UF2;

import java.util.Random;

/**
 * La clase Taulell serveix per a la creació de diversos taulell.
 * @author Joel Maria Montes
 * @author Alex Saez
 */
public class Taulell {
    private int row;
    private int column;
    private int[][] table;
    private int totalHeal;
    private int totalNoConf;
    public static int TablesSize = 0;

    /**
     * Te com objectiu retornar el total NO confinat
     * @return Retornara el total NO confinat
     */
    public int getTotalNoConf(){
        return totalNoConf;
    }

    /**
     * Te com objectiu introduir el total No Confinats
     * @param totalNoConf Serveix com a variable per a guardar els valors al la varible totalNoConf
     */
    public void addTotalNoConf(int totalNoConf){
        this.totalNoConf += totalNoConf;
    }

    /**
     * Te com objectiu retornar el total de curats
     * @return Retornara el total de curats
     */
    public int getTotalHeal() {
        return totalHeal;
    }

    /**
     * Te com objectiu introduir el total de curats
     * @param heal Es pasara com a valor els curats per guardar-la i afegir-la la variable totalHeal
     */
    public void addTotalHeal(int heal){
        this.totalHeal += heal;
    }
    /**
     * Te com objectiu retornar el total de files del taulell
     * @return Retorna la quantitat de files que tens en el teu taulell
     */
    public int getRow() {
        return row;
    }
    /**
     * Te com objectiu introduir les files que tindra el taulell
     * @param files Variable que s'utilitza per insertar les files que tindra el taulell
     */
    public void setRow(int files) {
        this.row = files;
    }
    /**
     * Te com objectiu retornar el total de columnes del taulell
     * @return Retorna la quantitat de columnes que tens en el teu taulell
     */
    public int getColumn() {
        return column;
    }

    /**
     * Te com objectiu introduir les columnes que tindra el taulell
     * @param column Varible que s'utilitza per insertar les columnes que tindras al taulell
     */
    public void setColumn(int column) {
        this.column = column;
    }

    /**
     * Te com objectiu agafar el valor de la cel·la a partir d'introduir la posició de la fila i la columna
     * @param i Serveix com index de les files
     * @param j Serveix com index de les columnes
     * @return Retorna el valor de la cel·la a partir de la posició de files i columnes (i,j)
     */
    public int getCell(int i, int j) {
        return table[i][j];
    }
    /**
     * Te com objectiu introduir el valor a la cel·la a partir d'introduir la posició de la fila i la columna
     * @param i Serveix com index de les files
     * @param j Serveix com index de les columnes
     * @param value El valor que s'introduira en la cel·la
     */
    public void setCell(int i, int j, int value) {
        this.table[i][j] = value;
    }
    /**
     * Te com objectiu afegir el valor a la cel·la a partir d'introduir la posició de la fila i la columna
     * @param i Serveix com index de les files
     * @param j Serveix com index de les columnes
     * @param value El valor que s'afegeix en la cel·la
     */
    public void addCell(int i, int j, int value){
        this.table[i][j] += value;
    }
    /**
     * Afegeix a la taula creada numeros randoms a les cel·les a partir del rnag -3 fins a 10 (tots dos inclos)
     */
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
    /**
     * Afegeix a totes les cel·les creades un valor de 0
     */
    public void createTaulellBuit() {
        this.table = new int[row][column];
        this.totalHeal = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                table[i][j] = 0;
            }
        }
    }
    public void buidarTaulell() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                table[i][j] = 0;
            }
        }
    }
}
