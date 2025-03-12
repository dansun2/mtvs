package com.ohgiraffers.a_junit.chap01;
/*
* 자바에서 테스트 코드가 중요한 이유는 소프트웨어의 품질을 보장하고,
* 개발 과정에서 발생할 수 있는 오류를 사전에 예방하며, 코드의 유지보수성과 확장성을 높이기 때문이다.
* 테스트 코드는 단위 테스트(unit test), 통합 테스트(intergration test) 등을 통해 개별 기능의 정확성을 검증하고,
* 시스템 전체의 안정성을 확인할 수 있게 된다.
*
* 특히, junit과 같은 테스트 프레임워크를 활용하면
* @Test, assertEquals, assertTure 등의 기능을 통해 개발자가 의도한 대로 코드가 동작하는지 쉽게 확인할 수 있다.
* 이를 통해 버그를 조기에 발견하고 수정할 수 있으며 개발 비용과 시간을 아낄 수 있다.
* */

import org.junit.jupiter.api.Test;

/*
*   junit
* junit은 자바 프로그래밍 언어를 위한 단위 테스트 프레임워크로
*  소프트웨어 개발에서 코드의 품질과 안정성을 보장하기 위해 널리 사용된다.
* junit은 테스트 작성과 실행을 용이하게 하고, 테스트 결과를 보고하는 기능을 제공한다.
*
* 테스트 클래스를 작성하기 위해서는 다음과 같이 클래스명"Tests"를 추가해야 한다.
* - 하나의 메서드는 하나의 테스트를 담당, 독립적으로 동작
* */
public class ApplicationTests {
    /*
    * @Test
    * @Test 애너테이션이 붙은 메서드는 Junit에 의해 자동으로 테스트 케이스로 인식되며
    * 하나의 테스트가 다른 테스트의 결과에 영향을 미치지 않도록 보장하게 된다.
    * 또한 "Test(timeout=1000)과 같이 시간을 지정하면 해당 시간내에 실행되지 않는 경우 실패로 처리된다.
    * */
    @Test
    public void test() {
        System.out.println("테스트 A 시나리오");
    }

    @Test
    public void test2() {
        System.out.println("테스트 B 시나리오");
    }
}
