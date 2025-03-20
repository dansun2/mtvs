package com.ohgiraffers.fileio.section03;

import java.io.FileReader;
import java.io.IOException;
// 배치?는 쿼리를 한번에 묶어서 저장시킬 수 있음
// 파일 관리할 때 네이밍 전략
// .exe 같은 파일을 그냥 저장하면 서버 내부에서 그냥 실행될 수 있음 => 사용자에게 파일을 받아서 저장할 때 확장자를 분리시켜서 저장하거나 해야함
public class DeepDive {

    public static void readNonExistentFile() throws IOException {
        try(FileReader reader = new FileReader("non_existent.txt")){
            reader.read();
        }
    }
}
