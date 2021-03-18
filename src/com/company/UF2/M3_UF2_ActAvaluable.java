
package com.company.UF2;


public class M3_UF2_ActAvaluable {


    public static void main(String[] args) {
        M3_UF2_ActAvaluable solucio = new M3_UF2_ActAvaluable();
        solucio.start();
    }

    /**
     * Programa principal cridat des del main de la classe. Mostra el menú
     * per pantalla i segons la opció triada executa una o altre instrucció fins
     * que aquesta opció sigui la de sortir.
     */
    public void start() {
        String[] menu = {
                "MENÚ                  ",
                "1. Carrega table      ",
                "2. Introduir malalts  ",
                "3. Transmitir Virus   ",
                "4. Curar malats       ",
                "5. Desplaçar malalts  ",
                "6. Mostrar informació ",
                "7. Configuració       ",
                "0. Sortir             "
        };
        GestorTaulell g = new GestorTaulell();
        Interficie i = new Interficie();
        Utils u = new Utils();
        int[][] table = new int[0][0];
        int option;
        int row = 0;
        int column = 0;
        int totalHealCompare = 0;
        int totalSick = 0;
        String errorEnter = "Error en introduir l'opció";
        boolean tableCreate = false;
        do {
            i.mostrarMenu(menu);
            option = u.validarEnter(i.printCyan("Introduiex un numero del 1 al 7 per seleccionar l'opció: "), i.returnErrorVermell("Error en introduir el valor desitjat, torna a intentar..."));
            switch (option) {
                case 1: //Creació del taulell
                    do {
                        i.mostrarOpcions("Taulell buit", "Taulell amb malalts");
                        option = u.validarEnter(i.printCyan("Selecciona una de les seguents opcions: "), i.returnErrorVermell(errorEnter));
                    } while (option != 1 && option != 2);
                    row = u.validarEnter("Introduiex la quantitat de files: ", i.returnErrorVermell(errorEnter));
                    column = u.validarEnter("Introduiex la quantitat de columnes: ", i.returnErrorVermell(errorEnter));
                    table = new int[row][column];
                    g.carregarDades(table, row, column, option);
                    // fer les X (cellblocked).
                    tableCreate = true;
                    break;
                case 2: //Afegir Malalts
                    do {
                        int insertRow = u.validateEnterLimits("Introduiex la fila: ", i.returnErrorVermell("Error en introduir la fila"), row,0);
                        int insertColumn = u.validateEnterLimits("Introduiex la columna: ", i.returnErrorVermell("Error en introduir la columna"), column,0);
                        i.printSentence("Introdueix el valor per a la columna " + insertColumn + " de la fila " + insertRow + ": ");
                        g.insertSick(table, insertRow, insertColumn);
                    } while (i.validateRepeat() == 1);
                    break;
                case 3: //Transmissió del virus
                    Interficie.printCyan("Introdueix la taxa de transmissió del virus: ");
                    if (tableCreate) {
                        g.transmitSick(table,row,column);
                    } else {
                        System.out.println("El taulell no s'ha creat");
                    }
                    break;
                case 4: //Curar malalts
                    totalHealCompare = 0;
                    totalSick = 0;
                    int numericOrPercentage = 0;
                    if (tableCreate) {
                        do {
                            i.mostrarOpcions("Curar tota la taula", "Curar posicio concreta");
                            option = u.validarEnter(Interficie.printCyan("Selecciona una de les opcions anteriors: "), Interficie.returnErrorVermell(errorEnter));
                        } while (option != 1 && option != 2);
                        do {
                            i.mostrarOpcions("Curar amb percentatge", "Curar amb valor numeric");
                            numericOrPercentage = u.validarEnter(Interficie.printCyan("Selecciona una de les opcions anteriors: "), Interficie.returnErrorVermell(errorEnter));
                        } while (numericOrPercentage != 1 && numericOrPercentage != 2);

                    } else {
                        Interficie.printErrorVermell("El taulell no s'ha creat"); // IDIOMA
                    }
                    break;
                case 5: //Desplaçar malalts
                    break;
                case 6: //Mostrar Taula
                    i.showTable(table);
                    break;
                case 7: // Configuració de la interfaz
                    break;
                case 0: // sortir
                    break;
            }
        } while (option != 0);


    }
}
