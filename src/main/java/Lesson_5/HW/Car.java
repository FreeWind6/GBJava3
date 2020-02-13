package Lesson_5.HW;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class Car implements Runnable {
    private static int CARS_COUNT;

    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;
    private CyclicBarrier cyclicBarrier;
    private CountDownLatch countDownLatch;
    private AtomicInteger atomicInteger;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CyclicBarrier cyclicBarrier, CountDownLatch countDownLatch, AtomicInteger atomicInteger) {
        this.race = race;
        this.speed = speed;
        this.cyclicBarrier = cyclicBarrier;
        this.countDownLatch = countDownLatch;
        this.atomicInteger = atomicInteger;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        countDownLatch.countDown();
        int finishPlace = atomicInteger.incrementAndGet();
        if (finishPlace == 1) {
            System.out.println(this.name + " - WIN!");
        }
    }
}
