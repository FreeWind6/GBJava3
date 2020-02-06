//Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз (порядок – ABСABСABС). Используйте wait/notify/notifyAll.
package Lesson_4.HW;

public class MainHW {
    static volatile char x = 'A';
    static Object object = new Object();

    static class currentNext implements Runnable {
        private char current;
        private char next;

        public currentNext(char current, char next) {
            this.current = current;
            this.next = next;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                synchronized (object) {
                    try {
                        while (x != current) {
                            object.wait();
                        }
                        System.out.print(current);
                        x = next;
                        object.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new currentNext('A', 'B')).start();
        new Thread(new currentNext('B', 'C')).start();
        new Thread(new currentNext('C', 'A')).start();
    }
}
