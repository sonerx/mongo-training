package com.t2.dao.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.annotation.PostConstruct;

/**
 * User: sonic
 */
public abstract class BaseMongoDao {

    @Autowired
    @Qualifier("mongoTemplate")
    protected MongoOperations mongoTemplate;

    @PostConstruct
    protected void afterPropertiesSet() {
        init();
    }

    protected void init() {

    }
}