public class Main {

    // 쓰레드가 공유할 객체
    private static final Object lock = new Object();
    private static boolean isMainTurn = true;

    public static void main(String[] args){
        Thread taskThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                synchronized (lock) {
                    try {
                        while (isMainTurn) {
                            lock.wait();
                        }
                        System.out.println("Task 쓰레드");

                        isMainTurn = true;
                        lock.notifyAll();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });

        taskThread.start();

        // Main 쓰레드
        for (int i = 0; i < 5; i++) {
            synchronized (lock) {
                try {
                    while (!isMainTurn) {
                        lock.wait();
                    }
                    System.out.println("Main 쓰레드");

                    isMainTurn = false;
                    lock.notifyAll();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
