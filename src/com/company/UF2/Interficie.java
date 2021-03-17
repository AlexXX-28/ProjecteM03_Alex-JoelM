package com.company.UF2;


import java.util.Scanner;

public class Interficie {

    /**
     * Mostra la informació d'un array per pantalla de forma simple
     * @param dades Array d'string amb informació
     */
    public static void mostrarDades(String[] dades){

    }

    /**
     * Mostra per pantalla les diferents opcions que formen el menú
     * que es rep com a paràmetre. La primera posició de l'array menú és el
     * títol del mateix mentre que la resta són les opcions. Aquesta variable
     * ja ve inicialitzada des del codi que en fa la crida.
     * @param menu Conté les diferents opcions que es mostraran per pantalla a
     * l'usuari.
     */
    public static void mostrarMenu(String[] menu){
        for (int i = 0; i < menu.length; i++) {
            System.out.println(menu[i]);
        }
    }

    /**
     * Mostra la informació per pantalla de forma simple
     * @param missatge1 Missatge1 a mostrar per pantalla
     * @param missatge2 Missatge2 a mostrar per pantalla
     */
    public static void mostrarOpcions(String missatge1,String missatge2){
        System.out.println("1) " + missatge1);
        System.out.println("2) " + missatge2);
    }

    public static int validateRepeat(){
        int opcio;
        do {
            Scanner s = new Scanner(System.in);
            System.out.println("Vols continuar introduint malalts?");
            mostrarOpcions("Si", "No");
            System.out.print("Opció: ");
            opcio = s.nextInt();
        }while (opcio != 1 && opcio != 2);
        return opcio;
    }
    public static void showTable(int[][] array){
        for (int i = 0; i < array.length ; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
    /**
     * Mostra la informació per pantalla en format capçalera
     * @param missatge Missatge a mostrar per pantalla en format capçalera
     */
    public static void mostrarCapçalera(String missatge){

        System.out.println("______________________________");
        System.out.println(missatge);
        System.out.println("______________________________");
    }

    public static void mostrarMisssatge(String missatge){
        System.out.println(missatge);
    }
    
}
