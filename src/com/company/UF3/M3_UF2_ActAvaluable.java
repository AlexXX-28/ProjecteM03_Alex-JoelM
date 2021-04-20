
package com.company.UF3;


public class M3_UF2_ActAvaluable {

    public static void main(String[] args) {
        M3_UF2_ActAvaluable solucio = new M3_UF2_ActAvaluable();
        solucio.inici();
    }

    /**
     * Programa principal cridat des del main de la classe. Mostra el menú
     * per pantalla i segons la opció triada executa una o altre instrucció fins
     * que aquesta opció sigui la de sortir.
     */

    public void inici() {
        int option;
        GestorTaulell g = new GestorTaulell();
        Taulell table = null;
        int numOptions = 3;
        Taulell[] tables = new Taulell[100];
        int currentTable = 0;

        do {
            Interficie.showMenu(currentTable);
            option = Utils.validateEnterLimits(Interficie.returnSentenceCyan("Introdueix un numero del 0 al " + numOptions + " per seleccionar l'opció: "), 0, numOptions);
            switch (option) {
                case 1: { //Consultes
                    try {
                        g.queries();
                    }catch (Exception e) {
                        Interficie.printErrorVermell("Error al consultar");
                        e.printStackTrace();
                    }
                    break;
                }
                case 2: { //Creació del taulell
                    tables[Taulell.TablesSize] = new Taulell();
                    table = tables[Taulell.TablesSize];
                    Taulell.TablesSize++;
                    currentTable = Taulell.TablesSize;
                    g.creatTable(table, g.selectOptionTable(new String[]{"Taulell buit", "Taulell amb malalts"}));
                    numOptions = 11;
                    break;
                }
                case 3: {//Importar taulell
                    try {
                        g.importTable();
                    } catch (Exception e) {
                        Interficie.printErrorVermell("Error al guardar les taules");
                        e.printStackTrace();
                    }
                    break;
                }
                case 4: { //Guardar taulell
                    try {
                        g.saveTable(table, currentTable);
                    } catch (Exception e) {
                        Interficie.printErrorVermell("Error al guardar les taules");
                        e.printStackTrace();
                    }
                    break;
                }
                case 5: { //insertar Malalts
                    g.insertSick(table);
                    break;
                }
                case 6: { //Transmissió del virus
                    g.transmitSick(table);
                    break;
                }
                case 7: { //Curar malalts
                    g.healSick(table);
                    break;
                }
                case 8: { //Desplaçar malalts
                    g.moveSick(table);
                    break;
                }
                case 9: { //Mostrar Taula
                    Interficie.showTable(table);
                    break;
                }
                case 10: { // Seleccionar el taulell de treball
                    currentTable = Utils.validateEnterLimits("Selecciona el número de taulell: ", 1, Taulell.TablesSize);
                    table = tables[currentTable - 1];
                    break;
                }
                case 11: { // Buidar Taulell
                    table.buidarTaulell();
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
