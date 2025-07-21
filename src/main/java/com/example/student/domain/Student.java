package com.example.student.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student implements Comparable<Student>{
    private Long no;
    private String name;
    private int kor;
    private int eng;
    private int mat;

    public int total() {
        return kor + eng + mat;
    }

    public double average() {
        return total() / 3.0;
    }

    public void modify(int kor, int eng, int mat) {
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
    }

    @Override
    public int compareTo(Student o) {
        return 0;
    }
}
