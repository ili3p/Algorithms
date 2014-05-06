package my.topcoder;
import my.topcoder.BallsSeparating;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BallsSeparatingTest {

    protected BallsSeparating solution;

    @Before
    public void setUp() {
        solution = new BallsSeparating();
    }

    @Test
    public void testCase0() {
        int[] red = new int[]{1, 1, 1};
        int[] green = new int[]{1, 1, 1};
        int[] blue = new int[]{1, 1, 1};

        int expected = 6;
        int actual = solution.minOperations(red, green, blue);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase1() {
        int[] red = new int[]{5};
        int[] green = new int[]{6};
        int[] blue = new int[]{8};

        int expected = -1;
        int actual = solution.minOperations(red, green, blue);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase2() {
        int[] red = new int[]{4, 6, 5, 7};
        int[] green = new int[]{7, 4, 6, 3};
        int[] blue = new int[]{6, 5, 3, 8};

        int expected = 37;
        int actual = solution.minOperations(red, green, blue);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase3() {
        int[] red = new int[]{7, 12, 9, 9, 7};
        int[] green = new int[]{7, 10, 8, 8, 9};
        int[] blue = new int[]{8, 9, 5, 6, 13};

        int expected = 77;
        int actual = solution.minOperations(red, green, blue);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase4() {
        int[] red = new int[]{842398, 491273, 958925, 849859, 771363, 67803, 184892, 391907, 256150, 75799};
        int[] green = new int[]{268944, 342402, 894352, 228640, 903885, 908656, 414271, 292588, 852057, 889141};
        int[] blue = new int[]{662939, 340220, 600081, 390298, 376707, 372199, 435097, 40266, 145590, 505103};

        int expected = 7230607;
        int actual = solution.minOperations(red, green, blue);

        Assert.assertEquals(expected, actual);
    }

}
