package com.inssolutions.student.controller;

import com.inssolutions.student.dto.StudentDTO;
import com.inssolutions.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/addStudent")
//    public ResponseEntity<RestaurantDTO> saveRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
    //      RestaurantDTO restaurantAdded = restaurantService.addRestaurantInDB(restaurantDTO);
    //      return new ResponseEntity<>(restaurantAdded, HttpStatus.CREATED);
    //   }
    public ResponseEntity<StudentDTO> saveStudent(@RequestBody StudentDTO studentDTO){
        StudentDTO addStudent = studentService.addStudent(studentDTO);
        return new ResponseEntity<>(addStudent,HttpStatus.CREATED);
    }
    @GetMapping("/fetchAllStudent")
    public ResponseEntity<List<StudentDTO>> fetchAllStudent (){
        List<StudentDTO> allStudent=studentService.findAllStudent();
        return new ResponseEntity<>(allStudent,HttpStatus.OK);

    }
    @GetMapping("/school/{schoolId}")
    public ResponseEntity<List<StudentDTO>> findAllStudentBySchool(
            @PathVariable("schoolId") Integer schoolId
    ){
        List<StudentDTO> allStudents = studentService.findAllStudentBySchool(schoolId);
        return new ResponseEntity<>(allStudents,HttpStatus.OK);}
}
