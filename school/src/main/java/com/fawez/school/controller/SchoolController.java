package com.fawez.school.controller;

import com.fawez.school.dto.SchoolDTO;
import com.fawez.school.service.FullSchoolResponse;
import com.fawez.school.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school")
@CrossOrigin
public class SchoolController {

private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping("/addSchool")

    public ResponseEntity<SchoolDTO> saveStudent(@RequestBody SchoolDTO schoolDTO){
       SchoolDTO addSchool = schoolService.addschool(schoolDTO);
        return new ResponseEntity<>(addSchool,HttpStatus.CREATED);
    }
    @GetMapping("/fetchAllSchool")
    public ResponseEntity<List<SchoolDTO>> fetchAllSchool (){
        List<SchoolDTO> allSchool=schoolService.findAllSchool();
        return new ResponseEntity<>(allSchool,HttpStatus.OK);

    }
    @GetMapping("with-student/{schoolId}")
    public ResponseEntity<FullSchoolResponse> findAllSchoolWithStudent(
            @PathVariable("schoolId") Integer schoolId){
        FullSchoolResponse schools = schoolService.findAllSchoolWithStudents(schoolId);
        return new ResponseEntity<>(schools,HttpStatus.OK);
    }
}
