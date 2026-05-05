public class Fruit {
    private final long id;
    private final String item;

    public Fruit(String item, long counter) {
        this.id = counter;
        this.item = item;
    }

    public String toString() {
        return item + " " + id;
    }
}