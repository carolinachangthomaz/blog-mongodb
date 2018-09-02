package com.carolinachang.blogmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carolinachang.blogmongodb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
