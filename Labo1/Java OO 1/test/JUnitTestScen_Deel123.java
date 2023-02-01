import BarChart.BarChart;

import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author kristien.vanassche
 */
public class JUnitTestScen_Deel123 {
    String titel = "Barchart with 1 group";
    
    String groep = "groep";    
    char symbool = 'B';

    String[] categorieen = new String[]{"Boys", "Girls", "Adults"};
    int[] aantallen = new int[]{12, 5, 8};

    BarChart myChart;

    public JUnitTestScen_Deel123() {
        myChart = new BarChart(titel, categorieen, groep, symbool, aantallen);
    }

    @Test
    public void testScen1() {
        System.out.println("Scenario 1 - data en legende");

        String data = myChart.showData();
        assertTrue(JUnitHelper.zoekLijn(data, new String[]{titel}));

        for (int i = 0; i < aantallen.length; i++) {
            assertTrue(JUnitHelper.zoekLijn(data, new String[]{categorieen[i], ""+aantallen[i]}));
        }

        String legend = myChart.showLegend();
        assertTrue(JUnitHelper.zoekLijn(legend, ""+symbool + '(' + groep + ')'));
    }

    @Test
    public void testScen2() {
        System.out.println("Scenario 2 - staafdiagramma");

        String chart = myChart.makeChart('H',false);  
        String bar;
        
        assertTrue(JUnitHelper.zoekLijn(chart, new String[]{titel}));
        assertTrue(JUnitHelper.zoekLijn(chart, ""+symbool + '(' + groep + ')'));
        
        for (int i = 0; i < aantallen.length; i++) {
            bar = "";
            for (int j = 0; j < aantallen[i]; j++) {
                bar += symbool;
            }
            assertTrue(JUnitHelper.zoekLijn(chart, new String[]{categorieen[i], bar}));
        }
    }

    @Test
    public void testScen3() {
        System.out.println("Scenario 3 - kolomdiagramma");

        String chart = myChart.makeChart('V',false);  
        
        assertTrue(JUnitHelper.zoekLijn(chart, new String[]{titel}));
       
        assertTrue(chart.replaceAll(" |\t|\n", "").contains(String.format("%" + JUnitHelper.maakSom(aantallen) + "s", ' ').replace(' ', symbool)));
        
        assertTrue(JUnitHelper.zoekLijn(chart, ""+symbool + '(' + groep + ')'));        
        assertTrue(JUnitHelper.zoekLijn(chart, categorieen));
    }  
}
