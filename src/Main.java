import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("박지구", 50));
        students.add(new Student("김철수", 30));
        students.add(new Student("김수현", 80));
        students.add(new Student("김수현", 20));
        students.add(new Student("홍박사", 70));
        students.add(new Student("김철수", 10));
        students.add(new Student("박짱구", 40));
        students.add(new Student("홍길동", 100));

//        List<Student> findStudents = Student.findByStudentName(students, "김수현");
        List<Student> findStudents = Student.findByStudentName(students, "이순신");

        System.out.println("\n------ 실습 1 - 방식 (1) ------");
        if (findStudents.isEmpty())
            System.out.println("해당 이름을 가진 학생은 존재하지 않습니다.");
        else
            findStudents.forEach(student ->
                    System.out.println(String.format("찾은 학생의 이름과 점수: %s, %d",
                            student.getName(), student.getScore())));

        System.out.println("\n------ 실습 1 - 방식 (2) ------");
        Optional.of(findStudents)
                .filter(list -> !list.isEmpty())
                .ifPresentOrElse(
                        list -> list.forEach(student ->
                                System.out.println(String.format("찾은 학생의 이름과 점수: %s, %d",
                                        student.getName(), student.getScore()))),
                        () -> System.out.println("해당 이름을 가진 학생은 존재하지 않습니다.")
                );
    }
}
