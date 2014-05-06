package my.topcoder;
public class PlatypusDuckAndBeaver {

    public int minimumAnimals(int webbedFeet, int duckBills, int beaverTails) {
        int x2 = webbedFeet / 2 - 2 * beaverTails, x1 = beaverTails - duckBills
                + x2, x3 = duckBills - x2;
        return x1 + x2 + x3;
    }

}
