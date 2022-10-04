package com.ll.exam.jwt;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class JwtTests {
    @Value("${custom.jwt.secretKey}")
    private String secretKey;

    @Test
    @DisplayName("시크릿 키가 존재해야 한다.")
    void t1() {
        assertThat(secretKey).isNotNull();
    }

}