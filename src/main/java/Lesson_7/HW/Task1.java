package Lesson_7.HW;

// 1 Создать класс, который может выполнять «тесты».
// В качестве тестов выступают классы с наборами методов с аннотациями @Test.
// Для этого у него должен быть статический метод start(), которому в качестве параметра передается или
// объект типа Class, или имя класса. Из «класса-теста» вначале должен быть запущен метод с аннотацией @BeforeSuite,
// если такой имеется. Далее запущены методы с аннотациями @Test, а по завершении всех тестов – метод с аннотацией
// @AfterSuite. К каждому тесту необходимо добавить приоритеты (int числа от 1 до 10), в соответствии с которыми будет
// выбираться порядок их выполнения. Если приоритет одинаковый, то порядок не имеет значения. Методы с аннотациями
// @BeforeSuite и @AfterSuite должны присутствовать в единственном экземпляре, иначе необходимо бросить
// RuntimeException при запуске «тестирования».

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Task1 {
    public static void start(Class cla) throws Exception {
        Class c = cla;

        Cat cat = new Cat("Name", "Color", 2);
        Method[] methods = c.getDeclaredMethods();
        int temp1 = 0;
        int temp2 = 0;
        ArrayList arrayList = new ArrayList();

        for (Method o : methods) {
            if (o.isAnnotationPresent(BeforeSuite.class) & temp1 == 0) {
                o.invoke(cat);
                temp1++;
            } else if (o.isAnnotationPresent(BeforeSuite.class) & temp1 > 0) {
                throw new RuntimeException();
            }
        }

        for (Method o : methods) {
            if (o.isAnnotationPresent(Test.class)) {
                int priority = o.getAnnotation(Test.class).priority();
                arrayList.add(priority);
//                o.invoke(cat);
            }
        }
        Collections.sort(arrayList);
        Collections.reverse(arrayList);
//        System.out.println(arrayList);

        while (arrayList.size() != 0) {
            for (Method o : methods) {
                if (o.isAnnotationPresent(Test.class)) {
                    int priority = o.getAnnotation(Test.class).priority();
                    if (arrayList.size() == 0){
                        break;
                    }
                    if (priority == (int) arrayList.get(0)) {
                        o.invoke(cat);
                        arrayList.remove(0);
                    }
                }
            }
        }

        for (Method o : methods) {
            if (o.isAnnotationPresent(AfterSuite.class) & temp2 == 0) {
                o.invoke(cat);
                temp2++;
            } else if (o.isAnnotationPresent(AfterSuite.class) & temp2 > 0) {
                throw new RuntimeException();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        start(Cat.class);
    }
}
