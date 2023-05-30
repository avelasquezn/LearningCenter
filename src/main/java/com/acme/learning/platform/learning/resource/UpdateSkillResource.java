package com.acme.learning.platform.learning.resource;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateSkillResource {
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String name;
}
