import org.junit.Test;

/**
 *
 * @author kristien.vanassche
 */
public class JUnitHelper {
    @Test
    public void dummy() {}

    public static boolean zoekLijn(String data, String info) {
        String[] lijnen = data.split("\n");

        for (String lijn : lijnen) {
            if (lijn.contains(info)) {
                return true;
            }
        }

        return false;
    }

    public static boolean zoekLijn(String data, String[] cat) {
        String[] lijnen = data.split("\n");
        int aantalFound;

        for (String lijn : lijnen) {
            aantalFound = 0;

            for (String c : cat) {
                if (lijn.contains(c)) {
                    aantalFound++;
                }
            }
            if (aantalFound == cat.length) {
                return true;
            }
        }

        return false;
    }

    public static boolean zoekLijn(String data, String data1, int[] getallen) {
        String[] lijnen = data.split("\n");
        int aantalFound;

        for (String lijn : lijnen) {
            aantalFound = 0;

            for (int i : getallen) {
                if (lijn.contains("" + i)) {
                    aantalFound++;
                }
            }
            if (aantalFound == getallen.length && lijn.contains(data1)) {
                return true;
            }
        }

        return false;
    }

    public static int zoekMinimum(int[] getallen) {
        if (getallen == null || getallen.length == 0) {
            throw new IllegalArgumentException("geen getallen meegegeven");
        }

        int min = getallen[0];
        for (int i = 1; i < getallen.length; i++) {
            if (getallen[i] > min) {
                min = getallen[i];
            }
        }
        return min;
    }

    public static String[] maakRij(char[] symbolen, String[] namen) {
        String[] res = new String[symbolen.length];

        for (int i = 0; i < symbolen.length; i++) {
            res[i] = "" + symbolen[i] + '(' + namen[i] + ')';
        }

        return res;
    }
    
    public static int maakSom(int[] getallen) {
        int som = 0;
        
        for(int getal : getallen) {
            som += getal;
        }
        return som;
    }
}
