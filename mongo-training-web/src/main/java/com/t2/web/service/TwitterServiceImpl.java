package com.t2.web.service;

import com.t2.dao.TwitterDao;
import com.t2.dao.data.*;
import com.t2.dao.data.GeoLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.*;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * User: sonic
 * Date: 03/06/14
 */
@Service
public class TwitterServiceImpl implements TwitterService {

    private TwitterStream twitterStream;

    @Autowired
    private TwitterDao twitterDao;

    @Override
    public void startListening() {
        listenTwitter();
    }

    @Override
    public void stopListening() {
        twitterStream.cleanUp();
        twitterStream.shutdown();
    }

    @Override
    public List nearSphere() {
        return twitterDao.nearSphere(30);
    }

    @Override
    public List search(String searchText) {
        return twitterDao.searchTweets(searchText, 30);
    }

    private void listenTwitter() {
        StatusListener listener = new StatusListener(){
            public void onStatus(Status status) {
                twitterDao.save(convertToTweet(status));
            }
            public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {}
            public void onTrackLimitationNotice(int numberOfLimitedStatuses) {}
            @Override
            public void onScrubGeo(long userId, long upToStatusId) {}
            @Override
            public void onStallWarning(StallWarning warning) {}
            public void onException(Exception ex) {
                ex.printStackTrace();
            }
        };
        twitterStream = new TwitterStreamFactory().getInstance();
        twitterStream.addListener(listener);
        twitterStream.sample();
    }

    private Tweet convertToTweet(Status status) {
        Tweet tweet = new Tweet();
        tweet.setId(String.valueOf(status.getId()));
        tweet.setPlace(status.getPlace() != null ? status.getPlace().getFullName() : null);
        tweet.setText(status.getText());
        tweet.setAvatar(status.getUser().getProfileImageURL());

        if (status.getGeoLocation() != null) {
            com.t2.dao.data.GeoLocation location = new GeoLocation();
            location.setLongitude(status.getGeoLocation().getLongitude());
            location.setLatitude(status.getGeoLocation().getLatitude());

            tweet.setGeoLocation(location);
        }

        return tweet;
    }
}