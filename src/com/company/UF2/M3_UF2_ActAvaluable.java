
package com.company.UF2;


public class M3_UF2_ActAvaluable {

    public static final String RESET = "\033[0m";
    public static final String VERMELL = "\033[31m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";
    public static final String YELLOW = "\u001B[33m";


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
                "MENÚ",
                "1. Carrega table",
                "2. Introduir malalts",
                "3. Transmitir Virus",
                "4. Curar malats",
                "5. Desplaçar malalts",
                "6. Mostrar informació",
                "7. Configuració",
                "0. Sortir"
        };
        GestorTaulell g = new GestorTaulell();
        Interficie i = new Interficie();
        Utils u = new Utils();
        int[][] table = new int[0][0];
        int option;
        int row = 0;
        int column = 0;
        String errorEnter = VERMELL + "Error en introduir l'opció." + RESET;
        do {
            i.mostrarMenu(menu);
            option = u.validarEnter(CYAN + "Introduiex un numero del 1 al 7 per seleccionar l'opció: " + RESET, VERMELL + "Error en introduir el valor desitjat, torna a intentar..." + RESET);
            switch (option) {
                case 1: //Creació del taulell
                    do {
                        i.mostrarOpcions("Taulell buit", "Taulell amb malalts");
                        option = u.validarEnter(CYAN + "Selecciona una de les seguents opcions: " + RESET, errorEnter);
                    } while (option != 1 && option != 2);
                    row = u.validarEnter("Introduiex la quantitat de files: ", errorEnter);
                    column = u.validarEnter("Introduiex la quantitat de columnes: ", errorEnter);
                    table = new int[row][column];
                    g.carregarDades(table, row, column, option);
                    // fer les X (cellblocked).
                    break;
                case 2: //Afegir Malalts
                    do {
                        int insertRow = u.validateEnterLimits("Introduiex la fila: ", VERMELL + "Error en introduir la fila" + RESET, row);
                        int insertColumn = u.validateEnterLimits("Introduiex la columna: ", VERMELL + "Error en introduir la columna" + RESET, column);
                        i.mostrarMisssatge("Introdueix el valor per a la columna " + insertColumn + " de la fila " + insertRow + ": ");
                        g.insertSick(table, insertRow, insertColumn);
                    }while (i.validateRepeat() == 1);
                    break;
                case 3: //Transmissió del virus
                    break;
                case 4: //Curar malalts
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
