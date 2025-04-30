package com.ohgiraffers.actuator.basic.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class HealthConfig {

    @Bean
    public HealthIndicator healthIndicator() {
        return new HealthIndicator() {
            @Override
            public Health health() {
                return Health.up()
                        .withDetail("custom", "health check is up")
                        .build();
            }
        };
    }
}
