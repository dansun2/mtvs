package junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
/*
* 1. junit과 예외 테스트
* - junit은 java에서 단위 테스트를 작성하고 실행하기 위한 프레임워크이다.
* - 예외 테스트는 특정 코드 블록에서 예외가 발생하는지를 확인하는 테스트이다.
*
* 2. AssertThrows 메서드
*   - assertThrows는 지정한 예외가 발생하는지 검증하는 메서드이다.
*   - 이 메서드는 예외가 발생하면 해당 예외 객체를 반환하며, 발생하지 않으면 테스트가 실패한다.
* */
public class ApplicationTests {
    public void divide(int a, int b) {
        if (b==0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        System.out.println(a/b);
    }

    @Test
    void divideTest() {
        ArithmeticException exception = Assertions.assertThrows(ArithmeticException.class, () -> {
            divide(1,0);
        });

        Assertions.assertEquals("0으로 나눌 수 없습니다.", exception.getMessage());

        Assertions.assertThrows(ArithmeticException.class, () -> {
            divide(1,0);
        });
    }
}
