package my.topcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RGBStreetTest {

    protected RGBStreet solution;

    @Before
    public void setUp() {
        solution = new RGBStreet();
    }

    @Test
    public void testCase0() {
        String[] houses = new String[]{"1 100 100", "100 1 100", "100 100 1"};

        int expected = 3;
        int actual = solution.estimateCost(houses);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase1() {
        String[] houses = new String[]{"1 100 100", "100 100 100", "1 100 100"};

        int expected = 102;
        int actual = solution.estimateCost(houses);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase2() {
        String[] houses = new String[]{"26 40 83", "49 60 57", "13 89 99"};

        int expected = 96;
        int actual = solution.estimateCost(houses);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase3() {
        String[] houses = new String[]{"30 19 5", "64 77 64", "15 19 97", "4 71 57", "90 86 84", "93 32 91"};

        int expected = 208;
        int actual = solution.estimateCost(houses);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase4() {
        String[] houses = new String[]{"71 39 44", "32 83 55", "51 37 63", "89 29 100", "83 58 11", "65 13 15", "47 25 29", "60 66 19"};

        int expected = 253;
        int actual = solution.estimateCost(houses);

        Assert.assertEquals(expected, actual);
    }

}
