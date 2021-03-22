
package com.company.UF2;

public class M3_UF2_ActAvaluable {


    public static void main(String[] args) {
        M3_UF2_ActAvaluable solucio = new M3_UF2_ActAvaluable();
        solucio.inici();
    }

    public void inici() {
        int option;
        GestorTaulell g = new GestorTaulell();
        Taulell table = null;
        int numOptions = 1;
        Taulell[] tables = new Taulell[100];
        int optionTableMove = 0;

        do {
            Interficie.showMenu(optionTableMove);
            option = Utils.validateEnterLimits(Interficie.returnSentenceCyan("Introdueix un numero del 0 al " + numOptions + " per seleccionar l'opció: "), 0,numOptions);
            switch (option) {
                case 1: { //Creació del taulell
                    tables[Taulell.TablesSize] = new Taulell();
                    table = tables[Taulell.TablesSize];
                    Taulell.TablesSize++;
                    optionTableMove = Taulell.TablesSize;
                    g.creatTable(table, g.selectOptionTable(new String[]{"Taulell buit", "Taulell amb malalts"}));
                     numOptions = 9;
                    break;
                }
                case 2: { //Afegir Malalts
                        g.insertSick(table);
                    break;
                }
                case 3: { //Transmissió del virus
                        g.transmitSick(table);
                    break;
                }
                case 4: { //Curar malalts
                    g.healSick(table);
                    break;
                }
                case 5: { //Desplaçar malalts
                    g.moveSick(table);
                    break;
                }
                case 6: { //Mostrar Taula
                    Interficie.showTable(table);
                    break;
                }
                case 7: { // Buidar taulell
                    table.emptyTaulell();
                    break;
                }
                case 8: { // Seleccionar el taulell de treball
                    optionTableMove = Utils.validateEnterLimits("Selecciona el número de taulell: ",1,Taulell.TablesSize);
                    table = tables[optionTableMove-1];
                    break;
                }
                case 0: { // sortir
                    Interficie.printSentence("Fins despres \033[33m\uD83D\uDE04"); //Fins despres amb cara de feliçitat groga
                    break;
                }
            }
        } while (option != 0);


    }
}
