// 2. Написать метод, который преобразует массив в ArrayList;
package Lesson_1.Tasks.Task2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] iMass = new Integer[5];

        for (int i = 0; i < iMass.length; i++) {
            iMass[i] = i;
        }

        ArrayList arrayList = new ArrayList();

        System.out.println(Arrays.toString(iMass));
        intToArrayList(iMass, arrayList);
        System.out.println(arrayList);
    }

    private static void intToArrayList(Integer[] mass, ArrayList arrayList) {
        for (int i = 0; i < mass.length; i++) {
            arrayList.add(mass[i]);
        }
    }
}
