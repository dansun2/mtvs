package com.ohgiraffers.actuator.basic.metrics;

import com.ohgiraffers.actuator.basic.metrics.model.MetricNames;
import com.ohgiraffers.actuator.basic.metrics.model.MetricTags;
import com.ohgiraffers.actuator.basic.metrics.support.CounterRecorder;
import com.ohgiraffers.actuator.basic.metrics.support.GaugeRecorder;
import com.ohgiraffers.actuator.basic.metrics.support.TimerRecorder;
import io.micrometer.core.instrument.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMetricsRecorder {

    private final CounterRecorder counter;
    private final TimerRecorder timer;
    private final GaugeRecorder gauge;

    @Autowired
    public UserMetricsRecorder(CounterRecorder counter, TimerRecorder timer, GaugeRecorder gauge) {
        this.counter = counter;
        this.timer = timer;
        this.gauge = gauge;
    }

    public Timer.Sample startUserCreationTimer() {
        return timer.start();
    }

    public void stopUserCreationTimer(Timer.Sample sample, String... tags) {
        timer.stop(sample, MetricNames.USER_CREATE_TIMER, tags);
    }

    public void counterUserCreateSuccess() {
        counter.incrementCounter(MetricNames.USER_CREATE_COUNTER, MetricTags.STATUS, "success");
    }

    public void counterUserCreateFailure(String reason) {
        counter.incrementCounter(MetricNames.USER_CREATE_COUNTER, MetricTags.STATUS, "failure", MetricTags.REASON, reason);
    }

    public void counterUserLookupFailure() {
        counter.incrementCounter(MetricNames.USER_LOOKUP_FAILURE, MetricTags.STATUS, "404");
    }

    public void registerUserListSizeGauge(List<?> users) {
        gauge.registerListSize(MetricNames.USER_TOTAL_GAUGE, users);
    }
}
