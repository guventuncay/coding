package codewars;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Xbonacci {

    double[] tribonacci(double[] s, int n) {
        double[] ints = Arrays.copyOf(s, n);
        for (int i = 3; i < ints.length; i++) {
            ints[i] = ints[i - 1] + ints[i - 2] + ints[i - 3];
        }
        return ints;
    }

    static class XbonacciTest {
        private Xbonacci variabonacci;

        @BeforeEach
        public void setUp() {
            variabonacci = new Xbonacci();
        }

        @AfterEach
        public void tearDown() {
            variabonacci = null;
        }

        private double precision = 1e-10;

        @Test
        public void sampleTests() {
            assertArrayEquals(new double[]{1, 1, 1, 3, 5, 9, 17, 31, 57, 105}, variabonacci.tribonacci(new double[]{1, 1, 1}, 10), precision);
            assertArrayEquals(new double[]{0, 0, 1, 1, 2, 4, 7, 13, 24, 44}, variabonacci.tribonacci(new double[]{0, 0, 1}, 10), precision);
            assertArrayEquals(new double[]{0, 1, 1, 2, 4, 7, 13, 24, 44, 81}, variabonacci.tribonacci(new double[]{0, 1, 1}, 10), precision);
        }
    }

}