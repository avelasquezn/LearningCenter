package com.acme.learning.platform.security.domain.model.entity;

import com.acme.learning.platform.security.domain.model.enumeration.Roles;
import com.acme.learning.platform.shared.domain.model.AuditModel;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name = "roles")
public class Role extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Roles name;
}
