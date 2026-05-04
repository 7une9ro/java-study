public class Main {
    public static void main(String[] args) {
        Box<Fruit> fruitBox = new FruitBox<>();
        fruitBox.add(new Apple());
        fruitBox.add(new Grape());
        fruitBox.add(new Apple());
        fruitBox.add(new Grape());

        /*
         * `makeJuice(Box<? extends Fruit> box)` 메서드 호출 시
         *  타입 파라미터는 Fruit와 그 자식 타입만 지정 가능함.
         */

        // `makeJuice(Box<? extends Fruit> box)` <- new FruitBox<Fruit>();
        Juicer.makeJuice(fruitBox);


        Box<Apple> appleBox = new FruitBox<>();
        appleBox.add(new Apple());
        appleBox.add(new Apple());

        // `makeJuice(Box<? extends Fruit> box)` <- new FruitBox<Apple>();
        Juicer.makeJuice(appleBox);
    }
}
