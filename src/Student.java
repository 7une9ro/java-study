import java.util.Objects;

public class Student implements Comparable<Student> {
    private final String name;
    private final int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
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
}
