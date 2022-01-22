package com.example.httpdemo.bean;

public class Student {
    private String name;
    private String num;
    private String age;

    public Student(String name, String num, String age) {
        this.name = name;
        this.num = num;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
