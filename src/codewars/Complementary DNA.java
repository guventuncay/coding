package codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DnaStrand {
    static String makeComplement(String dna) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < dna.length(); i++) {
            switch (dna.charAt(i)) {
                case 'A' -> sb.append("T");
                case 'T' -> sb.append("A");
                case 'G' -> sb.append("C");
                case 'C' -> sb.append("G");
            }
        }
        return sb.toString();
    }

    static class DnaStrandTest {
        @Test
        public void test01() {
            assertEquals("TTTT", DnaStrand.makeComplement("AAAA"));
        }

        @Test
        public void test02() {
            assertEquals("TAACG", DnaStrand.makeComplement("ATTGC"));
        }

        @Test
        public void test03() {
            assertEquals("CATA", DnaStrand.makeComplement("GTAT"));
        }
    }
}