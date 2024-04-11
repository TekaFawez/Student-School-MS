package com.fawez.school.service;

import com.fawez.school.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullSchoolResponse {
    private String nom;
    private String email;

    List<Student> studentList ;

}
