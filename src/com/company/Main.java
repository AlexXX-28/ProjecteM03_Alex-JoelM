package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //MENU
        Scanner s = new Scanner(System.in);
        String numOpcio = "0";
        while (!numOpcio.equals("7")) {
            System.out.printf("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s",
                    "1) Carrega taulell",
                    "2) Introduir malalts",
                    "3) Transmitir Virus",
                    "4) Curar malats",
                    "5) Desplaçar malalts",
                    "6) Mostrar informació",
                    "7) Sortir",
                    "Introduiex un numero del 1 al 7 per seleccionar l'opcio:");
            numOpcio = s.next();
            if (numOpcio.length() != 1){
                System.out.println("Error al introducir el valor " + numOpcio + " deseado, vuelve a intentar...");
            } else {
                switch (numOpcio) {
                    case "1":

                        break;
                    case "2":

                        break;
                    case "3":

                        break;
                    case "4":

                        break;
                    case "5":

                        break;
                    case "6":

                        break;
                    case "7":

                        break;
                    default:
                        System.out.println("Error al introducir el valor " + numOpcio + " deseado, vuelve a intentar...");
                }
            }

        }

    }
}
