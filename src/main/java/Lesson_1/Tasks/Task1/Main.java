// 1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
package Lesson_1.Tasks.Task1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = new Integer[2];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        System.out.println(Arrays.toString(arr));
        toSwap(arr, 0, 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void toSwap(Object[] arr, int i1, int i2) {
        Object temp1 = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp1;
    }
}
