package com.fawez.school.service;

import com.fawez.school.client.StudentClient;
import com.fawez.school.dto.SchoolDTO;
import com.fawez.school.entity.School;
import com.fawez.school.repo.SchoolRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {
    @Autowired
    SchoolRepo schoolRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    StudentClient studentClient;

    public SchoolDTO addschool (SchoolDTO schoolDTO){
        School school= modelMapper.map(schoolDTO, School.class);
        School saveSchool = schoolRepo.save(school);
        return  modelMapper.map(saveSchool, SchoolDTO.class);
    }
    public List<SchoolDTO> findAllSchool(){
        List<School> schools = schoolRepo.findAll();
        return schools.stream().map((school)->modelMapper.map(school,SchoolDTO.class)).collect(Collectors.toList());
    }


    public FullSchoolResponse findAllSchoolWithStudents(Integer schoolId) {
        var school = schoolRepo.findById(schoolId).orElse(
                School.builder().nom("NOTFOUND")
                        .email("NotFound")
                        .build()
        );

        var students = studentClient.FindAllStudentsBySchool(schoolId);
        return FullSchoolResponse.builder()
                .nom(school.getNom())
                .email(school.getEmail())
                .studentList(students)
                .build();
    }

}
