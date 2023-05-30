package com.acme.learning.platform.learning.domain.service;

import com.acme.learning.platform.learning.domain.model.Skill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SkillService {
    List<Skill> getAll();
    Page<Skill> getAll(Pageable pageable);

    Skill getBydId(Long skillId);

    Skill create(Skill skill);
    Skill update(Long id, Skill skill);

    ResponseEntity<?> delete(Long skillId);

    Skill addCriterionToSkill(Long skillId, String criterionName);

}
