package com.varnaTravelGuideWeb.repository;

import org.springframework.stereotype.Repository;
import com.varnaTravelGuideWeb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	   User findByEmail(String email);
}
