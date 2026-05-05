import java.util.Objects;

public class Student {
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

        // 비교하려는 객체가 존재하지 않거나 클래스 타입이 다른 경우에는 당연히 객체가 다르므로 false 반환
        if (obj == null || getClass() != obj.getClass())
            return false;

        // 위 조건들에 충족되지 않았으면 Student 객체이므로 Student 타입으로 강제 형 변환 해줌
        Student student = (Student) obj;

        // ** name 필드 값만 비교 **해서 객체의 동일 여부 판단
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        // name 필드를 기반으로 해시값 생성
        return Objects.hash(name);
    }
}
