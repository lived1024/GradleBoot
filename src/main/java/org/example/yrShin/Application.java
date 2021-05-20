package org.example.yrShin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//별도의 파일로 분리
//@EnableJpaAuditing                                          // JPA Auditing 활성화
@SpringBootApplication                                      // 스프링부트 메인
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
