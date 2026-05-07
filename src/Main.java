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

        List<Student> passers = Student.findPasser(students);

        System.out.println("\n------ 실습 2 - 방식 (1) ------");
        if (passers.isEmpty())
            System.out.println("합격자가 존재하지 않습니다.");
        else
            passers.forEach(student ->
                    System.out.println("Id: " + student.getId() + ", 합격자: " + student.getName()));

        System.out.println("\n------ 실습 2 - 방식 (2) ------");
        Optional.of(passers)
                .filter(list -> !list.isEmpty())
                .ifPresentOrElse(
                        (list -> list.forEach(student ->
                                System.out.println("Id: " + student.getId() + ", 합격자: " + student.getName())))
                        , () -> System.out.println("합격자가 존재하지 않습니다.")
                );
    }
}
