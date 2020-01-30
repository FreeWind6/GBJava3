package Lesson_1.Tasks.Task3;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
    ArrayList<T> arrayList;

    public Box(T... arrayList) {
        this.arrayList = new ArrayList<>(Arrays.asList(arrayList));
    }

    public float getWeight() {
        if (arrayList.size() == 0) return 0;
        float weight = 0;
        for (T arr : arrayList) weight += arr.getWeight();
        return weight;
    }

    public boolean compare(Box box) {
        return this.getWeight() == box.getWeight();
    }

    public void trans(Box<? super T> box) {
        box.arrayList.addAll(this.arrayList);
        arrayList.clear();
    }

    public void add(T... arr) {
        this.arrayList.addAll(Arrays.asList(arr));
    }

    public void remove(T... arrs) {
        for (T arr : arrs) this.arrayList.remove(arr);
    }
}
