package com.ohgiraffers.chap02.team_mission;

import com.ohgiraffers.chap02.team_mission.model.Animal;
import com.ohgiraffers.chap02.team_mission.model.AnimalManager;
import com.ohgiraffers.chap02.team_mission.model.Bird;
import com.ohgiraffers.chap02.team_mission.model.Dog;

public class Application {
    public static void main(String[] args) {
        AnimalManager<Animal> manager = new AnimalManager<>();
        manager.addAnimal(new Dog("바둑이", 3));
        manager.addAnimal(new Bird("참새", 1));

        System.out.println(manager.manageAnimals());
    }
}
