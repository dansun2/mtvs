package com.ohgiraffers.actuator.basic.metrics.support;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TimerRecorder {

    private final MeterRegistry registry;

    @Autowired
    public TimerRecorder(MeterRegistry registry) {
        this.registry = registry;
    }

    public Timer.Sample start() {
        return Timer.start(registry);
    }

    // 요청이 들어왔을때 타임을 찍음. 그리고 스탑? -> 하나의 엔드포인트가 얼마나 시간이 걸리는지 수행시간 체크
    // ... <-가변인자는 메서드의 끝에 둬야함 이건 배열로 떨어짐. 스트링값이 몇개든 상관없음. 키-밸류-키-밸류 이렇게 들어옴
    public void stop(Timer.Sample sample, String name, String... tags) {
        sample.stop(Timer.builder(name)
                .tags(tags)
                .register(registry));
    }
}
