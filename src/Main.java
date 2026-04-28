import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            list.add(i);
        }

//        Stream<Integer> singleThreadStream = list.stream();
//        singleThreadStream.forEach((value) -> {
//            Thread thread = Thread.currentThread();
//            System.out.println(thread.getName() + ": " + value);
//        });

        Stream<Integer> multiThreadStream = list.parallelStream();
        multiThreadStream.forEach((value) -> {
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName() + ": " + value);
        });
    }
}
