package com.ohgiraffers.chap02.team_mission.model;

import com.ohgiraffers.chap02.team_mission.service.Describable;

public class Dog extends Mammal implements Describable {
    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public String getHabitat() {
        return "Land";
    }

    @Override
    public String getSpecies() {
        return "Dog";
    }

    @Override
    public String getDescription() {
        return "강아지가 짖습니다: 멍멍!";
    }
}
