package com.inssolutions.student.repo;

import com.inssolutions.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {
    List<Student> findAllBySchoolId(Integer schoolId);
}
