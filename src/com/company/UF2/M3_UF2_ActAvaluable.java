
package com.company;


public class M3_UF2_ActAvaluable {

    public static final String RESET = "\033[0m";
    public static final String VERMELL = "\033[31m";

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
        String[] menu = {
                "MENÚ",
                "1. Carrega taulell",
                "2. Introduir malalts",
                "3. Transmitir Virus",
                "4. Curar malats",
                "5. Desplaçar malalts",
                "6. Mostrar informació",
                "0. Sortir"
        };
        int opcio;
        GestorTaulell g = new GestorTaulell();
        Interficie i = new Interficie();
        int[][] taulell = new int[0][0];

        do {
            i.mostrarMenu(menu);
            opcio = Utils.validarEnter("Tria una opció: ", VERMELL + "Error en introduir el valor desitjat, torna a intentar..." + RESET);
            switch (opcio) {
                case 1: //Creació del taulell
                    break;
                case 2: //Afegir Malalts
                    break;
                case 3: //Transmissió del virus
                    break;
                case 4: //Curar malalts
                    break;
                case 5: //Desplaçar malalts
                    break;
                case 6: //Mostrar Taula
                    break;
                case 0:
                    break;
            }
        } while (opcio != 0);


    }
}
