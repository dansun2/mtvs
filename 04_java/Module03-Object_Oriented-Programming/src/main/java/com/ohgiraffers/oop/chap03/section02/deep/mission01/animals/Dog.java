package com.ohgiraffers.oop.chap03.section02.deep.mission01.animals;

public class Dog extends Pet {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    public void bark() {
        System.out.println("멍멍!");
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public void printInfo() {
        super.printInfo();
    }
}
