import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Main {
    public static void main(String[] args){

        List<User> userList = new Vector<>();
//        List<User> userList = new ArrayList<>();
//        List<User> userList = new LinkedList<>();


        Thread threadA = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= 1000; i++) {
                    userList.add(new User("이름" + i, "비번" + i));
                }
            }
        };

        Thread threadB = new Thread() {
            @Override
            public void run() {
                for (int i = 1001; i <= 2000; i++) {
                    userList.add(new User("이름" + i, "비번" + i));
                }
            }
        };

        threadA.start();
        threadB.start();

        try {
            threadA.join();
            threadB.join();
        } catch (Exception e) {
        }

        int size = userList.size();
        System.out.println("생성된 총 User 수: " + size);
    }
}
