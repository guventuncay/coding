package codewars;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Conversion {

    public static void main(String[] args) {
        int num = 444;
        System.out.println("solution(num) = " + solution(num));
    }

    private static final TreeMap<Integer, String> MAP;

    static {
        MAP = new TreeMap<>(Collections.reverseOrder());
        MAP.put(1, "I");
        MAP.put(4, "IV");
        MAP.put(5, "V");
        MAP.put(9, "IX");
        MAP.put(10, "X");
        MAP.put(40, "XL");
        MAP.put(50, "L");
        MAP.put(90, "XC");
        MAP.put(100, "C");
        MAP.put(400, "CD");
        MAP.put(500, "D");
        MAP.put(900, "CM");
        MAP.put(1000, "M");
    }

    public static String solution(int n) {
        StringBuilder builder = new StringBuilder();
        for (var entry : MAP.entrySet()) {
            int i = entry.getKey();
            String s = entry.getValue();
            while (n >= i) {
                builder.append(s);
                n -= i;
            }
        }
        return builder.toString();
    }

    static class ConversionTest {
        private final Conversion conversion = new Conversion();

        @Test
        public void shouldConvertToRoman() {
            assertEquals("MMM", conversion.solution(3000));

            assertEquals("I", conversion.solution(1));
            assertEquals("IV", conversion.solution(4));
            assertEquals("VI", conversion.solution(6));
        }
    }

}