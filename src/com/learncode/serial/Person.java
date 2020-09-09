package com.learncode.serial;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 *
 * @author 190503
 * @date 2020-09-09
 * @time 13:46
 */
public class Person implements Serializable {

    private static final long serialVersionUID = -6306154950028651443L;

    private int id;

    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return new StringBuffer("Person: ").append("[")
                .append("id: ").append(id)
                .append("; name: ").append(name)
                .append("]").toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
