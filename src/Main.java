import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

        ArrayList<Student> listStudent = new ArrayList<>();
        Collections.addAll(listStudent, students);

        System.out.println("------ List 불변 컬렉션 생성 ------");

        // 1. List 컬렉션 복사해서 -> List 불변 컬렉션 생성
        List<Student> immutableList1 = List.copyOf(listStudent);

        System.out.println("immutableList1: " + System.identityHashCode(immutableList1));
        immutableList1.forEach(student -> System.out.println("name = " + student.getName() + ", score = " + student.getScore()));
        System.out.println();

        /*
         .of() 메서드로 생성한 컬렉션은 수정(추가/삭제)이(가) 불가능함.
            => Immutable Collection

            RuntimeException: UnsupportedOperationException
            => students.add(new Student("김바다", 30));
         */

        // 2. List 불변 컬렉션 생성
        List<Student> immutableList2 = List.of(students);

        System.out.println("immutableList2: " + System.identityHashCode(immutableList2));
        immutableList2.forEach(student -> System.out.println("name = " + student.getName() + ", score = " + student.getScore()));
    }
}
