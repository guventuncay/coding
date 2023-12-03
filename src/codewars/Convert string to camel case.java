package codewars;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution {

    static String toCamelCase(String s) {
        String[] split = s.split("[_-]");
        return Arrays.stream(split)
                .reduce((a, b) -> a.concat(b.substring(0, 1).toUpperCase().concat(b.substring(1))))
                .get();
    }
}

class SolutionTest {
    @Test
    public void testSomeUnderscoreLowerStart() {
        String input = "the_Stealth_Warrior";
        System.out.println("input: " + input);
        assertEquals("theStealthWarrior", Solution.toCamelCase(input));
    }

    @Test
    public void testSomeDashLowerStart() {
        String input = "the-Stealth-Warrior";
        System.out.println("input: " + input);
        assertEquals("theStealthWarrior", Solution.toCamelCase(input));
    }
}