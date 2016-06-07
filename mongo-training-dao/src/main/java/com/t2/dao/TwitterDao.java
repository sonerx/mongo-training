package com.t2.dao;


import com.t2.dao.data.Tweet;
import twitter4j.Status;

import java.util.List;

/**
 * User: sonic
 */
public interface TwitterDao {

    void save(Tweet tweet);
    Tweet findById(Object id);
    List searchTweets(String searchTerm, int limit);
    List nearSphere(int limit);
}
