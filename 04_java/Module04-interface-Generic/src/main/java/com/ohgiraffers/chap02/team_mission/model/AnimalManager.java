package com.ohgiraffers.chap02.team_mission.model;

import com.ohgiraffers.chap02.team_mission.service.Describable;

import java.util.ArrayList;

public class AnimalManager <T extends Animal> {
    private ArrayList<T> animals;

    public AnimalManager() {
        animals = new ArrayList<>(); // animals 리스트 초기화
    }

    public void addAnimal(T animal) { // 동물 추가 animal 클래스의 형태지만 어떤 동물이 될 지는 모름
        animals.add(animal);
    }

    public String manageAnimals() {
        String animalDescribtion = "";
        for (T animal : animals) { // 어떤 동물이 될 지 모르니 T로 두고 animals 리스트를 반복문에 돌림
            if (animal instanceof Mammal) { // 좌항이 우항의 타입과 같으면
                Mammal mammal = (Mammal) animal; // Dog는 Animal->Mammal->Dog 이기 때문에 형변환해줌 
                animalDescribtion += animal.getName()+ " ("+ animal.getSpecies()+", " + animal.getAge()+"세), 서식지 : "+mammal.getHabitat()+", "+((Describable) animal).getDescription();
            } else { // Bird는 Animal->Bird 바로 상속받고 있음
                animalDescribtion += animal.getName()+ " ("+ animal.getSpecies()+", " + animal.getAge()+"세), "+((Describable) animal).getDescription();
            }
            animalDescribtion += ", ";
        }
        return animalDescribtion;
    }
}
