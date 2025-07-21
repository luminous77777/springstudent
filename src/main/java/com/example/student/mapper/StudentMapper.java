package com.example.student.mapper;

import java.util.List;
import java.util.Map;

import com.example.student.domain.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {
    List<Student> selectAll();
    List<Student> selectAllByTotalDesc();
    Student selectByNo(Long no);
    int insert(Student student);
    int update(Student student);
    int delete(Long no);
    Map<String, Object> selectAverage();
}
