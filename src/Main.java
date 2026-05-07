import java.util.ArrayList;
import java.util.NoSuchElementException;

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

        try {
            Student findStudent = Student.findById(students, 10)
                    .orElseThrow(() ->
                            new NoSuchElementException("해당 ID를 가진 학생은 존재하지 않습니다."));

            System.out.printf("ID가 %d인 학생의 이름: %s\n"
                    , findStudent.getId(), findStudent.getName());

        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
        }
    }
}
