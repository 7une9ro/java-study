import java.util.*;
import java.util.stream.Collectors;

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

        HashSet<Student> setStudent = new HashSet<>();
        Collections.addAll(setStudent, students);

        System.out.println("------ Set 불변 컬렉션 생성 ------");

        // 1. Set 컬렉션 복사해서 -> List 불변 컬렉션 생성
        Set<Student> immutableSet1 = Set.copyOf(setStudent);

        System.out.println("immutableSet1: " + System.identityHashCode(immutableSet1));
        immutableSet1.forEach(student -> System.out.println("name = " + student.getName() + ", score = " + student.getScore()));
        System.out.println();

        // 2. Set 불변 컬렉션 생성
        /*  toUnmodifiableSet()
          내부적으로 중복을 제거하는 로직이 포함되어 있음
         */
        Set<Student> immutableSet2 = Arrays.stream(students)
                .collect(Collectors.toUnmodifiableSet());

        System.out.println("immutableList2: " + System.identityHashCode(immutableSet2));
        immutableSet2.forEach(student -> System.out.println("name = " + student.getName() + ", score = " + student.getScore()));
    }
}
