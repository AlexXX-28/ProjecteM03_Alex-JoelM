package com.company.UF3;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

/**
 * La classe GestorTaulell serveix per a "gestionar el taulell", tant crear taules com afegir malalts etc
 *
 * @author Alex Saez
 * @author Joel Maria Montes
 */


public class GestorTaulell {
    Scanner s = new Scanner(System.in);


    public Taulell initializeTable(Taulell[] tables) {
        tables[Taulell.TablesSize] = new Taulell();
        Taulell.TablesSize++;
        Taulell.currentTable = Taulell.TablesSize;
        return tables[Taulell.TablesSize - 1];
    }

    /**
     * Ens permet crear un Taulell: Buit o Aleatori
     *
     * @param table  Es la classe Taulell que ens permet tenir l'informació de la taula seleccionada
     * @param option Es la variable que ens permet saber quina opció s'ha seleccionat
     */
    public void creatTable(Taulell table, int option) {
        int row = Utils.validateEnterLimits("Introdueix la quantitat de files: ", 1, 0);
        int column = Utils.validateEnterLimits("Introdueix la quantitat de columnes: ", 1, 0);
        table.setRow(row);
        table.setColumn(column);
        if (option == 1) {
            table.createTaulellBuit();
        } else {
            table.createTaulellRandom();
        }
    }

    /**
     * Ens permet introduir malalts en el taulell que tenim seleccionat
     *
     * @param table Es la classe Taulell que ens permet tenir l'informació de la taula seleccionada
     */
    public void insertSick(Taulell table) {
        int row = Utils.validateEnterLimits("Introdueix la  fila: ", 1, table.getRow());
        int column = Utils.validateEnterLimits("Introdueix la columna: ", 1, table.getColumn());
        Interficie.printSentenceCyan("Per bloquejar introdueix un valor NEGATIU i per desbloquejar o modificar un numero POSITIU.\n");
        int valor = Utils.validateEnterLimits("Introdueix el numero de malalts per a la columna " + column + " de la fila " + row + ": ", 1, 0);
        table.setCell(row - 1, column - 1, valor);
    }

    /**
     * Ens permet transmetre el virus mitjançant una taxa de transmissió
     *
     * @param table Es la classe Taulell que ens permet tenir l'informació de la taula seleccionada
     */
    public void transmitSick(Taulell table) {
        Interficie.printSentenceCyan("Introdueix la taxa de transmissió del virus: ");
        double rt = s.nextDouble();
        for (int i = 0; i < table.getRow(); i++) {
            for (int j = 0; j < table.getColumn(); j++) {
                table.addCell(i, j, (int) Math.floor(table.getCell(i, j) * rt)); // El calcul s'ha d'arrodonir cap a baix, ja que no poden haver ex: 1,5 persones malaltes per tant amb el Math.floor 1,5 = 1
            }
        }
    }

    /**
     * Ens permet curar malalts amb diferents opcions: "A tota la taula" o "Una posicio concreta"
     * i "Amb Percentatge" o "Amb Valor Numéric"
     *
     * @param table Es la classe Taulell que ens permet tenir l'informació de la taula seleccionada
     */
    public void healSick(Taulell table) {
        int option = selectOptionTable(new String[]{"Curar tota la taula", "Curar posició concreta"});
        int numericOrPercent = selectOptionTable(new String[]{"Curar amb percentatge", "Curar amb valor numeric"});
        if (option == 1) { //curar tota la taula
            if (numericOrPercent == 1) {
                int percent = Utils.validateEnterLimits("Introduiex el percentatge de 0-100 (sense %): ", 0, 100);
                for (int i = 0; i < table.getRow(); i++) {
                    for (int j = 0; j < table.getColumn(); j++) {
                        if (table.getCell(i, j) > 0) {
                            int curados = table.getCell(i, j) * percent / 100;
                            table.addCell(i, j, -curados);
                        }
                    }
                }
            } else {
                int valor = Utils.validateEnterLimits("Introdueix el numero de malalts a curar: ", 1, 0);
                for (int i = 0; i < table.getRow(); i++) {
                    for (int j = 0; j < table.getColumn(); j++) {
                        if (table.getCell(i, j) > 0) {
                            if (table.getCell(i, j) - valor < 0) {

                                table.addCell(i, j, -table.getCell(i, j));
                            } else {
                                table.addCell(i, j, -valor);
                            }
                        }
                    }
                }
            }
        }
        if (option == 2) { //curar posicio concreta
            int row = Utils.validateEnterLimits("Introdueix la fila: ", 1, table.getRow()) - 1;
            int column = Utils.validateEnterLimits("Introdueix la columna: ", 1, table.getColumn()) - 1;
            if (table.getCell(row, column) > 0) {
                if (numericOrPercent == 1) {
                    int percent = Utils.validateEnterLimits("Introduiex el percentatge de 0-100 (sense %): ", 0, 100);
                } else {
                    int valor = Utils.validateEnterLimits("Introdueix el numero de malalts per curar a la columna " + column + 1 + " de la fila " + row + 1 + ": ", 0, table.getCell(row, column));
                    table.addCell(row, column, -valor);
                }
            } else {
                Interficie.printErrorVermell("Error cel·la bloquejada!!!\n");
            }

        }
    }

    /**
     * Ens permet moure als malalts a les cel·les del voltant, sempre que no sigui una cel·la bloquejada
     *
     * @param table Es la classe Taulell que ens permet tenir l'informació de la taula seleccionada
     */
    public void moveSick(Taulell table) {
        int x = 0;
        int y = 0;
        int row = Utils.validateEnterLimits("Introdueix la fila: ", 1, table.getRow()) - 1;
        int column = Utils.validateEnterLimits("Introdueix la columna: ", 1, table.getColumn()) - 1;
        if (table.getCell(row, column) < 0) {
            Interficie.printErrorVermell("Error cel·la bloquejada.\n");
        } else {
            Interficie.showOptionMove();
            String option = Utils.validateStringRange("Introdueix el valor: ", new String[]{"q", "w", "e", "a", "d", "z", "x", "c"});
            int sick = Utils.validateEnterLimits("Introduiex el número de malalts a desplaçar: ", 0, table.getCell(row, column));
            switch (option) {
                case "q": {
                    x = -1;
                    y = -1;
                    break;
                }
                case "w": {
                    x = -1;
                    y = 0;
                    break;
                }
                case "e": {
                    x = -1;
                    y = 1;
                    break;
                }
                case "a": {
                    x = 0;
                    y = -1;
                    break;
                }
                case "d": {
                    x = 0;
                    y = 1;
                    break;
                }
                case "z": {
                    x = 1;
                    y = -1;
                    break;
                }
                case "x": {
                    x = 1;
                    y = 0;
                    break;
                }
                case "c": {
                    x = 1;
                    y = 1;
                    break;
                }
            }
            if (row + x >= table.getRow() || row + x < 0 || column + y < 0 || column + y >= table.getColumn()) { //mirar
                Interficie.printErrorVermell("El desplaçament es fa fora dels limits.\n");
                table.addCell(row, column, -sick);
                table.addTotalNoConf(sick);
            } else {
                if (table.getCell(row + x, column + y) < 0) {
                    Interficie.printErrorVermell("No es possible el desplaçament, cel·la bloquejada\n");
                } else {
                    table.addCell(row, column, -sick);
                    table.addCell(row + x, column + y, sick);
                    table.addTotalNoConf(sick);
                }
            }

        }

    }

    /**
     *
     * @param table Es la classe Taulell que ens permet tenir l'informació de la taula seleccionada
     * @param currentTable Indica el taulell actual
     * @throws IOException Ens permet capturar les exceptions de Input-Output
     */
    public void saveTable(Taulell table, int currentTable) throws IOException {
        FileWriter desti = new FileWriter("res/tables.txt", true);
        Date objDate = new Date();
        desti.append(currentTable + " " + objDate.toString() + "\n");
        desti.append(table.getNumSicks() + " " + table.getTotalHeal() + " " + table.getTotalsick() + "\n");
        desti.append(table.getColumn() + " " + table.getRow() + " " + table.getTotalNoConf() + "\n");
        for (int i = 0; i < table.getRow(); i++) {
            for (int j = 0; j < table.getColumn(); j++) {
                desti.append(table.getCell(i, j) + " ");
            }
        }
        desti.append("\n");


        desti.close();
    }

    /**
     *
     * @param table Es la classe Taulell que ens permet tenir l'informació de la taula seleccionada
     * @throws FileNotFoundException Ens permet capturar l'error de que no trobi l'arxiu
     */
    public void importTable(Taulell table) throws FileNotFoundException {
        File origen = new File("res/tables.txt");
        Scanner r = new Scanner(origen);
        int index = 1;
        Interficie.printSentenceCyan("-- Llistat de taulells guardats --\n");

        while (r.hasNextLine()) {
            System.out.println(index + ") tabla:" + r.nextLine());
            for (int i = 0; i < 3; i++) {
                r.nextLine();
            }
            index++;
        }
        int option = Utils.validateEnterLimits(Interficie.returnSentenceCyan("Seleccióna una de les seguents taules: "), 1, index) - 1;
        r.close();
        table.readTable(origen, option);
    }

    /**
     * Aquesta funcio mostra el numero de confirmats de COVID-19 de l'ultim dia a Catalunya
     * @param yesterday Es una variable que ens dona el dia d'ahir
     * @throws IOException Ens permet capturar les exceptions de Input-Output
     * @throws ParseException  Ens permet capturar l'exception de la fallada alhora de parsejar el fitxer JSON
     */
    public void querieOne(LocalDate yesterday) throws IOException, ParseException{
            URL url = new URL("https://api.covid19tracking.narrativa.com/api/" + yesterday + "/country/spain/region/cataluna");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new InputStreamReader(connection.getInputStream()));
            JSONObject total = (JSONObject) jsonObject.get("total");
            Interficie.printSentence("-- Catalunya, Espanya --" + "\nAvui confirmats: " + total.get("today_confirmed"));
            connection.disconnect();
        }

    /**
     * Aquesta funcio mostra el numero de confirmats de COVID-19 de l'ultim dia a Girona
     * @param yesterday Es una variable que ens dona el dia d'ahir
     * @throws IOException Ens permet capturar les exceptions de Input-Output
     * @throws ParseException Ens permet capturar l'exception de la fallada alhora de parsejar el fitxer JSON
     */
        public void querieTwo(LocalDate yesterday) throws IOException, ParseException {

            URL url = new URL("https://api.covid19tracking.narrativa.com/api/" + yesterday + "/country/spain/region/cataluna");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new InputStreamReader(connection.getInputStream()));
            JSONObject dates = (JSONObject) jsonObject.get("dates");
            JSONObject lastDay = (JSONObject) dates.get("" + yesterday);
            JSONObject countries = (JSONObject) lastDay.get("countries");
            JSONObject spain = (JSONObject) countries.get("Spain");
            JSONArray regions = (JSONArray) spain.get("regions");
            JSONObject regioCatalunya = (JSONObject) regions.get(0);
            JSONArray subRegions = (JSONArray) regioCatalunya.get("sub_regions");

            boolean bol = false;
            JSONObject gerona = null;
            for (int i = 0; i < subRegions.size() && bol == false; i++) {
                gerona = (JSONObject) subRegions.get(i);
                if (gerona.get("id").equals("gerona")){
                    bol = true;
                }
            }
            Interficie.printSentence("-- Girona, Espanya --" +
                    "\nAvui confirmats: " + gerona.get("today_confirmed"));
            connection.disconnect();
        }

    /**
     * Aquesta funcio mostra el total de morts de l'ultim dia a New York
     * @param yesterday Es una variable que ens dona el dia d'ahir
     * @throws IOException Ens permet capturar les exceptions de Input-Output
     * @throws ParseException Ens permet capturar l'exception de la fallada alhora de parsejar el fitxer JSON
     */
        public void querieThree(LocalDate yesterday) throws IOException, ParseException {
            long totalDeaths = 0;
            URL url = new URL("https://api.covid19tracking.narrativa.com/api/" + yesterday + "/country/US");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new InputStreamReader(connection.getInputStream()));
            JSONObject dates = (JSONObject) jsonObject.get("dates");
            JSONObject lastDay = (JSONObject) dates.get("" + yesterday);
            JSONObject countries = (JSONObject) lastDay.get("countries");
            JSONObject unitedStates = (JSONObject) countries.get("US");
            JSONArray regions = (JSONArray) unitedStates.get("regions");

            boolean bol = false;
            JSONObject newYork = null;
            for (int i = 0; i < regions.size() && bol == false; i++) {
                newYork = (JSONObject) regions.get(i);
                if (newYork.get("id").equals("new_york")){
                    bol = true;
                }
            }
            JSONArray subRegions = (JSONArray) newYork.get("sub_regions");
            JSONObject subRegio = null;
            for (int i = 0; i < subRegions.size(); i++) {
                subRegio = (JSONObject) subRegions.get(i);
                totalDeaths += (long)subRegio.get("today_deaths");
            }

            Interficie.printSentence("-- New York --" +
                    "\nAvui morts: " + totalDeaths);
            connection.disconnect();
        }

    /**
     * Aquesta funcio mostra les noves morts durant els 3 primers dies d'Abril a França
     * @throws IOException Ens permet capturar les exceptions de Input-Output
     * @throws ParseException Ens permet capturar l'exception de la fallada alhora de parsejar el fitxer JSON
     */
        public void querieFour() throws IOException, ParseException {
            long totalNewDeaths = 0;
            URL url = new URL("https://api.covid19tracking.narrativa.com/api/country/france?date_from=2020-04-01&date_to=2020-04-03");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new InputStreamReader(connection.getInputStream()));
            JSONObject dates = (JSONObject) jsonObject.get("dates");
            JSONObject firstDay = (JSONObject) dates.get("2020-04-01");
            JSONObject secondDay = (JSONObject) dates.get("2020-04-02");
            JSONObject thirdDay = (JSONObject) dates.get("2020-04-03");

            JSONObject countries = (JSONObject) firstDay.get("countries");
            JSONObject france = (JSONObject) countries.get("France");
            JSONArray regions = (JSONArray) france.get("regions");

            JSONObject regio;


            for (int i = 0; i < regions.size() -1; i++) {
                regio = (JSONObject) regions.get(i);
                Object todayNewConfirmed = regio.get("today_new_deaths");
                if (todayNewConfirmed != null) {
                    totalNewDeaths += (long)todayNewConfirmed;
                }
            }

            countries = (JSONObject) secondDay.get("countries");
            france = (JSONObject) countries.get("France");
            regions = (JSONArray) france.get("regions");

            for (int i = 0; i < regions.size() -1; i++) {
                regio = (JSONObject) regions.get(i);
                Object todayNewConfirmed = regio.get("today_new_deaths");
                if (todayNewConfirmed != null) {
                    totalNewDeaths += (long)todayNewConfirmed;
                }
            }

            countries = (JSONObject) thirdDay.get("countries");
            france = (JSONObject) countries.get("France");
            regions = (JSONArray) france.get("regions");

            for (int i = 0; i < regions.size() -1; i++) {
                regio = (JSONObject) regions.get(i);
                Object todayNewConfirmed = regio.get("today_new_deaths");
                if (todayNewConfirmed != null) {
                    totalNewDeaths += (long)todayNewConfirmed;
                }
            }

            Interficie.printSentence("-- França --" +
                    "\nEn els primers 3 dies d'Abril es van confirmar : " + totalNewDeaths + " noves morts");
            connection.disconnect();
        }


    /**
     * Aquesta funcio ens permet gestionar l'opció de les consultes API
     * @throws IOException Ens permet capturar les exceptions de Input-Output
     * @throws ParseException Ens permet capturar l'exception de la fallada alhora de parsejar el fitxer JSON
     */
        public void queries() throws IOException, ParseException {
        LocalDate now = LocalDate.now();
        now.minusDays(1);
        LocalDate yesterday = now.minusDays(1);

        switch (selectOptionTable(new String[]{"Consulta Catalunya, Espanya", "Consulta Girona, Espanya", "Morts Avui | New York", "Nous Morts 3 Primers dies d'Abril a França"})) {
            case 1: {
                querieOne(yesterday);
                break;
            }
            case 2: {
                querieTwo(yesterday);
                break;
            }
            case 3: {
                querieThree(yesterday);
                break;
            }
            case 4: {
                querieFour();
                break;
            }
        }
    }

    /**
     * Ens permet escollir entre diferents opcions
     * @param sentences Es la frase que es mostra per a escollir entre les diferents opcions
     * @return Retorna la opcio escollida
     */
    public int selectOptionTable(String[] sentences) {
        int option;
        Interficie.showOptions(sentences);
        option = Utils.validateEnterLimits(Interficie.returnSentenceCyan("Selecciona una de les seguents opcions: "), 1, sentences.length);
        return option;
    }
}
