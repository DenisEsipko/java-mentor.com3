import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * arab to roman converter
 */

public class ArabicToRoman {
    /**
     * arab to roman converter
     * @param arabic input aram namber
     * @return roman numerals string
     */
    public static String arabicToRoman(int arabic){
        String stringRoman= null;

        Map<Integer,String> map = new HashMap<>();
        map.put(1,"I");
        map.put(2,"II");
        map.put(3,"III");
        map.put(4,"IV");
        map.put(5,"V");
        map.put(6,"VI");
        map.put(7,"VII");
        map.put(8,"VIII");
        map.put(9,"IX");
        map.put(10,"X");
        // frize map
        map = Collections.unmodifiableMap(map);

        stringRoman = map.get(arabic);

        return  stringRoman;
    }
}
