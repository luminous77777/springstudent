package com.example.student.configTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;


@SpringBootTest
@ActiveProfiles("application.yml")
class DatabaseConnectionTest {
    @Autowired
    DataSource dataSource ;

    @Test
    void hikariConnectionTest() throws Exception {
        System.out.println("▶ DataSource Class = " + dataSource.getClass().getName());
        dataSource.getConnection().close(); // 실제 연결 시도
        Assertions.assertNotNull(dataSource);
    }

    @Test
    void writeTest() throws Exception {
        System.out.println("이것은 글쓰기");
    }
}