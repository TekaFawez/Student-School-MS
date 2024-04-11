package com.inssolutions.student.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private int id;
    private String nom;
    private String prenom ;
    private String email ;
    private int schoolId ;
}
