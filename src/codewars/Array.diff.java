package codewars;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Kata {

    public static int[] arrayDiff(int[] a, int[] b) {
        return Arrays.stream(a).filter(e -> IntStream.of(b).noneMatch(x -> x == e)).boxed().mapToInt(e -> e).toArray();
    }

    static class SolutionTest {

        @Test
        public void sampleTests() {
            assertArrayEquals(new int[]{2}, Kata.arrayDiff(new int[]{1, 2}, new int[]{1}));
            assertArrayEquals(new int[]{2, 2}, Kata.arrayDiff(new int[]{1, 2, 2}, new int[]{1}));
            assertArrayEquals(new int[]{1}, Kata.arrayDiff(new int[]{1, 2, 2}, new int[]{2}));
            assertArrayEquals(new int[]{1, 2, 2}, Kata.arrayDiff(new int[]{1, 2, 2}, new int[]{}));
            assertArrayEquals(new int[]{}, Kata.arrayDiff(new int[]{}, new int[]{1, 2}));
        }

    }
}

