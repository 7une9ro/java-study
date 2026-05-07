import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Student implements Comparable<Student> {
    private String name; // 계명될 수도 있으니 final 키워드 제거
    private final int score; // 시험 성적은 절대로 변경되면 안되기에 final
    private final int id; // 각 학생을 구분하기 위한 고유 번호
    private static int count = 0; // 인스턴스를 생성할 때마다 id값을 자동으로 증가시키기 위한 변수

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
        this.id = count++;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {

        // 두 객체의 주소값이 같으면 당연히 같은 객체이므로 true 반환
        if (this == obj)
            return true;

        // obj 매개변수로 전달받은 객체가 Student 타입의 인스턴스라면 student 변수에 담김
        if (!(obj instanceof Student student))
            return false;

        // ** name 필드 값만 비교 **해서 객체의 동일 여부 판단
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        // name 필드를 기반으로 해시값 생성
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Student o) {
        // [오름차순 정렬]
        // 현재 객체(this)가 작으면 음수, 같으면 0, 크면 양수 반환
        return Integer.compare(this.score, o.score);

        // [내림차순 정렬]
        // 현재 객체(this)가 작으면 양수, 같으면 0, 크면 음수 반환
//        return Integer.compare(o.score, this.score);
    }

    public static List<Student> findByStudentName(List<Student> students, String findName) {

        // 만약 원본 리스트 자체가 null이면 바로 빈 리스트 반환
        if (students == null || students.isEmpty())
            return Collections.emptyList();

        return students.stream()
                .filter(student -> student.getName().equals(findName))
                .toList();
    }

    public static List<Student> findPasser(List<Student> students) {

        if (students == null || students.isEmpty())
            return Collections.emptyList();

        return students.stream()
                .filter(student -> student.getScore() >= 60)
                .toList();
    }
}
