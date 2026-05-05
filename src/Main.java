import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("김철수", 10));
        students.add(new Student("김수현", 20));
        students.add(new Student("김철수", 30));
        students.add(new Student("박짱구", 40));
        students.add(new Student("박지구", 50));
        students.add(new Student("홍길동", 60));
        students.add(new Student("홍박사", 70));
        students.add(new Student("김수현", 80));
        System.out.println("---------------");


        /// '홍'씨인 학생 요소만 필터링
        students.stream()
                .map(Student::getName)
                .filter(name -> name.startsWith("홍"))
                .forEach(System.out::println);

        System.out.println("---------------");

        /// 중복 요소를 제거하고나서 '김'씨인 학생 요소만 필터링
        students.stream().distinct()
                .map(Student::getName)
                .filter(name -> name.startsWith("김"))
                .forEach(System.out::println);
    }
}
