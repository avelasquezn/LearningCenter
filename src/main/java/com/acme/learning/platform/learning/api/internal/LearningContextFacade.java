package com.acme.learning.platform.learning.api.internal;

import com.acme.learning.platform.learning.domain.model.Skill;
import com.acme.learning.platform.learning.domain.model.Student;

import java.util.List;

public interface LearningContextFacade {
    List<Skill> getAllSkills();
    List<Student> getAllStudents();
}
