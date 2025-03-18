package com.ohgiraffers.chap02.team_mission.model;

import com.ohgiraffers.chap02.team_mission.service.Describable;

public abstract class Animal {
    private String name;
    private int age;

    public abstract String getSpecies();

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (" + getSpecies() + ", "
                + age+"세), 서식지 : "
                + ", ";
    }
}
