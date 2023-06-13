package com.acme.learning.platform.security.domain.service;

import com.acme.learning.platform.security.domain.model.entity.Role;

import java.util.List;

public interface RoleService {
    void seed();
    List<Role> getAll();
}
