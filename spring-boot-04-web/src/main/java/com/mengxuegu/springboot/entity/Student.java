package com.mengxuegu.springboot.entity;

public class Student {
    private String name;
    private Integer old;
    private Integer sex;

    public Student() {
    }

    public Student(String name, Integer old, Integer sex) {
        this.name = name;
        this.old = old;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOld() {
        return old;
    }

    public void setOld(Integer old) {
        this.old = old;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
