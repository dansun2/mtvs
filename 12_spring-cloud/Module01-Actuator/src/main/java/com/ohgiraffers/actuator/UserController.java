package com.ohgiraffers.actuator;

import com.ohgiraffers.actuator.basic.metrics.UserMetricsRecorder;
import io.micrometer.core.instrument.Timer;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
    
    private final List<User> users = new ArrayList<>();
    private final UserMetricsRecorder userMetricsRecorder;
    // record는 값객체 만드는거고 value object랑 같음. 매개변수에 getter를 제공함. set으로는 안됨 한번 생성하면 못바꿈
    record User(String id, String name, String email) {}

    @Autowired
    public UserController(UserMetricsRecorder userMetricsRecorder) {
        this.userMetricsRecorder = userMetricsRecorder;
    }

    // 최초로 빈이 생성되는 때에 오토와이어드 되고 나서 init 시점에 실행됨. 생성자에 너무 많은게 추가되면 빈이 생성되는데 오래걸림
    // 최초시점은 0개고 등록할수록 늘어난다는데 생명주기좀 찾아봐야될듯
    @PostConstruct
    public void initGauges() {
        userMetricsRecorder.registerUserListSizeGauge(users);
    }

    // http://localhost:8080/actuator/metrics/http.server.requests?tag=uri:/api/users POST 요청 날려보고 이걸로 확인
    @PostMapping("/users")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        Timer.Sample sample = userMetricsRecorder.startUserCreationTimer();

        if (user.id() == null || user.name() == null || user.email() == null) {
            userMetricsRecorder.counterUserCreateFailure("필수값이 없습니다.");
            return ResponseEntity.badRequest().body("id, name, email은 필수값입니다.");
        }

        if (users.stream().anyMatch(u -> u.id().equals(user.id()))) {
            userMetricsRecorder.counterUserCreateFailure("중복되는 회원이 존재합니다.");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(user.id() + "는 이미 존재하는 이이디입니다.");
        }

        users.add(user);
        userMetricsRecorder.counterUserCreateSuccess();
        userMetricsRecorder.stopUserCreationTimer(sample, "status", "success");

        return ResponseEntity.status(HttpStatus.CREATED).body(user.id() + "가 성공적으로 등록되었습니다.");
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<String> getUser(@PathVariable("id") String id) {
        Optional<User> user = users.stream().filter(u -> u.id().equals(id)).findFirst();

        if (user.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(user.get().toString());
        } else {
            userMetricsRecorder.counterUserLookupFailure();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, id + "를 찾을 수 없습니다.");
        }
    }
}
