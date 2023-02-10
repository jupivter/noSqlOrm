package com.nosqlorm.nosqlorm.repository;

import com.nosqlorm.nosqlorm.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {
}
