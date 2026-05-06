import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        Student[] students = {
                new Student("김철수", 10)
                , new Student("김수현", 20)
                , new Student("김철수", 30)
                , new Student("박짱구", 40)
                , new Student("박지구", 50)
                , new Student("홍길동", 60)
                , new Student("홍박사", 70)
                , new Student("김수현", 80)};

        HashMap<Integer, Student> mapStudent = new HashMap<>();
        int counter = 0;
        for (Student student : students) {
            mapStudent.put(counter++, student);
        }

        System.out.println("------ Map 불변 컬렉션 생성 ------");

        // 1. Map 컬렉션 복사해서 -> Map 불변 컬렉션 생성
        Map<Integer, Student> immutableMap1 = Map.copyOf(mapStudent);

        System.out.println("immutableMap1: " + System.identityHashCode(immutableMap1));
        immutableMap1.forEach((id, student) -> System.out.println("key: " + id + ", name = " + student.getName() + ", score = " + student.getScore()));
        System.out.println();

        // 2. Map 불변 컬렉션 생성
        /*  toUnmodifiableMap()
          내부적으로 중복을 제거하는 로직이 포함되어 있음
         */
        Map<Integer, Student> immutableMap2 = IntStream.range(0, students.length)
                .boxed()
                .collect(Collectors.toUnmodifiableMap(
                        i -> i,
                        i -> students[i]
                ));

        System.out.println("immutableMap2: " + System.identityHashCode(immutableMap2));
        immutableMap2.forEach((id, student) -> System.out.println("key: " + id + ", name = " + student.getName() + ", score = " + student.getScore()));
    }
}
