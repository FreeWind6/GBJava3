package Lesson_7.HW;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class Task2 {
    public static void main(String[] args) throws Exception {
        Class ch = URLClassLoader.newInstance(new URL[]{
                new File("C:\\12345").toURL()}).loadClass("Lesson_7.Main");

        Constructor constructor = ch.getConstructor();
        Object ma = constructor.newInstance();

        Method[] ms = ch.getDeclaredMethods();

        for (Method o : ms) {
            if (!o.getName().equals("main")) {
                String name = o.getName();
                Class<?>[] parameterTypes = o.getParameterTypes();
                Method m = ch.getDeclaredMethod(name, parameterTypes);
                m.setAccessible(true);
                switch (name) {
                    case "isNegative":
                    case "printIsPositive":
                    case "isLeapYear":
                        m.invoke(ma, 10);
                        break;
                    case "calculate":
                        m.invoke(ma, 1, 2, 3, 4);
                        break;
                    case "checkTwoNumbers":
                        m.invoke(ma, 5, 5);
                        break;
                    case "printWelocome":
                        m.invoke(ma, "Hi!");
                        break;
                }
            }
        }
    }
}
