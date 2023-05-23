package com.acme.learning.platform.learning.service;

import com.acme.learning.platform.learning.domain.model.Student;
import com.acme.learning.platform.learning.domain.persistence.StudentRepository;
import com.acme.learning.platform.learning.domain.service.StudentService;
import com.acme.learning.platform.shared.exception.ResourceNotFoundException;
import com.acme.learning.platform.shared.exception.ResourceValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class StudentServiceImpl implements StudentService {
    private static final String ENTITY = "Student";

    private final StudentRepository studentRepository;

    private final Validator validator;

    public StudentServiceImpl(StudentRepository studentRepository, Validator validator) {
        this.studentRepository = studentRepository;
        this.validator = validator;
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Page<Student> getAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public Student getById(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, studentId));
    }

    @Override
    public Student create(Student student) {

        // Constraints validation
        Set<ConstraintViolation<Student>> violations = validator.validate(student);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        // Name uniqueness validation

        Student studentWithName = studentRepository.findByName(student.getName());

        if(studentWithName != null)
            throw new ResourceValidationException(ENTITY,
                    "An student with the same name already exists.");

        // Perform creation operation

        return studentRepository.save(student);
    }

    @Override
    public Student update(Long studentId, Student student) {
        // Constraints validation
        Set<ConstraintViolation<Student>> violations = validator.validate(student);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        // Name uniqueness validation

        Student studentWithName = studentRepository.findByName(student.getName());

        if(studentWithName != null && !studentWithName.getId().equals(student.getId()))
            throw new ResourceValidationException(ENTITY,
                    "An student with the same name already exists.");

        // Perform update operation

        return studentRepository.findById(studentId).map(studentToUpdate ->
            studentRepository.save(
                    studentToUpdate.withName(student.getName())
                            .withAge(student.getAge())
                            .withAddress(student.getAddress())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, studentId));

    }

    @Override
    public ResponseEntity<?> delete(Long studentId) {
        return studentRepository.findById(studentId).map(student -> {
            studentRepository.delete(student);
            return ResponseEntity.ok().build();})
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, studentId));
    }
}
