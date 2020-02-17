import Lesson_6.HW.Task1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Test1FromLesson6 {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 7}, new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}},
                {new int[]{8, 9, 10}, new int[]{1, 2, 3, 5, 4, 8, 9, 10}},
                {new int[]{5}, new int[]{1, 2, 3, 5, 4, 8, 9, 10, 11, 4, 5}}
        });
    }

    private Task1 task1;
    private int[] a;
    private int[] b;

    public Test1FromLesson6(int[] a, int[] b) {
        this.a = a;
        this.b = b;
    }

    @Before
    public void init() {
        task1 = new Task1();
    }

    @Test
    public void massTest() {
        Assert.assertTrue("Error!", Arrays.equals(a, task1.method(b)));
    }

    @Test(expected = RuntimeException.class)
    public void massTest2() {
        int[] mass1 = {};
        int[] mass2 = {1, 2, 3, 5, 8, 9, 10, 11, 5, 6};
        Assert.assertTrue(Arrays.equals(mass1, task1.method(mass2)));
    }
}