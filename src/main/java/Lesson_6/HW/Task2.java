package Lesson_6.HW;

//2. Написать метод, который проверяет состав массива из чисел 1 и 4.
// Если в нем нет хоть одной четверки или единицы, то метод вернет false;
// Написать набор тестов для этого метода (по 3-4 варианта входных данных).
public class Task2 {
    public static void main(String[] args) {
        Task2 task2 = new Task2();
        int[] mass1 = {1, 2, 3, 5, 6, 7, 8, 9};
        int[] mass2 = {4, 2, 3, 5, 6, 7, 8, 9};
        int[] mass3 = {2, 3, 5, 6, 7, 8, 9};
        boolean method1 = task2.method(mass1);
        boolean method2 = task2.method(mass2);
        boolean method3 = task2.method(mass3);
        System.out.println(method1);
        System.out.println(method2);
        System.out.println(method3);
    }

    public boolean method(int[] mass) {
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] == 4 | mass[i] == 1) {
                return true;
            }
        }
        return false;
    }
}
