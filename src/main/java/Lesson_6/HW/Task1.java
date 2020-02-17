package Lesson_6.HW;
//1. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
// Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
// идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку, иначе в методе
// необходимо выбросить RuntimeException. Написать набор тестов для этого метода (по 3-4 варианта входных данных).
// Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        int[] mass1 = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] mass2 = {1, 2, 3, 5, 4, 8, 9, 10};
        int[] mass3 = {1, 2, 3, 5, 4, 8, 9, 10, 11, 4, 5};
        int[] mass4 = {1, 2, 3, 5, 8, 9, 10, 11, 5, 6};
        Task1 task1 = new Task1();
        System.out.println(Arrays.toString(task1.method(mass1)));
        System.out.println(Arrays.toString(task1.method(mass2)));
        System.out.println(Arrays.toString(task1.method(mass3)));
        System.out.println(Arrays.toString(task1.method(mass4)));

    }

    public int[] method(int[] mass) {
        int g;
        int temp = 0;
        for (int i = mass.length; i > 0; i--) {
            if (mass != null & mass[i - 1] == 4) {
                g = i - 1;
                int[] newMass = new int[mass.length - g - 1];
                for (int j = g; j < mass.length - 1; j++) {
                    newMass[temp] = mass[j + 1];
                    temp++;
                }
                return newMass;
            }
        }
        throw new RuntimeException("Error!");
    }
}
