import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        // List
        ArrayList<String> strList = new ArrayList<>();
        strList.add("홍길동");
        strList.add("김철수");
        strList.add("박짱구");

        System.out.println("--------List--------");

        // 1. 기본 for문 (외부 반복자)
        for (int i = 0; i < strList.size(); i++) {
            String name = strList.get(i);
            System.out.println(name);
        }

        // 2. 향상된 for문 (외부 반복자)
        for (String name : strList) {
            System.out.println(name);
        }

        // Set
        HashSet<String> strSet = new HashSet<>();
        strSet.add("홍길동");
        strSet.add("김철수");
        strSet.add("박짱구");

        System.out.println("--------Set--------");

        // 1. Iterator (외부 반복자)
        Iterator<String> iterator = strSet.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }

        // 2. 향상된 for문 (외부 반복자)
        for (String name : strSet) {
            System.out.println(name);
        }

        System.out.println("--------Stream--------");

        // Stream - List
        Stream<String> listStream = strList.stream();

        System.out.println("--------List--------");
        listStream.forEach(name -> System.out.println(name));

        /*
         * 메서드 참조 방식으로 위의 람다식이 더 축약된 형태임
         * `listStream.forEach(System.out::println);`
         *
         *  [참고!]
         *  stream()을 통해 얻은 Stream 객체는 재사용이 불가능하기 때문에
         *  새로운 Stream을 다시 생성해야 함.
         */

        Stream<String> listStream2 = strList.stream();
        listStream2.forEach(System.out::println);

        // Stream - Set
        Stream<String> setStream = strSet.stream();

        System.out.println("--------Set--------");
        setStream.forEach(name -> System.out.println(name));

        Stream<String> setStream2 = strSet.stream();
        setStream2.forEach(System.out::println);
    }
}
