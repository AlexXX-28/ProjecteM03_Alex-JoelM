package com.company.UF2;

import java.util.Scanner;

public class Utils {

    public static final String RESET = "\033[0m";
    public static final String VERMELL = "\033[31m";

    /**
     * Solicita un enter fins que sigui correcte
     *
     * @param missatge      Conté el text que es mostrarà per sol·licitar per
     *                      pantalla la introducció del número.
     * @param missatgeError Conté el text que es mostrarà a l'usuari en cas que
     *                      introdueixi un número buid o incorrecte
     * @return Valor enter que simbolitza el número que s'ha introduït per teclat
     */
    public static int validarEnter(String missatge, String missatgeError) {
        Scanner s = new Scanner(System.in);
        int ret;
        boolean correcte;
        do {
            System.out.print(missatge);
            correcte = s.hasNextInt();
            if (!correcte) {
                s.next();
                System.out.println(missatgeError);
            }
        } while (!correcte);
        ret = s.nextInt();
        s.nextLine();
        return ret;
    }

    public static int validateEnterLimits(String missatge, String missatgeError, int llargada) {
        Scanner s = new Scanner(System.in);
        int ret;
        boolean correct;
        do {
            do {
                System.out.print(missatge);
                correct = s.hasNextInt();
                if (!correct) {
                    s.next();
                    System.out.println(missatgeError);
                }
            } while (!correct);
            ret = s.nextInt();
            if (ret > llargada || ret <= 0) {
                System.out.println(VERMELL + "Error torna a intentar, el valor esta fora dels limits" + RESET);
            }
        } while (ret > llargada || ret <= 0);
        s.nextLine();
        return ret;
    }
}
