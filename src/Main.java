import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
    /** 컴파일 에러:
     *   제네릭 타입 간에는 상속 안됨.
     *   Box<Grape> grapeBox = new Box<Apple>();
     */

        Box<Fruit> fruitBox = new Box<>();
    /** 컴파일 에러:
     *   제네릭 클래스를 인스턴스화 할 때, 지정된 타입은
     *   자기 자신과 자식 클래스들만 담을 수 있음
     *   fruitBox.add(new Object());
     */
        fruitBox.add(new Fruit());
        fruitBox.add(new Apple()); // 다형성
        fruitBox.add(new Grape()); // 다형성

        System.out.println(fruitBox);

        Box<Apple> appleBox = new Box<>();

        // appleBox.add(new Object());
        // appleBox.add(new Fruit());
        appleBox.add(new Apple());
        // appleBox.add(new Grape());

        System.out.println(appleBox);

    /** 타입 파라미터가 동일하다면,
     *   제네릭 클래스 간의 상속 관계는 일반적인 클래스 상속과 똑같이 적용되지만,
     *   그렇지 않을 경우에는 컴파일 에러 발생됨
     *   Box<Fruit> appleBox2 = new Box<Apple>();
     */
        Box<Fruit> fruitBox2 = new FruitBox<>(); // 다형성
        fruitBox2.add(new Fruit());
        fruitBox2.add(new Apple());
        fruitBox2.add(new Grape());

        System.out.println(fruitBox2);
    }
}
