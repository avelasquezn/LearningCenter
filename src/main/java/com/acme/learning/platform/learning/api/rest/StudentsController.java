package com.acme.learning.platform.learning.api.rest;

import com.acme.learning.platform.learning.domain.service.StudentService;
import com.acme.learning.platform.learning.mapping.StudentMapper;
import com.acme.learning.platform.learning.resource.CreateStudentResource;
import com.acme.learning.platform.learning.resource.StudentResource;
import com.acme.learning.platform.learning.resource.UpdateStudentResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")
public class StudentsController {
    private final StudentService studentService;

    private final StudentMapper mapper;


    public StudentsController(StudentService studentService, StudentMapper mapper) {
        this.studentService = studentService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<StudentResource> getAllStudents(Pageable pageable) {
        return mapper.modelListPage(studentService.getAll(), pageable);
    }

    @GetMapping("{studentId}")
    public StudentResource getStudentById(@PathVariable Long studentId) {
        return mapper.toResource(studentService.getById(studentId));
    }

    @PostMapping
    public ResponseEntity<StudentResource> createStudent(CreateStudentResource resource) {
        return new ResponseEntity<>(mapper.toResource(studentService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }

    @PutMapping("{studentId}")
    public StudentResource updateStudent(@PathVariable Long studentId,
                                         @RequestBody UpdateStudentResource resource) {
        return mapper.toResource(studentService.update(studentId, mapper.toModel(resource)));
    }

    @DeleteMapping("{studentId}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long studentId) {
        return studentService.delete(studentId);
    }
}
