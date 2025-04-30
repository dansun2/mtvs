package com.ohgiraffers.actuator.basic.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        boolean isDatabaseOkay = checkCustomHealthLogic();

        // 키의 값과 갯수가 같아야 됨. 그렇지 않으면 도합해서 통계를 낼 수 없음
        if (isDatabaseOkay) {
            return Health.up()
                    .withDetail("database", "데이터베이스 커넥션 완료")
                    .withDetail("status", "Available")
                    .build();
        } else {
            return Health.down()
                    .withDetail("database", "데이터베이스 커넥션 실패")
                    .withDetail("status", "Unavailable")
                    .build();
        }
    }

    /* 실제 데이터베이스 커넥션이 이루어졌는지 확인하기 위한 용도 */
    private boolean checkCustomHealthLogic() {
        return true; // 나중에 커넥션 맺는걸로 바꾸면 됨?
    }
}
