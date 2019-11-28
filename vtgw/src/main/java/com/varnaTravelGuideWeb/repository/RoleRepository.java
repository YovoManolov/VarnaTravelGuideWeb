package com.varnaTravelGuideWeb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.varnaTravelGuideWeb.domain.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
    Role findByRole(String role);
}