package com.practice.spring_security_5hour_lecture.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/test")
public class StudentController {

    List<Student> studentList = Arrays.asList(
            Student.builder().id(1L).name("얼수").build(),
            Student.builder().id(2L).name("형준").build(),
            Student.builder().id(3L).name("서연").build()
    );

    @GetMapping("{studentId}")
    public Student getStudent(@PathVariable Long studentId){
        return studentList.stream().filter(item->item.getId().equals(studentId)).findFirst().orElseThrow(RuntimeException::new);
    }
}

