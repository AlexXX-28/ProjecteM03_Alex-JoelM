package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	//MENU
        Scanner s = new Scanner(System.in);
        System.out.printf("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s",
                            "1) Carrega taulell",
                            "2) Introduir malalts",
                            "3) Transmitir Virus",
                            "4) Curar malats",
                            "5) Desplaçar malalts",
                            "6) Mostrar informació",
                            "7) Sortir",
                            "Introduiex un numero del 1 al 7 per seleccionar l'opcio:");
        int numOpcio = s.nextInt();

    }
}
