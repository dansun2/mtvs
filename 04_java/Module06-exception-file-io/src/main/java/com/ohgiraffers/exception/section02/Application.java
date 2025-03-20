package com.ohgiraffers.exception.section02;
/*
* 예외 처리(try-catch-finally, 사용자 정의 예외)
* - 예외(exception)은 프로그램 실행 중 예상치 못한 문제로 인해 정상적인 흐름이 중단되는 상황을 말한다.
* - 예를 들어, 사용자가 0으로 나누기를 시도하거나, 파일을 열 때 파일이 존재하지 않는 경우 등이 있다.
* - java에서는 try-catch 블럭을 통해 이러한 예외를 처리하며, finally 블럭으로 필수 정리 작업을 보장한다.
* - 사용자 정의 예외는 특정 상황에서 개발자가 직접 예외를 만들어 사용하는 것으로 코드의 의도를 명확히 전달해야 한다.
*
* 예외 처리가 필요한 이유
* - 예외가 발생하면 프로그램이 비정상적으로 종료되어야 한다.
* - 안정적인 프로그램 실행을 위해 반드시 처리해야 한다.
*
* try-catch 문법
* - try : 예외가 발생할 가능성이 있는 코드 블럭
* - catch : 특정 예외를 처리하는 코드 블럭
* - finally : 예외 발생 여부와 상관없이 항상 실행되는 코드 블럭(자원 해제에 사용)
* */
public class Application {
    public static void main(String[] args) {
        try { // 오류가 발생될 수 있는 것들을 묶어둠
            int number = 10;
            int result = number/0;
            System.out.println("결과 : " + result);
        } catch (ArithmeticException e) {
            System.out.println("아놔 오류 났네~~~");
            // printStackTrace는 에러 설명을 가장 상세하고 자세하게 나타내주는 메서드
            // 근데 호출 스택 정보가 외부로 노출될 경우 보안에 문제가 있을 수 있으니 로깅 라이브러리를 사용하여 예외 정보를 로그로 기록하는 것이 좋다.
            // 로그 레벨을 조절하여 필요한 정보만 로그에 남길 수 있다. 그래서 printStackTrace 대신 try-catch 블럭으로 예외를 적절하게 처리하는 것이 좋음
            e.printStackTrace();
        } catch (Exception e) { // catch 블럭은 하나의 try에 여러개 나열 가능
            e.printStackTrace();
        } finally { // catch가 잡히든 안잡히든 무조건 동작함 ex) 파일 객체를 열어주고 버퍼(값)를 쓴 후 항상 닫아줘야하니 여기서 하면 됨
            System.out.println("이것은 항상 동작합니다.");
        }
        System.out.println("그래도 프로그램은 동작하지");
    }
}
