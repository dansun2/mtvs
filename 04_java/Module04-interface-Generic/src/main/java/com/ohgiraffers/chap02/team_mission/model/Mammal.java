package com.ohgiraffers.chap02.team_mission.model;

import com.ohgiraffers.chap02.team_mission.service.Describable;

public abstract class Mammal extends Animal {
    public Mammal(String name, int age) {
        super(name, age);
    }
    public abstract String getHabitat();
}
