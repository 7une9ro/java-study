import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Box<String> box = new Box<>();

        // box.setItem(new Object()); <- **컴파일** 에러 발생!
        box.setItem("ABC");

        String item = box.getItem(); // 형 변환이 필요없음
    }
}
