package com.acme.learning.platform.learning.domain.persistence;

import com.acme.learning.platform.learning.domain.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByAge(int age);
    Student findByName(String name);
}
