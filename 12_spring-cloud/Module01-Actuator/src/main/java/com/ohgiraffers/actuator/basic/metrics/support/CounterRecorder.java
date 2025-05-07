package com.ohgiraffers.actuator.basic.metrics.support;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CounterRecorder {

    // 액추어터의 핵심 인터페이스? 수집을 하면 MeterRegistry 얘가 등록하고 스프링에 줌
    private final MeterRegistry registry;

    @Autowired
    public CounterRecorder(MeterRegistry registry) {
        this.registry = registry;
    }

    public void incrementCounter(String name, String... tags) {
        registry.counter(name, tags).increment();
    }
}
