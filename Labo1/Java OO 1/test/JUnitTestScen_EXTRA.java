import BarChart.BarChart;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kristien.vanassche
 */
public class JUnitTestScen_EXTRA {
    String titel = "BarChart with 4 groepen en 5 categorieën";
    
    String[] groepen = {"Groep1", "Groep2", "Groep3", "Groep4"};
    char[] symbolen = {'1','2','3','4'};

    String[] categorieen = {"Cat1", "Cat2", "Cat3", "Cat4", "Cat5"};
    int[][] aantallen = { {1,1,1,1,1},{2,2,2,2,2},{3,3,3,3,3},{4,4,4,4,4} };

    BarChart myChart;

    public JUnitTestScen_EXTRA() {
        //Scenario 4 : meerdere groepen
        myChart = new BarChart(titel, groepen.length, categorieen);
        
        for (int i = 0; i < groepen.length; i++) {
            assertTrue(myChart.putGroupData(groepen[i], symbolen[i], aantallen[i]));           
        } 
        
        assertFalse(myChart.putGroupData("extra", 'x', new int[]{5,5,5,5,5}));
    }

    @Test
    public void testScen4EXTRA() {
        System.out.println("Scenario 4 EXTRA - data en legende");

        String data = myChart.showData();
        assertTrue(JUnitHelper.zoekLijn(data, new String[]{titel}));
        assertTrue(JUnitHelper.zoekLijn(data, groepen));
        
        for (int i = 0; i < categorieen.length; i++) {
            int[] aantallenVoorCategorie = new int[groepen.length];
            for (int j = 0; j < groepen.length; j++) {
                    aantallenVoorCategorie[j] = aantallen[j][i];
            }
            assertTrue(JUnitHelper.zoekLijn(data, categorieen[i], aantallenVoorCategorie));
        }

        String legend = myChart.showLegend();
        assertTrue(JUnitHelper.zoekLijn(legend, groepen));
        assertTrue(JUnitHelper.zoekLijn(legend, JUnitHelper.maakRij(symbolen, groepen)));
    }  
    
    @Test
    public void testScen5EXTRA() {
        System.out.println("Scenario 5 EXTRA - gegroepeerd staafdiagramma");

        String chart = myChart.makeChart('H', false);
        String bar = "";
        
        assertTrue(JUnitHelper.zoekLijn(chart, new String[]{titel}));
        
        for (int i = 0; i < categorieen.length; i++) {
            for (int j = 0; j < groepen.length;j++) {
                bar = "";
                for (int k = 0; k < aantallen[j][i]; k++) {
                    bar += symbolen[j];
                }
                if (j == 0) {
                    assertTrue(JUnitHelper.zoekLijn(chart, new String[]{categorieen[i], bar}));
                }
                else {
                    assertTrue(JUnitHelper.zoekLijn(chart, new String[]{bar}));
                }
            }
        }

        assertTrue(JUnitHelper.zoekLijn(chart, groepen));
        assertTrue(JUnitHelper.zoekLijn(chart, JUnitHelper.maakRij(symbolen, groepen)));
    }  
    
    @Test
    public void testScen6EXTRA() {
        System.out.println("Scenario 6 EXTRA - gestapeld staafdiagramma");

        String chart = myChart.makeChart('H', true);
        String bar = "";
        
        for (int i = 0; i < categorieen.length; i++) {
            bar = "";
            
            for (int j = 0; j < groepen.length;j++) {
                for (int k = 0; k < aantallen[j][i]; k++) {
                    bar += symbolen[j];
                }
            }
            
            assertTrue(JUnitHelper.zoekLijn(chart, new String[]{categorieen[i], bar}));
        }
    }
    
    @Test
    public void testScen7EXTRA() {
        System.out.println("Scenario 7 EXTRA - gegroepeerd kolomdiagramma");

        String chart = myChart.makeChart('V', false);
        
        String expectedData = String.join("",
            "      4 		      4 		      4 		      4 		      4 		",
            "    3 4 		    3 4 		    3 4 		    3 4 		    3 4 		",
            "  2 3 4 		  2 3 4 		  2 3 4 		  2 3 4 		  2 3 4 		",
            "1 2 3 4 		1 2 3 4 		1 2 3 4 		1 2 3 4 		1 2 3 4 		");

        String compressedChart = chart.replaceAll(" |\t|\n", "");
        String compressedExpectedData = expectedData.replaceAll(" |\t|\n", "");
        assertTrue(compressedChart.contains(compressedExpectedData));
        
        assertTrue(JUnitHelper.zoekLijn(chart, categorieen));
    }
}
