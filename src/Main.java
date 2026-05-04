public class Main {
    public static void main(String[] args) {

        FruitBox<Fruit> fruitBox = new FruitBox<>();
        // fruitBox.add(new Object());
        fruitBox.add(new Fruit());
        fruitBox.add(new Apple());
        fruitBox.add(new Grape());

        System.out.println(fruitBox);

        /** 제한된 타입 파라미터 사용 시, 타입 파라미터(T)에는
         *  반드시 **해당 클래스**
         *  또는
         *  해당 클래스의 **자식 클래스들**만 지정 가능함
         *
         *   그 외에 경우에는 컴파일 에러 발생함
         *   Box<String> stringBox = new Box<>();
         *   FruitBox<String> stringBox = new FruitBox<>();
         */


        /** 제한된 타입 파라미터를 사용해도 객체를 생성할 때
         *  참조 변수의 타입과 생성자의 타입은 반드시 동일해야 함.
         *
         *  동일하지 않을 경우, 컴파일 에러 발생됨.
         *  Box<Fruit> fruitBox4 = new Box<Apple>();
         *
         *  다만,
         *  타입 파라미터가 동일하다면 **클래스 간의 상속**은 가능함.
         */
        Box<Fruit> fruitBox2 = new Box<>();

        fruitBox2.add(new Fruit());
        fruitBox2.add(new Apple());
        fruitBox2.add(new Grape());

        System.out.println(fruitBox2);

        Box<Fruit> fruitBox3 = new FruitBox<>(); // 다형성
        // fruitBox3.add(new Object());
        fruitBox3.add(new Fruit());
        fruitBox3.add(new Apple());
        fruitBox3.add(new Grape());

        System.out.println(fruitBox3);
    }
}
