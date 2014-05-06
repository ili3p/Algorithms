package my.topcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TheSimilarNumbersTest {

    protected TheSimilarNumbers solution;

    @Before
    public void setUp() {
        solution = new TheSimilarNumbers();
    }

    @Test
    public void testCase0() {
        int lower = 1;
        int upper = 10;

        int expected = 1;
        int actual = solution.find(lower, upper);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase1() {
        int lower = 5;
        int upper = 511;

        int expected = 3;
        int actual = solution.find(lower, upper);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase2() {
        int lower = 5;
        int upper = 4747;

        int expected = 3;
        int actual = solution.find(lower, upper);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase3() {
        int lower = 1;
        int upper = 1000000;

        int expected = 6;
        int actual = solution.find(lower, upper);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase4() {
        int lower = 10;
        int upper = 10110;

        int expected = 3;
        int actual = solution.find(lower, upper);

        Assert.assertEquals(expected, actual);
    }

}
