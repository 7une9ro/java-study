import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("홍길동", 10)
                , new Student("김철수", 20)
                , new Student("박짱구", 30)
        );


        /*  1. Stream 객체 생성
         *
         * { "홍길동", 10 }
         * { "김철수", 20 }
         * { "박짱구", 30 }
         */
        Stream<Student> studentStream = students.stream();


        /*  2. 중간 처리
         *  Student 객체가 가지고 있는 score를 뽑아서 Integer 요소들을 담는 Stream으로 변환
         *
         * { "홍길동", 10 } -> 10
         * { "김철수", 20 } -> 20
         * { "박짱구", 30 } -> 30
         */
        IntStream scoreStream = studentStream.mapToInt(Student::getScore);

        /*  3. 최종 처리
         *  scoreStream에 들어있는 Integer 요소들의 평균 값을 계산 (집계 처리)
         */
        double avgScore = scoreStream.average().orElse(0.0);

        System.out.println("avgScore = " + avgScore);


        // 메서드 체이닝 방식
        double avgScore2 = students.stream()
                .mapToInt(Student::getScore)
                .average()
                .orElse(0.0);

        System.out.println("avgScore2 = " + avgScore2);
    }
}
