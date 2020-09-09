package com.learncode.serial;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by IntelliJ IDEA.
 *
 * @author 190503
 * @date 2020-09-09
 * @time 13:59
 */
public class SerialTest {

    public static void main(String[] args) {
        Person person = new Person(233, "Tom");
        System.out.println("Person Serial" + person);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("Person.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(person);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
