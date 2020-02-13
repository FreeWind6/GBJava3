package Lesson_6.Lesson_Log4j;

import org.apache.log4j.Logger;


import java.io.IOException;

public class MainClass {

    public static void main(String[] args) throws IOException {

        Logger admin = Logger.getLogger("admin");

        int a = 0;
        try {
            int b = 10 / a;
        } catch (ArithmeticException e) {
            admin.info(e.getMessage() + " ОШибка вычисления");
        }

        admin.info("This is info");
        admin.warn("This is warn");
        admin.error("This is error");
        admin.fatal("This is fatal");

        Logger file = Logger.getLogger("file");

        file.info("This is info");
        file.warn("This is warn");
        file.error("This is error");
        file.fatal("This is fatal");
    }

}
