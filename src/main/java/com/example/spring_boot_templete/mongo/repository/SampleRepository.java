package com.example.spring_boot_templete.mongo.repository;

import com.example.spring_boot_templete.mongo.model.User;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SampleRepository {
    private final MongoTemplate mongoTemplate;

    public SampleRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<User> Helloworld() {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").regex("^A"));
        List<User> users = mongoTemplate.find(query,User.class);
        return users;
    }
}
