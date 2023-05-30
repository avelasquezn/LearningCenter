package com.acme.learning.platform.learning.api.rest;

import com.acme.learning.platform.learning.domain.service.SkillService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/skills", produces = "application/json")
public class SkillsController {
    private final SkillService skillService;


    public SkillsController(SkillService skillService) {
        this.skillService = skillService;
    }
}
