public class Grape extends Fruit {
    private static long counter = 0;

    public Grape() {
        super("포도", ++counter);
    }
}