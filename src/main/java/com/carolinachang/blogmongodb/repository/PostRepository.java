package com.carolinachang.blogmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carolinachang.blogmongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
