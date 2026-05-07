import java.util.ArrayList;

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

        Student findStudent = students.stream()
                .filter(student -> student.getName().equals("이순신"))
                .findFirst()
                .orElse(new Student("미등록된 학생입니다", 0));

        System.out.printf("찾은 학생의 이름: %s\n찾은 학생의 점수: %d",
                findStudent.getName(), findStudent.getScore());

        System.out.println();

        students.stream()
                .filter(student -> student.getScore() == 0)
                .findFirst()
                .map(Student::getName)
                .ifPresentOrElse(
                        name -> System.out.println("0점을 받은 학생: " + name)
                        , () -> System.out.println("0점을 받은 학생이 없습니다!")
                );
    }
}
