public class Apple extends Fruit {
    private static long counter = 0;

    public Apple() {
        super("사과", ++counter);
    }
}
