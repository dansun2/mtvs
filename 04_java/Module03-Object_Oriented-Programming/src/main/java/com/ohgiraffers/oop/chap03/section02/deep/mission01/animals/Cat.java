package com.ohgiraffers.oop.chap03.section02.deep.mission01.animals;

public class Cat extends Pet {
    private String favoriteToy;

    public Cat(String name, int age, String favoriteToy) {
        super(name, age);
        this.favoriteToy = favoriteToy;
    }

    public void meow() {
        System.out.println("야옹~");
    }

    public String getFavoriteToy() {
        return favoriteToy;
    }

    public void setFavoriteToy(String favoriteToy) {
        this.favoriteToy = favoriteToy;
    }
}
