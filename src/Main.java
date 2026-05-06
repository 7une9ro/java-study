import java.util.ArrayList;
import java.util.Comparator;

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
        students.add(new Student("홍길동", 60));


        System.out.println("------ 요소 정렬 전 ------");
        students.forEach(student -> System.out.println("name: " + student.getName() + ", score: " + student.getScore()));

        System.out.println("\n------ Comparable: score 정렬 ------");
        students.stream()
                .sorted()
                .forEach(student -> System.out.println("name: " + student.getName() + ", score: " + student.getScore()));

        System.out.println("\n------ Comparator: score 내림차순 정렬 ------");
        students.stream()
                .sorted((s1, s2) -> s2.getScore() - s1.getScore())
                .forEach(student -> System.out.println("name: " + student.getName() + ", score: " + student.getScore()));

        System.out.println("\n------ Comparator: score 오름차순 정렬 ------");
        students.stream()
                .sorted(Comparator.comparingInt(Student::getScore))
                .forEach(student -> System.out.println("name: " + student.getName() + ", score: " + student.getScore()));

        System.out.println("\n------ Comparator: name 오름차순 정렬 후, score 내림차순 정렬 ------");
        students.stream()
                .sorted(Comparator.comparing(Student::getName)
                        .thenComparing(Student::getScore, Comparator.reverseOrder()))
                .forEach(student -> System.out.println("name: " + student.getName() + ", score: " + student.getScore()));
    }
}
