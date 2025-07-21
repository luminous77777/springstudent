package com.example.student.mapperTest;

import com.example.student.domain.Student;
import com.example.student.mapper.StudentMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentMapperTest {

    @Autowired
    private StudentMapper studentMapper;

    static final Long TEST_NO = 1L;

    @Test
    @Order(1)
    @DisplayName("학생 등록 테스트")
    void insertStudent() {
        Student s = Student.builder()
                .no(TEST_NO)
                .name("테스트학생")
                .kor(90)
                .eng(85)
                .mat(95)
                .build();

        int inserted = studentMapper.insert(s);
        Assertions.assertEquals(1, inserted);

        Student fetched = studentMapper.selectByNo(TEST_NO);
        Assertions.assertNotNull(fetched);
        Assertions.assertEquals("테스트학생", fetched.getName());
        Assertions.assertEquals(270, fetched.total());
    }

    @Test
    @Order(2)
    @DisplayName("학생 성적 수정 테스트")
    void updateStudent() {
        Student s = studentMapper.selectByNo(TEST_NO);
        Assertions.assertNotNull(s);

        s.modify(100, 100, 100);
        int updated = studentMapper.update(s);
        Assertions.assertEquals(1, updated);

        Student updatedStu = studentMapper.selectByNo(TEST_NO);
        Assertions.assertEquals(300, updatedStu.total());
    }

    @Test
    @Order(3)
    @DisplayName("전체 조회 및 석차순 조회 테스트")
    void selectAllAndRanked() {
        List<Student> all = studentMapper.selectAll();
        List<Student> ranked = studentMapper.selectAllByTotalDesc();

        Assertions.assertTrue(all.size() > 0);
        Assertions.assertTrue(ranked.size() > 0);
        Assertions.assertTrue(ranked.get(0).total() >= ranked.get(ranked.size() - 1).total());
    }

    @Test
    @Order(4)
    @DisplayName("과목별 평균 조회 테스트")
    void selectAverage() {
        Map<String, Object> avgMap = studentMapper.selectAverage(); // ✅ 수정

        Assertions.assertTrue(avgMap.containsKey("avgKor"));
        Assertions.assertTrue(avgMap.containsKey("avgEng"));
        Assertions.assertTrue(avgMap.containsKey("avgMat"));
        Assertions.assertTrue(avgMap.containsKey("avgAll"));

        double avgAll = ((java.math.BigDecimal) avgMap.get("avgAll")).doubleValue(); // ✅ 안전하게 변환
        Assertions.assertTrue(avgAll >= 0 && avgAll <= 100);
    }

    @Test
    @Order(5)
    @DisplayName("학생 삭제 테스트")
    void deleteStudent() {
        int deleted = studentMapper.delete(TEST_NO);
        Assertions.assertEquals(1, deleted);

        Student s = studentMapper.selectByNo(TEST_NO);
        Assertions.assertNull(s);
    }
}
