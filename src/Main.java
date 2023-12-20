public class Main {

    public static void main(String[] args) {
       /* Test mythread1 = new Test(); // 1 поток
        mythread1.start();
        Test mythread2 = new Test(); // 2 поток
        mythread2.start();
        */

        Test2 test2thread1 = new Test2();
        Test2 test2thread2 = new Test2();
        new Thread(test2thread1).start();
        new Thread(test2thread2).start();

    }
}
class Test extends Thread {
    @Override
    public void run() {
        // логика потока
        // что-то долгое по времени
    }
}
class Test2 implements Runnable {
    @Override
    public void run() {
        // логика потока
        // что-то долгое по времени
    }
}