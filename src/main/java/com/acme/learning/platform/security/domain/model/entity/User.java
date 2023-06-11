package com.acme.learning.platform.security.domain.model.entity;

import com.acme.learning.platform.shared.domain.model.AuditModel;
import io.cucumber.java.ro.Si;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotNull
    @Size(max = 60)
    @Column(unique = true)
    private String username;

    @NotNull
    @NotBlank
    @Size(max = 50)
    @Column(unique = true)
    @Email
    private String email;

    @NotBlank
    @Size(max=120)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();


    public User(@NotNull String username, @NotNull String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
