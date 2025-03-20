package com.ohgiraffers.fileio.section03;

import java.io.*;
/*
 * 파일 입출력과 예외 처리의 심화 개념: 서버 엔지니어 관점에서 파일 사용 시기
 *
 * 서버 환경에서 파일은 언제 사용하면 좋을까?
 * 파일은 데이터를 영구적으로 저장하거나, 네트워크 의존성을 줄이고, 서버 부하를 분산할 때 유용하다.
 * 서버 엔지니어는 파일을 전략적으로 활용해 성능을 최적화하고, 시스템 안정성을 높일 수 있다.
 *
 * 실생활 사례:
 * 1. 카카오톡 PC 버전: 카카오톡 PC는 채팅 내용을 로컬 파일에 기록하고, 서버와 주기적으로 동기화한다.
 *    - 왜 파일을 사용? 네트워크가 불안정하거나 서버 응답이 느릴 때, 로컬 파일에서 데이터를 읽어 빠르게 UI를 렌더링한다.
 *    - 성능 이점: 매번 서버에 요청하지 않아 네트워크 대역폭을 절약하고, 응답 속도가 빨라진다.
 *
 * 2. 웹 서버 로그 시스템: 웹 서버(예: Nginx, Apache)는 요청 로그를 파일에 저장한다가 주기적으로 분석 서버로 전송한다.
 *    - 왜 파일을 사용? 실시간 DB 쓰기는 I/O 부하를 증가시키므로, 파일에 먼저 기록해 부담을 줄인다.
 *    - 성능 이점: 비동기적으로 파일을 처리하면 서버의 동시 처리 능력이 향상된다.
 *
 * 3. 캐시 파일: 서버에서 자주 요청되는 데이터를 파일로 캐싱(예: 이미지, 정적 콘텐츠)한다.
 *    - 왜 파일을 사용? DB나 메모리 대신 파일을 읽으면 메모리 사용량을 줄이고, 디스크 I/O로 부하를 분산한다.
 *    - 성능 이점: 메모리 캐시보다 비용이 저렴하고, 서버 재시작 시에도 데이터가 유지된다.
 *
 * 심화 개념: 파일 사용의 trade-off
 * - 장점: 네트워크 의존성 감소, 데이터 영속성 보장, 서버 부하 분산.
 * - 단점: 디스크 I/O는 네트워크나 메모리보다 느리므로, 빈번한 읽기/쓰기는 성능 저하를 유발할 수 있다.
 * - 해결책: Buffered 스트림을 사용하거나, 파일 크기를 작게 유지하고, SSD 같은 고속 스토리지를 활용한다.
 *
 * 메모리 구조: 파일 데이터는 힙에서 스트림 객체로 관리되며, BufferedReader/Writer는 버퍼를 통해
 * 디스크 I/O 호출을 줄인다. 예외는 스택 트레이스를 생성하며, 이는 힙에 기록된다.
 *
 * 성능 관련: 파일을 적절히 사용하면 서버의 네트워크 및 DB 부하를 줄여 처리량(Throughput)이 증가한다.
 * 하지만 파일 동기화나 과도한 I/O는 병목현상을 일으킬 수 있으니, 비동기 처리(Async I/O)나 캐싱 전략을 병행해야 한다.
 */
public class Application {
    public static void main(String[] args) {
        System.out.println("=== 서버에서 파일 로그 쓰기 시뮬레이션 ===");

        // log.txt 파일에 로그 추가
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true))) { // true는 파일에 데이터를 추가하는 모드
            // 문자 데이터를 효율적으로 쓰기 위한 클래스로 이 클래스는 내부적으로 버퍼를 사용하여 데이터를 저장하고,
            // 한 번에 여러 문자를 파일에 쓰는 방식으로 I/O 작업의 성능이 향상된다.
            for (int i = 1; i <= 10; i++) {
                String logMessage = "로그 메시지 " + i + ": 서버가 정상 작동 중입니다.";
                writer.write(logMessage);
                writer.newLine(); // 줄바꿈
            }
            System.out.println("로그 메시지가 log.txt에 추가되었습니다.");
        } catch (IOException e) {
            System.out.println("파일 쓰기 실패: " + e.getMessage());
            /*
             * 예외 처리: 파일 쓰기 실패 시 사용자에게 오류 메시지를 반환할 수 있다.
             */
        }

        // 서버 엔지니어 관점 예제: 파일을 활용한 데이터 처리
        // 버퍼를 사용하여 여러 문자를 한 번에 읽어오기 때문에, I/O 작업의 횟수를 줄이고 성능을 개선
        System.out.println("=== 서버에서 파일 읽기 시뮬레이션 ===");
        try (BufferedReader reader = new BufferedReader(new FileReader("log.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("서버 로그: " + line);
                /*
                 * 서버 로그 시나리오: 파일에서 로그를 읽어 처리한다.
                 * BufferedReader는 버퍼를 사용해 디스크 I/O를 최소화하며,
                 * 네트워크 대신 로컬 파일을 읽으므로 서버 부하가 줄어든다.
                 */
            }
        } catch (IOException e) {
            System.out.println("파일 읽기 실패: " + e.getMessage());
            /*
             * 예외 처리: 파일 읽기 실패 시 서버는 대체 데이터를 제공하거나,
             * 사용자에게 오류 메시지를 반환할 수 있다.
             */
        }


        // =============================

        // 비교 예제: 올바른 코드 vs 잘못된 코드
        System.out.println("\n=== 올바른 예외 처리 ===");
        try {
            DeepDive.readNonExistentFile();
        } catch (IOException e) {
            System.out.println("예외 처리 성공: " + e.getMessage());
            /*
             * 서버 관점: 예외를 캐치해 서버가 종료되지 않도록 보장한다.
             * 성능 이점: 예외 처리를 통해 서비스 가용성이 유지된다.
             */
        }

        System.out.println("=== 예외 처리를 생략한 경우 ===");

        // 주석 해제 시 프로그램 종료
        // readNonExistentFile();
        /*
         * 서버 관점: 예외를 처리하지 않으면 서버 프로세스가 죽고, 클라이언트 요청이 실패한다.
         * 이는 서버 가동률(Downtime)을 증가시키는 원인이 된다.
         */

    }
}
