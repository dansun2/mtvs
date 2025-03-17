package com.ohgiraffers.oop.chap03.section02.deep.mission02.model;

public class Employee extends Person {
    private String position;
    private int salary;

    public Employee(String name, int age, String position, int salary) {
        super(name, age);
        this.position = position;
        this.salary = salary;
    }


    @Override
    public void introduce() {
        super.introduce();
    }

    public void work() {
        System.out.println("직원 " + getName() + "이(가) " + getPosition() + "으로 일하고 있습니다.");
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
