package com.acme.learning.platform.learning.resource;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateSkillResource {
    @NotNull
    @NotBlank
    @Size(max = 60)
    private String name;
}
