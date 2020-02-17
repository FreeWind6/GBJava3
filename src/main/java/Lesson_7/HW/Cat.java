package Lesson_7.HW;

import Lesson_7.MyAnon;

public class Cat {
    String name;
    public String color;
    private int age;

    public Cat(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    @Test(priority = 5)
    public void info1() {
        System.out.println("info1 " + name + " " + color + " " + age);
    }

    @Test(priority = 1)
    public void info2() {
        System.out.println("info2 " + name + " " + color + " " + age);
    }

    @Test(priority = 2)
    public void info3() {
        System.out.println("info3 " + name + " " + color + " " + age);
    }

    @Test(priority = 8)
    public void info8() {
        System.out.println("info8 " + name + " " + color + " " + age);
    }

    @BeforeSuite
    public void info4() {
        System.out.println("info4 " + name + " " + color + " " + age);
    }

/*    @BeforeSuite
    public void info6() {
        System.out.println("info6 " + name + " " + color + " " + age);
    }*/

    @AfterSuite
    public void info5() {
        System.out.println("info5 " + name + " " + color + " " + age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
