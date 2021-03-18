package com.company.UF2;

import java.util.Scanner;

public class Utils {
    Scanner s = new Scanner(System.in);

    /**
     * Solicita un enter fins que sigui correcte
     *
     * @param missatge      Conté el text que es mostrarà per sol·licitar per
     *                      pantalla la introducció del número.
     * @param missatgeError Conté el text que es mostrarà a l'usuari en cas que
     *                      introdueixi un número buid o incorrecte
     * @return Valor enter que simbolitza el número que s'ha introduït per teclat
     */
    public int validarEnter(String missatge, String missatgeError) {
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

    public int validateEnterLimits(String missatge, String missatgeError, int max,int min) {
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
            if (ret > max || ret <= min) {
                Interficie.printErrorVermell("Error torna a intentar, el valor esta fora dels limits\n");
            }
        } while (ret > max || ret <= min);
        s.nextLine();
        return ret;
    }
}
