package com.acme.learning.platform.learning.mapping;

import com.acme.learning.platform.learning.domain.model.Skill;
import com.acme.learning.platform.learning.resource.CreateSkillResource;
import com.acme.learning.platform.learning.resource.SkillResource;
import com.acme.learning.platform.learning.resource.UpdateSkillResource;
import com.acme.learning.platform.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;


public class SkillMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public SkillResource toResource(Skill model) {
        return mapper.map(model, SkillResource.class);
    }

    public Page<SkillResource> modelListPage(List<Skill>modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, SkillResource.class), pageable, modelList.size());
    }

    public Skill toModel(CreateSkillResource resource) {
        return mapper.map(resource, Skill.class);
    }

    public Skill toModel(UpdateSkillResource resource) {
        return mapper.map(resource, Skill.class);
    }
}
