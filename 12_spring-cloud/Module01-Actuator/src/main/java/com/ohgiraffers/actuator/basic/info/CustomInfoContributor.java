package com.ohgiraffers.actuator.basic.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Map;

/*
* CustomInfoContributor 클래스
* 목적 : SpringBoot Actuator 의 /actuator/info 엔드포인트에 사용자 정의 정보를 추가하여 메타데이터를 제공한다.
* 주요 기능 : 서버 시간, 환경 정보 등 커스텀 데이터를 /actuator/info 응답에 포함한다.
*
* 엔드포인트 /actuator/info
* */
@Component
public class CustomInfoContributor implements InfoContributor {

    /*
    * contribute 메서드
    * /actuator/info 엔드포인트에 애플리케이션의 메타데이터를 추가한다.
    * 주요 기능 : 애플리케이션의 이름, 버전, 환경, 이메일, 개발자 정보를 /actuator/info 응답에 포함한다.
    *   - withDetail() : "app" 키로 map 객체를 추가한다.
    *   - Map.of() : 애플리케이션 메타데이터(이름, 버전, 환경, 이메일, 개발자 정보)를 불변 map으로 생성한다.
    *
    * 주의 사항 :
    *   - 민감한 정보(예 : 이메일)은 운영 환경에서 노출 시 보안 검토가 필요하다.
    *   - 정적 데이터는 application.yml 이나 외부 설정 파일로 관리하는 것이 유지보수에 유리하다.
    * */
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("actuator-app", Map.of(
                "name", "spring-actuator-app",
                "version", "1.0.0",
                "environment", "dev",
                "email", "gorilla@gmail.com",
                "dev", "gorilla"
        ));
    }
}
