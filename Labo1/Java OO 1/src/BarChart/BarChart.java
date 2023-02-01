package BarChart;

import java.util.Scanner;

/**
 * Documentatie van de klasse
 *
 * @author Ruben Van der Kelen
 * @version december 2018
 */
public class BarChart {

    /**
     * de titel van je bar chart
     */
    final String TITLE;

    /**
     * het maximum aantal groepen
     */
    final int NRGROUPS;

    /**
     * een array van Strings
     */
    String[] categories;

    /**
     *
     */
    int[][] data; // de data van alle groepen wordt bijgehouden in een 2dim array van integer getallen

    /**
     * de namen van de groepen worden bijgehouden in een array van Strings
     */
    String[] groups;

    /**
     * de symbolen waarmee een groep wordt aangeduid worden bijgehouden in een
     * array van chars
     */
    char[] symbols;

    /**
     * Constructor methode bij 1 groep
     *
     * @param title de titel van de bar chart
     * @param categories de categorieen van de bar chart
     * @param groupName de naam van de groep (hier maar 1 groep)
     * @param symbol het symbool van de groep
     * @param data de data van de groepen
     */
    public BarChart(String title, String[] categories, String groupName,
            char symbol, int[] data) {
        this.NRGROUPS = 1;
        this.TITLE = title;
        this.categories = categories;
        this.data = new int[NRGROUPS][data.length];
        for (int i = 0; i < data.length; i++) {
            this.data[0][i] = data[i];
        }
        this.groups = new String[NRGROUPS];
        this.groups[0] = groupName;
        this.symbols = new char[NRGROUPS];
        this.symbols[0] = symbol;
    }

    /**
     * Constructor methode bij meerdere groepen: de namen, symbolen en de data
     * van de groepen moeten ingegeven worden dmv. methode putGroupData
     *
     * @param title de titel van de bar chart
     * @param nrGroups het aantal in te geven groepen (dmv. methode
     * putGroupData)
     * @param categories de categorieen van de bar chart
     */
    public BarChart(String title, int nrGroups, String[] categories) {
        this.TITLE = title;
        this.NRGROUPS = nrGroups;
        this.categories = categories;
        this.data = new int[NRGROUPS][categories.length];
        this.groups = new String[NRGROUPS];
        for (int i = 0; i < NRGROUPS; i++) {
            this.groups[i] = "";
        }
        this.symbols = new char[NRGROUPS];
        this.data = new int[NRGROUPS][categories.length];
    }

    /**
     * Methode om naam, symbool en data van een bepaald aantal groepen (bepaald
     * door nrGroups parameter vd. constructor methode) in te geven. Deze kijkt
     * ook na of er aan bepaalde voorwaarden voldaan wordt.
     *
     * @param groupName de naam van de groep
     * @param symbol het symbool van de groep
     * @param data de data van de groepen
     * @return true of false (voorwaarden)
     */
    public boolean putGroupData(String groupName, char symbol, int[] data) {
        boolean groupAllowed = true;
        int groupsToFill = NRGROUPS;
        String allGroups = "";
        for (int i = 0; i < NRGROUPS; i++) {
            if (groups[i] != "") {
                groupsToFill--;
            } else {

            }
        }
        for (int j = 0; j < NRGROUPS; j++) {
            if (groups[j].equals(groupName)) {
                groupAllowed = false;
            } else if (symbols[j] == (symbol)) {
                groupAllowed = false;
            } else if (groupsToFill == 0) {
                groupAllowed = false;
            } else {
            }

        }
        if (groupAllowed) {
            for (int k = 0; k < NRGROUPS; k++) {
                if (k == 0 && groups[k] == "") {
                    this.groups[k] = groupName;
                    this.data[k] = data;
                    symbols[k] = symbol;
                    allGroups = allGroups + groups[k] + " ";
                } else if (k > 0 && groups[k] == "" && !allGroups.contains(groupName)) {
                    this.groups[k] = groupName;
                    this.data[k] = data;
                    symbols[k] = symbol;
                    allGroups = allGroups + groups[k] + " ";
                } else {

                }
            }
        }

        return groupAllowed;
    }

    /**
     * Deze methode geeft de categorieen met hun data in onze barchart weer
     *
     * @return Een String met de categorieen en hun data van de bar chart
     */
    public String showData() {
        String show = "";
        for (int i = 0; i < NRGROUPS; i++) {
            show = "\n" + show + "\t" + groups[i];
        }
        for (int i = 0; i < categories.length; i++) {
            show = show + "\n" + categories[i];
            for (int j = 0; j < groups.length; j++) {
                show = show + "\t" + data[j][i];
            }
        }
        return "Title: " + TITLE + "\nData: " + show;
    }

    /**
     * Deze methode geeft de legende voor een getekend diagram weer.
     *
     * @return Een String met de legende van het diagram
     */
    public String showLegend() {
        String show = "";
        for (int i = 0; i < NRGROUPS; i++) {
            show = show + symbols[i] + "(" + groups[i] + ") ";
        }
        return "\nLegend: " + show;
    }

    /**
     * Deze methode berekend de maximum waarde van de data
     *
     * @param tabel tabel om in op te zoeken
     * @return De maximumwaarde in de tabel
     */
    private int maxValueTable(int[][] tabel) {
        tabel = data;
        int maxValue = 0;
        for (int i = 0; i < tabel.length; i++) {
            for (int j = 0; j < tabel[i].length; j++) {
                if (tabel[i][j] > maxValue) {
                    maxValue = tabel[i][j];
                }
            }
        }
        return maxValue;
    }

    /**
     * Deze methode tekent een diagram
     *
     * @param orientation bepaalt of het een kolom- of staafdiagram is
     * @param stacked bepaalt of het diagram gestapeld is
     * @return Een kolom- of staafdiagram v/d barchart, al dan niet gestapeld
     */
    public String makeChart(char orientation, boolean stacked) {
        String chart = "\n" + "Title: " + TITLE + "\n";
        if (orientation == 'H' && stacked == false) {
            for (int i = 0; i < categories.length; i++) {
                chart = chart + "\n" + categories[i] + "\t";
                for (int j = 0; j < groups.length; j++) {
                    for (int k = 0; k < data[j][i]; k++) {
                        chart = chart + symbols[j];
                    }
                    chart = chart + "\n" + "\t";
                }
            }
            chart = chart + showLegend();
            return chart;
        }
        if (orientation == 'H' && stacked == true) {
            for (int i = 0; i < categories.length; i++) {
                chart = chart + "\n" + categories[i] + "\t";
                for (int j = 0; j < groups.length; j++) {
                    for (int k = 0; k < data[j][i]; k++) {
                        chart = chart + symbols[j];
                    }
                }
            }
            chart = chart + showLegend();
            return chart;
        }
        if (orientation == 'V' && stacked == false) {
            int max = this.maxValueTable(data);
            for (int i = 0; i < max; max--) {
                for (int j = 0; j < categories.length; j++) {
                    for (int k = 0; k < groups.length; k++) {
                        if (data[k][j] >= max) {
                            chart = chart + symbols[k] + " ";
                        } else {
                            chart = chart + "  ";
                        }
                    }
                    chart = chart + "\t";
                }
                chart = chart + "\n";
            }
            for (int i = 0; i < categories.length; i++) {
                chart = chart + categories[i] + "\t";
            }
            chart = chart + showLegend();
            return chart;
        }
        return chart;
    }
}
