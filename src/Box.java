import java.util.ArrayList;

public class Box<T extends Fruit> {
    ArrayList<T> boxes = new ArrayList<>();

    void add(T item) {
        this.boxes.add(item);
    }

    T get(int i) {
        return (T)this.boxes.get(i);
    }

    int size() {
        return this.boxes.size();
    }

    public ArrayList<T> getBoxes() {
        return this.boxes;
    }

    public String toString() {
        return this.boxes.toString();
    }
}
