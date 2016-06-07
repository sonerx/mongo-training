package com.t2.dao.mongo;

import com.mongodb.Mongo;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created by soner on 01/06/16.
 */
public class MongoTemplateFactory {

    private Mongo mongo;
    private String databaseName;

    public Mongo getMongo() {
        return mongo;
    }

    public void setMongo(Mongo mongo) {
        this.mongo = mongo;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public MongoTemplate getMongoTemplate() {
        try {
            return new MongoTemplate(mongo, databaseName);
        }
        catch (Throwable t) {
            t.printStackTrace();
            return null;
        }
    }
}
