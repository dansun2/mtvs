package com.ohgiraffers.chap02.team_mission.model;

import com.ohgiraffers.chap02.team_mission.service.Describable;

public class Bird extends Animal implements Describable {
    public Bird(String name, int age) {
        super(name, age);
    }

    @Override
    public String getSpecies() {
        return "Bird";
    }

    @Override
    public String getDescription() {
        return "새가 날아갑니다: 짹짹!";
    }
}
