package com.greetty.recycleviewdemo.bean;

/**
 * Created by Greetty on 2018/10/18.
 */

public class Student {
    private String name;
    private boolean select;

    public Student(String name, boolean select) {
        this.name = name;
        this.select = select;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", select=" + select +
                '}';
    }
}
