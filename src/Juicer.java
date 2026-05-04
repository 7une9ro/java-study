public class Juicer {
    public static void makeJuice(Box<? extends Fruit> box) {
        for (Fruit fruit : box.getBoxes()) {
            System.out.println(fruit.toString() + " Juice");
        }
    }
}
