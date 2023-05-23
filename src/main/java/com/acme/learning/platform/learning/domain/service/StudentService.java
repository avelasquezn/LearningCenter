package com.acme.learning.platform.learning.domain.service;

import com.acme.learning.platform.learning.domain.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {
    List<Student> getAll();
    Page<Student> getAll(Pageable pageable);

    Student getById(Long studentId);

    Student create(Student student);

    Student update(Long studentId, Student student);

    ResponseEntity<?> delete(Long studentId);
}
