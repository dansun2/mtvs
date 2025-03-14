package com.ohgiraffers.oop.chap01.basic;

public class Application01 {
    public static void main(String[] args) {
        String brand1 = "Tesla";
        String model1 = "Model S";
        int speed = 0;

        String brand2 = "BMW";
        String model2 = "i8";
        int speed2 = 0;

        System.out.println(brand1 + " " + speed + " 의 속도" + model1);
        System.out.println(brand2 + " " + speed2 + " 의 속도" + model2);

        /*
        * 문제점
        * - 동일한 속성을 가진 변수를 개별적으로 관리해야 한다.
        * - 새로운 자동차를 추가하려면 변수를 계속 추가해야 한다.
        * - 코드가 길어지고 유지보수가 어려워진다.
        * */

        /*
        * new 연산자
        * - 'new'는 클래스의 객체(인스턴스)를 새로 만드는 명령어이다.
        * - 메모리(힙 영역) 공간을 만들어 car라는 설계도를 기반으로 실제 자동차를 만든다.
        * - 예) new Car()는 Car 설계도를 보고 새 자동차를 하나 생성하는 느낌이다.
        * - 결과로 만들어진 객체의 주소를 반환해서 변수에 저장할 수 있다.
        * */
        Car tesla = new Car();
        tesla.brand = "Tesla";
        tesla.model = "Model S";
        tesla.speed = 0;

        tesla.accelerate();
        tesla.accelerate();
        tesla.brake();

        Car bmw = new Car();
        bmw.brand = "BMW";
        bmw.model = "i8";
        bmw.speed = 0;
        bmw.accelerate();
        bmw.accelerate();
        bmw.brake();

        System.out.println(bmw == tesla);
        /*
         * 객체 간 차이와 인스턴스 참조의 의미
         * - new Car()를 여러 번 하면 서로 다른 자동차(객체)가 만들어져요.
         * - 예: Car car1 = new Car();와 Car car2 = new Car();는 서로 다른 두 자동차!
         * - 차이점:
         *   1. 메모리 주소가 달라요: car1과 car2는 힙 영역에서 다른 공간을 차지.
         *   2. 속성 값이 독립적: car1.speed를 바꿔도 car2.speed는 안 바뀜.
         *   3. 상태가 달라질 수 있음: car1은 accelerate()를 2번 했고, car2는 안 했으면 속도가 다름.
         * - 참조 예시:
         *   Car car3 = car1; // car3는 car1과 같은 객체를 참조 (같은 열쇠 공유)
         *   car3.speed = 50; // car1.speed도 50으로 바뀜 (같은 자동차니까!)
         */
    }
}
