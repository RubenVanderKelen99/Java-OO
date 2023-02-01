import BarChart.BarChart;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kristien.vanassche
 */
public class JUnitTestScen_Deel4567 {
    String titel = "BarChart with 3 groups";
    String[] groepen = new String[]{"Pink", "Green", "Blue"};
    char[] symbolen = new char[]{'P','G','B'};

    String[] categorieen = {"Boys", "Girls", "Adults"};
    int[][] aantallen = { {19, 7, 14}, {15, 12, 9}, {8, 12, 20} } ;

    BarChart myChart;

    public JUnitTestScen_Deel4567() {
        myChart = new BarChart(titel, 3, categorieen);

        for (int i = 0; i < groepen.length; i++) {
            assertTrue(myChart.putGroupData(groepen[i], symbolen[i], aantallen[i]));           
            assertFalse(myChart.putGroupData(groepen[i], symbolen[i], aantallen[i])); //nok groep bestaat al
        }
        
        assertFalse(myChart.putGroupData("Yellow", symbolen[0], new int[]{15, 12, 9}));//nok symbool bestaat al
        assertFalse(myChart.putGroupData("Orange", 'O', new int[]{15, 12, 9}));//nok max 3 groepen
    }

    @Test
    public void testScen4() {
        System.out.println("Scenario 4 - meerdere groepen - data en legende");

        String data = myChart.showData();
        
        assertTrue(JUnitHelper.zoekLijn(data, new String[]{titel}));
        
        for (int i = 0; i < categorieen.length; i++) {
            int[] aantallenVoorCategorie = new int[groepen.length];
            for (int j = 0; j < groepen.length; j++) {
                    aantallenVoorCategorie[j] = aantallen[j][i];
            }
            assertTrue(JUnitHelper.zoekLijn(data, categorieen[i], aantallenVoorCategorie));
        }

        String legend = myChart.showLegend();
        assertTrue(JUnitHelper.zoekLijn(legend, JUnitHelper.maakRij(symbolen, groepen)));
    }
    
    @Test
    public void testScen5() {
        System.out.println("Scenario 5 - gegroepeerd staafdiagramma");

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
    public void testScen6() {
        System.out.println("Scenario 6 - gestapeld staafdiagramma");

        String chart = myChart.makeChart('H', true);
        
        String bar;
        
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
    public void testScen7() {
        System.out.println("Scenario 7 - gegroepeerd kolomdiagramma");

        String chart = myChart.makeChart('V', false);
        
        //https://stackoverflow.com/questions/878573/java-multiline-string
        String expectedData = String.join("",
            "      		      		    B ",	
            "P     		      		    B ",		
            "P     		      		    B "	,	
            "P     		      		    B "	,	
            "P     		      		    B "	,	
            "P G   		      		    B "	,	
            "P G   		      		P   B "	,	
            "P G   		      		P   B "	,	
            "P G   		  G B 		P   B "	,	
            "P G   		  G B 		P   B "	,	
            "P G   		  G B 		P   B "	,	
            "P G   		  G B 		P G B "	,	
            "P G B 		  G B 		P G B "	,	
            "P G B 		P G B 		P G B "	,	
            "P G B 		P G B 		P G B "	,	
            "P G B 		P G B 		P G B "	,	
            "P G B 		P G B 		P G B "	,	
            "P G B 		P G B 		P G B "	,	
            "P G B 		P G B 		P G B " ,	
            "P G B 		P G B 		P G B " );
        
        String compressedChart = chart.replaceAll(" |\t|\n", "");
        String compressedExpectedData = expectedData.replaceAll(" |\t|\n", "");
        assertTrue(compressedChart.contains(compressedExpectedData));

        assertTrue(JUnitHelper.zoekLijn(chart, categorieen));
    }
}
