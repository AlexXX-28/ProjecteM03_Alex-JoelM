package com.company.UF2;


import java.util.Scanner;

public class GestorTaulell {
    Scanner s = new Scanner(System.in);

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

    public void insertSick(Taulell table) {
        int row = Utils.validateEnterLimits("Introdueix la  fila: ", 1, table.getRow());
        int column = Utils.validateEnterLimits("Introdueix la columna: ", 1, table.getColumn());
        Interficie.printSentenceCyan("Per bloquejar introdueix un valor NEGATIU i per desbloquejar o modificar un numero POSITIU.\n");
        int valor = Utils.validateEnterLimits("Introdueix el numero de malalts per a la columna " + column + " de la fila " + row + ": ", 1, 0);
        table.setCell(row - 1, column - 1, valor);
    }

    public void transmitSick(Taulell table) {
        Interficie.printSentenceCyan("Introdueix la taxa de transmissió del virus: ");
        double rt = s.nextDouble();
        for (int i = 0; i < table.getRow(); i++) {
            for (int j = 0; j < table.getColumn(); j++) {
                table.addCell(i, j, (int) Math.floor(table.getCell(i, j) * rt)); // El calcul s'ha d'arrodonir cap a baix, ja que no poden haver ex: 1,5 persones malaltes per tant amb el Math.floor 1,5 = 1
            }
        }
    }

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

    public void moveSick(Taulell table) {
        int x = 0;
        int y = 0;
        int row = Utils.validateEnterLimits("Introdueix la fila: ", 1, table.getRow()) - 1;
        int column = Utils.validateEnterLimits("Introdueix la columna: ", 1, table.getColumn()) - 1;
        if (table.getCell(row, column) < 0) {
            Interficie.printErrorVermell("Error cel·la bloquejada.");
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
            if (row + x > table.getRow() || row + x < 0 || column + y > table.getRow() || column + y > table.getRow()) {
                Interficie.printErrorVermell("El desplaçament es fa fora dels limits.");
                table.addCell(row, column,-sick);
                table.addTotalNoConf(sick);
            } else {
                if (table.getCell(row + x, column + y) < 0) {
                    Interficie.printErrorVermell("No es possible el desplaçament, cel·la bloquejada");
                } else {
                    table.addCell(row, column,-sick);
                    table.addCell(row + x, column + y,sick);
                    table.addTotalNoConf(sick);
                }
            }

        }

    }

    public int selectOptionTable(String[] sentences) {
        int option;
        Interficie.showOptions(sentences);
        option = Utils.validateEnterLimits(Interficie.returnSentenceCyan("Selecciona una de les seguents opcions: "), 1, sentences.length);
        return option;
    }
}
