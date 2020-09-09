package com.learncode.serial;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by IntelliJ IDEA.
 *
 * @author 190503
 * @date 2020-09-09
 * @time 14:12
 */
public class DeserialTest {

    public static void main(String[] args) {
        Person person;

        try {
            FileInputStream fileInputStream = new FileInputStream("Person.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            person = (Person) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
            System.out.println("Person Deserial: " + person);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
