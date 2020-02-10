//Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз (порядок – ABСABСABС). Используйте wait/notify/notifyAll.
package Lesson_4.HW;

public class MainHW {
    static volatile String startA = "A";
    static Object object = new Object();

    static class currentNext implements Runnable {
        private String current;
        private String next;

        public currentNext(String current, String next) {
            this.current = current;
            this.next = next;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                synchronized (object) {
                    try {
                        while (!startA.equals(current)) {
                            object.wait();
                        }
                        System.out.print(current);
                        startA = next;
                        object.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new currentNext("A", "B")).start();
        new Thread(new currentNext("B", "C")).start();
        new Thread(new currentNext("C", "A")).start();
    }
}
