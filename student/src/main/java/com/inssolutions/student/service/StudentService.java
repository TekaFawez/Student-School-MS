package com.inssolutions.student.service;

import com.inssolutions.student.dto.StudentDTO;
import com.inssolutions.student.entity.Student;
import com.inssolutions.student.repo.StudentRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;
    @Autowired
    private ModelMapper modelMapper;

    public StudentDTO addStudent (StudentDTO studentDTO){
        Student student = modelMapper.map(studentDTO,Student.class);
        Student saveStudent = studentRepo.save(student);
        return  modelMapper.map(saveStudent , StudentDTO.class);
    }
    public List<StudentDTO> findAllStudent(){
        List<Student> students = studentRepo.findAll();
        return students.stream()
                .map((student)->modelMapper
                        .map(student,StudentDTO.class))
                .collect(Collectors.toList());
    }


    public List<StudentDTO> findAllStudentBySchool(Integer schoolId) {
        List<Student> students = studentRepo.findAllBySchoolId(schoolId);
        return students.stream()
                .map((student) -> modelMapper
                        .map(student, StudentDTO.class))
                .collect(Collectors.toList());
    }

}
