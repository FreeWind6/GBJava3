package Lesson_8;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
//        Camera camera = new Camera();
//        ICameraRoll cameraRoll = new ColorCameraRoll();
//        camera.setCameraRoll(cameraRoll);
//        camera.doPhotograph();

//        Assistant assistant = new Assistant();
//        Camera camera = assistant.getCamera();
//        camera.doPhotograph();

        String str = null;

        if (str == null) {
            System.out.println("null");
        }

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        Camera camera = context.getBean("camera", Camera.class);
        camera.doPhotograph();
    }
}
