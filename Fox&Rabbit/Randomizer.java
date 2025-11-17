import java.util.Random;

public class Randomizer {
    private static final Random rand = new Random();
    private static boolean useShared = true;
    public static Random getRandom() {
        if (useShared) {
            return rand;
        } else {
            return new Random();
        }
    }
    
    public static void reset() {
        if(useShared) {
            rand.setSeed(20160);
        }
    }
}