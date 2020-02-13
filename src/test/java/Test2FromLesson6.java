import Lesson_6.HW.Task2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

public class Test2FromLesson6 {
    Task2 task2;

    @Before
    public void init() {
        task2 = new Task2();
    }

    @Test
    public void massTest1() {
        int[] mass1 = {1, 2, 3, 5, 6, 7, 8, 9};
        Assert.assertTrue("Error!", task2.method(mass1));
    }

    @Test
    public void massTest2() {
        int[] mass2 = {4, 2, 3, 5, 6, 7, 8, 9};
        Assert.assertTrue("Error!", task2.method(mass2));
    }

    @Test
    public void massTest3() {
        int[] mass3 = {2, 3, 5, 6, 7, 8, 9};
        Assert.assertFalse("Error!", task2.method(mass3));
    }
}