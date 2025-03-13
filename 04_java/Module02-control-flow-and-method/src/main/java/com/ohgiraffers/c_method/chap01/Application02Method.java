package com.ohgiraffers.c_method.chap01;

public class Application02Method {
    /*
    * 인스턴스 메서드 (instance method)
    * - 객체를 생성한 후에 호출할 수 있는 메서드이다.
    * - jvm 의 힙(heap) 영역에 저장되며 객체와 함께 동작한다.
    * - 객체 내부에 인스턴스 변수와 함께 사용될 수 있으며, 개별 객체마다 독립적으로 존재한다.
    * - 메서드 호출 방식 : 객체를 생성한 후 "객체명.메서드명()" -> new MethodTest().instanceMethod();
    * */
    public String instanceMethod(){
        return "인스턴스 메서드 입니다.";
    }

    /*
    * 정적 메서드 (static method)
    * - 클래스 레벨에서 실행되는 메서드, 객체를 생성하지 않고 호출 가능하다.
    * - jvm 의 메서드 영역에 저장되며 모든 객체가 공유할 수 있는 영역에 있다.
    * - 정적 메서드는 인스턴스 변수(instance variable) 또는 "인스턴스 메서드:"를 직접 사용할 수 없다.
    *   -> 이유 : 정적 메서드는 "클래스 로딩 시점"에 메서드 영역에 등록되지만, 인스턴스 변수는 객체가 생성된 이후 힙 메모리에 저장되기 때문이다.
    * - 메서드 호출 방식 : 클래스명.메서드명() -> "MethodTest.getGreeting()";
    * */

    public static void getGreeting(){
        System.out.println("Hello World!");
    }

    /*
    * 오버로딩
    * - 같은 이름의 메서드를 매개변수의 "개수", "타입", "순서"를 다르게 하여 여러 개 정의하는 것
    * - java 에서 메서드의 시그니처가 다르면 같은 이름의 메서드를 허용한다.
    * - 컴파일러가 메서드 호출 시 전달된 인자의 타입을 보고 "적절한 메서드를 선택"하여 실행
    * */

    public String overloadedMethod(){
        System.out.println("Hello overload");
        return "1번 반환";
    }

    public String overloadedMethod(String name){
        System.out.println("Hello" + name);
        return "2번 반환";

    }
}
