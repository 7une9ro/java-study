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

        System.out.println("모든 학생의 성적이 반타작 이상인가? : " +
                students.stream()
                        .allMatch(student -> student.getScore() > 50));

        System.out.println("만점을 받은 학생이 한명이라도 있는가? : " +
                students.stream()
                        .anyMatch(student -> student.getScore() == 100));

        System.out.println("0점인 학생이 한명이라도 없는가? : " +
                students.stream()
                        .noneMatch(student -> student.getScore() == 0));

        System.out.println("50점 이상 받은 학생 수 : " +
                students.stream()
                        .filter(student -> student.getScore() >= 50)
                        .count());

        System.out.println("50점 이상 받은 학생들의 점수 총합 : " +
                students.stream()
                        .mapToInt(Student::getScore)
                        .filter(score -> score >= 50)
                        .sum());

        System.out.println("50점 이상 받은 학생들의 평균 점수 : " +
                students.stream()
                        .mapToInt(Student::getScore)
                        .filter(score -> score >= 50)
                        .average()
                        .orElse(0.0));

        System.out.println("학생 중 최고 점수 : " +
                students.stream()
                        .mapToInt(Student::getScore)
                        .max()
                        .orElse(0));

        System.out.println("학생 중 최저 점수 : " +
                students.stream()
                        .mapToInt(Student::getScore)
                        .min()
                        .orElse(0));

        System.out.println("가장 먼저 시험지를 제출한 학생 : " +
                students.stream()
                        .findFirst()
                        .map(Student::getName)
                        .orElse("제출자 없음"));
    }
}
