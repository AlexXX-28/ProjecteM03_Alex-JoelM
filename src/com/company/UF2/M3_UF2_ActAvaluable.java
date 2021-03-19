
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

        GestorTaulell g = new GestorTaulell();
        Interficie i = new Interficie();
        Utils u = new Utils();
        int[][] table = new int[0][0];
        int option;
        int row = 0;
        int column = 0;
        int totalHealCompare = 0;
        int totalSick = 0;
        boolean tableCreate = false;
        do {
            i.mostrarMenu();
            option = u.validarEnter(i.returnSentenceCyan("Introdueix un numero del 1 al 7 per seleccionar l'opció: "), i.returnErrorVermell("Error en introduir el valor desitjat, torna a intentar..."));
            switch (option) {
                case 1: //Creació del taulell
                    g.createTable(option);
                    table = g.setSizeTable(row,column);
                    //error prq el row i el colum como se definen dentro de una funcion se resetean
                    /*
                    row = u.validarEnter("Introdueix la quantitat de files: ", i.returnErrorVermell("Error en introduir el valor desitjat, torna a intentar..."));
                    column = u.validarEnter("Introdueix la quantitat de columnes: ", i.returnErrorVermell("Error en introduir el valor desitjat, torna a intentar..."));
                    table = new int[row][column];

                     */
                    g.carregarDades(table, row, column, option);
                    // fer les X (cellblocked).
                    tableCreate = true;
                    break;
                case 2: //Afegir Malalts
                    if (tableCreate){
                        do {
                            int insertRow = u.validateEnterLimits("Introduiex la fila: ", i.returnErrorVermell("Error en introduir la fila"), row, 0);
                            int insertColumn = u.validateEnterLimits("Introduiex la columna: ", i.returnErrorVermell("Error en introduir la columna"), column, 0);
                            i.printSentence("Introdueix el valor per a la columna " + insertColumn + " de la fila " + insertRow + ": ");
                            g.insertSick(table, insertRow, insertColumn);
                        } while (i.validateRepeat("Vols continuar afegint malalts?") == 1);
                    }else {
                        Interficie.printErrorVermell("El taulell no s'ha creat\n");
                    }
                    break;
                case 3: //Transmissió del virus
                    if (tableCreate) {
                        do {
                            Interficie.printSentenceCyan("Introdueix la taxa de transmissió del virus: ");
                            g.transmitSick(table, row, column);
                        } while (i.validateRepeat("Vols continuar transmitint virus?") == 1);
                    } else {
                        Interficie.printErrorVermell("El taulell no s'ha creat\n");
                    }
                    break;
                case 4: //Curar malalts
                    int numericOrPercentage = 0;
                    if (tableCreate) {
                        do {
                            i.mostrarOpcions(new String[]{"Curar tota la taula", "Curar posicio concreta"});
                            option = u.validarEnter(Interficie.returnSentenceCyan("Selecciona una de les opcions anteriors: "), Interficie.returnErrorVermell("Error en introduir el valor desitjat, torna a intentar..."));
                        } while (option != 1 && option != 2);
                        do {
                            i.mostrarOpcions(new String[]{"Curar amb percentatge", "Curar amb valor numeric"});
                            numericOrPercentage = u.validarEnter(Interficie.returnSentenceCyan("Selecciona una de les opcions anteriors: "), Interficie.returnErrorVermell("Error en introduir el valor desitjat, torna a intentar..."));
                        } while (numericOrPercentage != 1 && numericOrPercentage != 2);

                    } else {
                        Interficie.printErrorVermell("El taulell no s'ha creat\n"); // IDIOMA
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
