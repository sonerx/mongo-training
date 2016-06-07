package com.t2.dao.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.t2.dao.TwitterDao;
import com.t2.dao.data.Tweet;
import org.springframework.data.domain.Sort;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeospatialIndex;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import twitter4j.Status;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;

/**
 * Created by soner on 22/02/16.
 */
@Repository(value="twitterDao")
public class TwitterMongoDaoImpl extends BaseMongoDao implements TwitterDao {

    private Random random = new Random();

    @PostConstruct
    private void indexOps() {
        mongoTemplate.indexOps(Tweet.class).ensureIndex( new GeospatialIndex("geoLocation").typed(GeoSpatialIndexType.GEO_2DSPHERE) );
    }

    @Override
    @Async
    public void save(Tweet tweet) {
        mongoTemplate.save(tweet);
    }

    @Override
    public Tweet findById(Object id) {
        return mongoTemplate.findById(id, Tweet.class);
    }



    @Override
    public List searchTweets(String searchTerm, int limit) {
        return mongoTemplate.find(
                new Query(Criteria.where("text").is(searchTerm).regex(searchTerm, "i")).limit(limit),
                Tweet.class);
    }

    @Override
    public List nearSphere(int limit) {
        Point point = new Point(random.nextDouble() * 360 -180, random.nextDouble() * 180 -90);
        return mongoTemplate.find(
                new Query(Criteria.where("geoLocation").
                        nearSphere(point)
                        .maxDistance(random.nextDouble() * 100))
                        .limit(30), Tweet.class);
    }
}
