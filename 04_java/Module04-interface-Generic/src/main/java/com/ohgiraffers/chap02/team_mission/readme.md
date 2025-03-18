# 동물 정보 관리 시스템

이 프로젝트는 자바에서 객체지향 프로그래밍(OOP)의 핵심 요소와 인터페이스, 제네릭을 활용하여 동물 정보 관리 시스템을 구현하는 예제입니다. 상속 계층을 통해 구조화된 설계를 연습할 수 있습니다.

## 프로젝트 개요

- **미션**: 동물 정보 관리 시스템 (인터페이스, 다중 상속, 제네릭 활용)
- **목표**: 캡슐화, 상속, 다형성, 추상화, 인터페이스, 제네릭을 활용한 동물 데이터 관리 기능 구현
- **현재 버전**: 1.0.0
- **작성일**: 2025년 3월 18일

## 요구사항 명세서

### 입력
- 동물 이름 문자열, 나이 정수, 동물 객체 배열

### 처리
1. **`Describable` 인터페이스**
    - `String getDescription()` 메서드를 선언
2. **`Animal` 추상 클래스**
    - private 멤버 변수: `name(String)`, `age(int)`
    - 생성자와 getter, setter, `toString()` 메서드 구현
    - 추상 메서드: `String getSpecies()`
3. **`Mammal` 추상 클래스**
    - `Animal` 클래스를 상속
    - 추상 메서드: `String getHabitat()`
4. **`Dog` 클래스**
    - `Mammal` 클래스를 상속
    - `Describable` 인터페이스 구현
        - `getDescription()`: "강아지가 짖습니다: 멍멍!" 반환
    - `getSpecies()`: "Dog" 반환
    - `getHabitat()`: "Land" 반환
5. **`Bird` 클래스**
    - `Animal` 클래스를 상속
    - `Describable` 인터페이스 구현
        - `getDescription()`: "새가 날아갑니다: 짹짹!" 반환
    - `getSpecies()`: "Bird" 반환
6. **`AnimalManager` 클래스 (제네릭 활용)**
    - 제네릭 타입: `<T extends Animal>`
    - private 멤버 변수: 동물 리스트 (`ArrayList<T> animals`)
    - 메서드:
        - `void addAnimal(T animal)`: 동물을 리스트에 추가
        - `String manageAnimals()`: 리스트를 순회하며 `getDescription()`과 `toString()` 호출, `Mammal` 타입 객체의 경우 `getHabitat()` 추가 호출
        - 결과를 쉼표(,)로 연결한 문자열 반환

### 출력
- 동물 정보와 설명이 포함된 문자열 (리스트가 비어 있으면 빈 문자열 반환)

### 포함 기술
- 변수, 데이터 타입, 연산자
- 배열과 문자열 다루기
- 클래스 및 객체, 생성자와 메서드 활용
- 캡슐화, 상속, 다형성, 추상화, 인터페이스, 제네릭

### JUnit 활용
- `@BeforeEach`, `@AfterEach`, `@Test`
- `assertEquals`, `assertNotNull`

## 상속 계층도
```
Animal (추상 클래스)
├── Mammal (추상 클래스)
│   └── Dog (Describable 인터페이스 구현)
└── Bird (Describable 인터페이스 구현)
```

## 개발 순서
1. **`Describable` 인터페이스 정의**
    - `String getDescription()`
2. **`Animal` 추상 클래스 정의**
    - private 멤버 변수 (`name`, `age`)
    - 생성자, getter, setter, `toString()`
    - 추상 메서드 `String getSpecies()`
3. **`Mammal` 추상 클래스 정의**
    - `Animal` 상속
    - 추상 메서드 `String getHabitat()`
4. **`Dog` 클래스 정의**
    - `Mammal` 상속, `Describable` 구현
    - `getDescription()`, `getSpecies()`, `getHabitat()`
5. **`Bird` 클래스 정의**
    - `Animal` 상속, `Describable` 구현
    - `getDescription()`, `getSpecies()`
6. **`AnimalManager` 클래스 정의**
    - 제네릭 타입 `<T extends Animal>` 적용
    - `ArrayList<T>`로 동물 리스트 관리
    - `addAnimal(T animal)` 및 `manageAnimals()` 메서드 구현
7. **`main()` 메서드 작성**
    - 샘플 데이터로 테스트

## 예시 입출력

### 입력
```
AnimalManager<Animal> manager = new AnimalManager<>();
manager.addAnimal(new Dog("바둑이", 3));
manager.addAnimal(new Bird("참새", 1));
```

### 출력
```
바둑이 (Dog, 3세), 서식지: Land, 강아지가 짖습니다: 멍멍!, 참새 (Bird, 1세), 새가 날아갑니다: 짹짹!
```

### 비어 있는 경우
```
AnimalManager<Animal> manager = new AnimalManager<>();
```

### 출력
```
""
```