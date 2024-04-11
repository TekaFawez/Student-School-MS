package com.fawez.school.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//in memory
public class Student {
    private String nom;
    private String prenom;
    private String email ;

}
