public class Main {
    public static void main(String[] args){
        SumThread sumThread = new SumThread();
        sumThread.start();

        try {
            sumThread.join();
        } catch (InterruptedException e) {
        }

        System.out.println("1~100까지의 합: " + sumThread.getSum());
    }
}
