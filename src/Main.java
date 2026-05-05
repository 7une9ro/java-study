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


        /*  distinct(): 요소의 중복을 제거하는 메서드
         객체 Stream일 경우 내부적으로 객체의 중복을 판단할 때 두 가지 단계를 거침.
            1. hashCode() -> 2. equals()

         다만, 사용자가 직접 만든 클래스에서 equals()와 hashCode() 메서드를 오버라이딩하지 않으면
         객체의 필드 값들이 같아도 메모리 주소가 다르면 다른 객체로 판단해버림.
         */
        students.stream()
                .distinct()
                .forEach(student -> System.out.println(student.getName()));
    }
}
