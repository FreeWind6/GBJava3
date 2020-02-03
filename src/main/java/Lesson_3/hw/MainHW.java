//1)Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;
//2)Последовательно сшить 5 файлов в один (файлы примерно 100 байт). Может пригодиться следующая конструкция: ArrayList<InputStream> al = new ArrayList<>(); ... Enumeration<InputStream> e = Collections.enumeration(al);
//3)Написать консольное приложение, которое умеет постранично читать текстовые файлы (размером > 10 mb). Вводим страницу (за страницу можно принять 1800 символов), программа выводит ее в консоль.
//Контролируем время выполнения: программа не должна загружаться дольше 10 секунд, а чтение – занимать свыше 5 секунд.
//4*)Сделать клиен-серверное приложение. Передать по сети сеарилизованный объект.
package Lesson_3.hw;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class MainHW {
    public static void main(String[] args) throws IOException {
//        taskOne();
//        taskTwo();
        taskThree();
    }

    private static void taskTwo() throws IOException {
        ArrayList<InputStream> ali = new ArrayList<>();
        ali.add(new FileInputStream("123/5.txt"));
        ali.add(new FileInputStream("123/5.txt"));
        ali.add(new FileInputStream("123/5.txt"));
        ali.add(new FileInputStream("123/5.txt"));
        ali.add(new FileInputStream("123/5.txt"));


        SequenceInputStream in = new SequenceInputStream(Collections.enumeration(ali));
        FileWriter fileWriter = new FileWriter("123/all.txt");
        int x;

        while ((x = in.read()) != -1) {
            fileWriter.append((char) x);
        }
        fileWriter.close();
        in.close();
    }

    private static void taskOne() {
        try (FileInputStream in = new FileInputStream("123/2.txt")) {
            byte[] arr = new byte[512];
            int x;
            while ((x = in.read(arr)) > 0) {
                System.out.print(new String(arr, 0, x, "UTF-8"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void taskThree() throws IOException {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("123/3.txt", "r");
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            long fileLength = randomAccessFile.length();
            long pageLength = 1800;
            long pagesCount = fileLength / pageLength;
            byte[] b = new byte[1800];
            long p = 0;
            System.out.println("Длинна файла: " + fileLength + " Длинна страницы: " + pageLength + " Количество страниц: " + pagesCount);
            while (true) {
                System.out.println("\nВведите номер страницы от 0 до " + pagesCount + ". Или -1 для выхода из программы. Либо + или - для перехода по страницам вперед и назад");
                String s = bufferedReader.readLine();
                if (s.equals("+")) {
                    p = p + 1;
                } else if (s.equals("-")) {
                    if (p == 0) {
                        System.out.println("Вы были переброшены на 0 страницу!");
                    } else {
                        p = p - 1;
                    }
                } else {
                    p = Long.parseLong(s);
                }
                if (p <= pagesCount && p >= 0) {
                    randomAccessFile.seek(p * pageLength);
                    randomAccessFile.read(b, 0, b.length);
                    for (byte bb : b) {
                        System.out.print((char) bb);
                    }
                    System.out.println("\nТекущая страница: " + p);
                } else if (p == -1) {
                    System.out.println("Пока!");
                    break;
                } else {
                    throw new Exception("Некорректные данные: " + p);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
