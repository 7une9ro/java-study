public class Main {
    public static void main(String[] args){
        Thread mainThread = Thread.currentThread();
        mainThread.setName("Main 쓰레드");
        System.out.println(mainThread.getName());

        for (int i = 0; i < 3; i++) {
            Thread threadA = new Thread() {
                @Override
                public void run() {
                    setName("A 쓰레드");
                    System.out.println(getName());
                }
            };
            threadA.start();
        }

        Thread threadB = new Thread() {
            @Override
            public void run() {
                System.out.println(getName());
            }
        };

        threadB.setName("B 쓰레드");
        threadB.start();
    }
}
