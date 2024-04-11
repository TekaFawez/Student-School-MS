package com.fawez.school.client;

import com.fawez.school.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "student-service",url = "http://localhost:8090/student/")//interdit
public interface StudentClient {
    @GetMapping("/school/{schoolId}")
    List<Student> FindAllStudentsBySchool(
            @PathVariable("schoolId") Integer schoolId
    );
}
