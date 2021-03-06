package com.company.UF2;


import java.util.Scanner;

/**
 * La classe GestorTaulell serveix per a "gestionar el taulell", tant crear taules com afegir malalts etc
 * @author Alex Saez
 * @author Joel Maria Montes
 */

public class GestorTaulell {
    Scanner s = new Scanner(System.in);

    /**
     * Ens permet crear un Taulell: Buit o Aleatori
     * @param table Es la classe Taulell que ens permet tenir l'informació de la taula seleccionada
     * @param option Es la variable que ens permet saber quina opció s'ha seleccionat
     */
    public void creatTable(Taulell table, int option) {
        int row = Utils.validateEnterLimits("Introdueix la quantitat de files: ", 1, 0);
        int column = Utils.validateEnterLimits("Introdueix la quantitat de columnes: ", 1, 0);
        table.setRow(row);
        table.setColumn(column);
        if (option == 1) {
            table.createTaulellBuit();
        } else {
            table.createTaulellRandom();
        }
    }

    /**
     * Ens permet buidar el taulell
     * @param table Es la classe Taulell que ens permet tenir l'informació de la taula seleccionada
     */
    public void buidarTaulell(Taulell table) {
        for (int i = 0; i < table.getRow() ; i++) {
            for (int j = 0; j < table.getColumn(); j++) {
                table.setCell(i,j,0);
            }
        }
    }
    /**
     * Ens permet introduir malalts en el taulell que tenim seleccionat
     * @param table Es la classe Taulell que ens permet tenir l'informació de la taula seleccionada
     */
    public void insertSick(Taulell table) {
        int row = Utils.validateEnterLimits("Introdueix la  fila: ", 1, table.getRow());
        int column = Utils.validateEnterLimits("Introdueix la columna: ", 1, table.getColumn());
        Interficie.printSentenceCyan("Per bloquejar introdueix un valor NEGATIU i per desbloquejar o modificar un numero POSITIU.\n");
        int valor = Utils.validateEnterLimits("Introdueix el numero de malalts per a la columna " + column + " de la fila " + row + ": ", 1, 0);
        table.setCell(row - 1, column - 1, valor);
    }

    /**
     * Ens permet transmetre el virus mitjançant una taxa de transmissió
     * @param table Es la classe Taulell que ens permet tenir l'informació de la taula seleccionada
     */
    public void transmitSick(Taulell table) {
        Interficie.printSentenceCyan("Introdueix la taxa de transmissió del virus: ");
        double rt = s.nextDouble();
        for (int i = 0; i < table.getRow(); i++) {
            for (int j = 0; j < table.getColumn(); j++) {
                table.addCell(i, j, (int) Math.floor(table.getCell(i, j) * rt)); // El calcul s'ha d'arrodonir cap a baix, ja que no poden haver ex: 1,5 persones malaltes per tant amb el Math.floor 1,5 = 1
            }
        }
    }

    /**
     * Ens permet curar malalts amb diferents opcions: "A tota la taula" o "Una posicio concreta"
     * i "Amb Percentatge" o "Amb Valor Numéric"
     * @param table Es la classe Taulell que ens permet tenir l'informació de la taula seleccionada
     */
    public void healSick(Taulell table) {
        int option = selectOptionTable(new String[]{"Curar tota la taula", "Curar posició concreta"});
        int numericOrPercent = selectOptionTable(new String[]{"Curar amb percentatge", "Curar amb valor numeric"});
        if (option == 1) { //curar tota la taula
            if (numericOrPercent == 1) {
                int percent = Utils.validateEnterLimits("Introduiex el percentatge de 0-100 (sense %): ", 0, 100);
                for (int i = 0; i < table.getRow(); i++) {
                    for (int j = 0; j < table.getColumn(); j++) {
                        if (table.getCell(i, j) > 0) {
                            int curados = table.getCell(i, j) * percent / 100;
                            table.addTotalHeal(curados);
                            table.addCell(i, j,-curados);
                        }
                    }
                }
            } else {
                int valor = Utils.validateEnterLimits("Introdueix el numero de malalts a curar: ", 1, 0);
                for (int i = 0; i < table.getRow(); i++) {
                    for (int j = 0; j < table.getColumn(); j++) {
                        if (table.getCell(i, j) > 0) {
                            if (table.getCell(i, j) - valor < 0) {
                                table.addTotalHeal(table.getCell(i, j));
                                table.setCell(i, j, 0);
                            } else {
                                table.addTotalHeal(valor);
                                table.addCell(i, j,-valor);
                            }
                        }
                    }
                }
            }
        }
        if (option == 2) { //curar posicio concreta
            int row = Utils.validateEnterLimits("Introdueix la fila: ", 1, table.getRow()) - 1;
            int column = Utils.validateEnterLimits("Introdueix la columna: ", 1, table.getColumn()) - 1;
            if (table.getCell(row, column) > 0) {
                if (numericOrPercent == 1) {
                    int percent = Utils.validateEnterLimits("Introduiex el percentatge de 0-100 (sense %): ", 0, 100);
                } else {
                    int valor = Utils.validateEnterLimits("Introdueix el numero de malalts per curar a la columna " + column + 1 + " de la fila " + row + 1 + ": ", 0, table.getCell(row, column));
                    table.addCell(row, column,-valor);
                    table.addTotalHeal(valor);
                }
            } else {
                Interficie.printErrorVermell("Error cel·la bloquejada!!!\n");
            }

        }
    }

    /**
     * Ens permet moure als malalts a les cel·les del voltant, sempre que no sigui una cel·la bloquejada
     * @param table Es la classe Taulell que ens permet tenir l'informació de la taula seleccionada
     */
    public void moveSick(Taulell table) {
        int x = 0;
        int y = 0;
        int row = Utils.validateEnterLimits("Introdueix la fila: ", 1, table.getRow()) - 1;
        int column = Utils.validateEnterLimits("Introdueix la columna: ", 1, table.getColumn()) - 1;
        if (table.getCell(row, column) < 0) {
            Interficie.printErrorVermell("Error cel·la bloquejada.\n");
        } else {
            Interficie.showOptionMove();
            String option = Utils.validateStringRange("Introdueix el valor: ", new String[]{"q", "w", "e", "a", "d", "z", "x", "c"});
            int sick = Utils.validateEnterLimits("Introduiex el número de malalts a desplaçar: ", 0, table.getCell(row, column));
            switch (option) {
                case "q": {
                    x = -1;
                    y = -1;
                    break;
                }
                case "w": {
                    x = -1;
                    y = 0;
                    break;
                }
                case "e": {
                    x = -1;
                    y = 1;
                    break;
                }
                case "a": {
                    x = 0;
                    y = -1;
                    break;
                }
                case "d": {
                    x = 0;
                    y = 1;
                    break;
                }
                case "z": {
                    x = 1;
                    y = -1;
                    break;
                }
                case "x": {
                    x = 1;
                    y = 0;
                    break;
                }
                case "c": {
                    x = 1;
                    y = 1;
                    break;
                }
            }
            if (row + x >= table.getRow() || row + x < 0 || column + y < 0  || column + y >= table.getColumn()) { //mirar
                Interficie.printErrorVermell("El desplaçament es fa fora dels limits.\n");
                table.addCell(row, column,-sick);
                table.addTotalNoConf(sick);
            } else {
                if (table.getCell(row + x, column + y) < 0) {
                    Interficie.printErrorVermell("No es possible el desplaçament, cel·la bloquejada\n");
                } else {
                    table.addCell(row, column,-sick);
                    table.addCell(row + x, column + y,sick);
                    table.addTotalNoConf(sick);
                }
            }

        }

    }

    /**
     * Ens permet escollir entre diferents opcions
     * @param sentences Es la frase que es mostra per a escollir entre les diferents opcions
     * @return Retorna la opcio escollida
     */
    public int selectOptionTable(String[] sentences) {
        int option;
        Interficie.showOptions(sentences);
        option = Utils.validateEnterLimits(Interficie.returnSentenceCyan("Selecciona una de les seguents opcions: "), 1, sentences.length);
        return option;
    }
}
