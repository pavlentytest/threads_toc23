package dev2;

public class Program {
    public static void main(String[] args) throws InterruptedException {
        //[+][-][+][-]
        MyThread thread1 = new MyThread("+");
        MyThread thread2 = new MyThread("-");
        thread1.start();
        thread2.start();

        Thread.sleep(1000);
        thread1.flag = false;
        thread1.join(); // присоед. к потоку и ждет его окончательная завершения
        printMessage("1st thread is stopped!");
    }

    public static final Object KEY = new Object();
    public static void printMessage(String message) {
        synchronized (KEY) {
            try {
                System.out.print("[");
                Thread.sleep(200);
                System.out.print(message);
                Thread.sleep(200);
                System.out.print("]");
              //  KEY.notify(); // возобн. поток, который находится в режиме ожидания
              //  KEY.wait(); // кладет поток в режим ожидания
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
class MyThread extends Thread {
    public String mess;
    public boolean flag = true;
    MyThread(String mess) {
        this.mess = mess;
    }
    @Override
    public void run() {
        while(flag) {
            Program.printMessage(this.mess);
        }
    }
}
