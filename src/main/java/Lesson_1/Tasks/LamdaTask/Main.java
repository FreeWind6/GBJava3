// Сделать методы для калькулятора (сложение двух чисел, деление и умножение) через лямбду
package Lesson_1.Tasks.LamdaTask;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое целое число:");
        double s1 = scanner.nextInt();
        System.out.println("Введите второе целое число:");
        double s2 = scanner.nextInt();
        System.out.println("Введите знак между ними:");
        String s3 = scanner.next();

        Operationable operationable;

        if (s3.equals("+")) {
            operationable = (x, y) -> x + y;
        } else if (s3.equals("/")) {
            operationable = (x, y) -> x / y;
        } else if (s3.equals("*")) {
            operationable = (x, y) -> x * y;
        } else {
            System.out.println("Я тебя не понимаю!");
            return;
        }

        double res = operationable.calculate(s1, s2);
        System.out.println("Ответ: " + res);
    }
}

interface Operationable {
    double calculate(double x, double y);
}
