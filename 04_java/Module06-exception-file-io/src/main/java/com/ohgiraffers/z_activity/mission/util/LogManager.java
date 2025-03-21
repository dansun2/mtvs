package com.ohgiraffers.z_activity.mission.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

// 책을 대여/반납 할 때 로그를 남겨주는 클래스
public class LogManager {
    public static void logTransaction(String record, String filePath) {
        // 파일 입출력 과정에서 발생할 수 있는 예외처리 (IOException을 try-catch처리)
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true))) {
            bufferedWriter.write(record);
            bufferedWriter.newLine();
        } catch (IOException e) {
            System.out.println("파일 저장 중 오류가 발생함 " + e.getMessage());
        }
    }
}
