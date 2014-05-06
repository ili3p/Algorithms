package my.topcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShuffleSortTest {

    protected ShuffleSort solution;

    @Before
    public void setUp() {
        solution = new ShuffleSort();
    }

    public static void assertEquals(double expected, double actual) {
        if (Double.isNaN(expected)) {
            Assert.assertTrue("expected: <NaN> but was: <" + actual + ">", Double.isNaN(actual));
            return;
        }
        double delta = Math.max(1e-9, 1e-9 * Math.abs(expected));
        Assert.assertEquals(expected, actual, delta);
    }

    @Test
    public void testCase0() {
        int[] cards = new int[]{1};

        double expected = 1.0;
        double actual = solution.shuffle(cards);

        assertEquals(expected, actual);
    }

    @Test
    public void testCase1() {
        int[] cards = new int[]{1, 2};

        double expected = 2.0;
        double actual = solution.shuffle(cards);

        assertEquals(expected, actual);
    }

    @Test
    public void testCase2() {
        int[] cards = new int[]{2, 3, 1};

        double expected = 4.0;
        double actual = solution.shuffle(cards);

        assertEquals(expected, actual);
    }

    @Test
    public void testCase3() {
        int[] cards = new int[]{15, 16, 4, 8, 42, 23};

        double expected = 16.0;
        double actual = solution.shuffle(cards);

        assertEquals(expected, actual);
    }

    @Test
    public void testCase4() {
        int[] cards = new int[]{1, 1, 1, 1, 1, 1, 1, 1};

        double expected = 1.0;
        double actual = solution.shuffle(cards);

        assertEquals(expected, actual);
    }

}
