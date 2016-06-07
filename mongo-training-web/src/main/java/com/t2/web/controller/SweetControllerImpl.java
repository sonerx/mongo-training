package com.t2.web.controller;

import com.t2.web.service.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * User: sonic
 */
@Controller
@RequestMapping(value = "/mongo-training")
public class SweetControllerImpl implements SweetController {

    @Autowired
    private TwitterService twitterService;

    @Override
    @RequestMapping(value = "/search", method = {RequestMethod.GET})
    @ResponseBody
    public List search(String searchText) {
        return twitterService.search(searchText);
    }

    @Override
    @RequestMapping(value = "/near-sphere", method = {RequestMethod.GET})
    @ResponseBody
    public List nearSphere() {
        return twitterService.nearSphere();
    }

    @Override
    @RequestMapping(value = "/start-listening", method = {RequestMethod.GET})
    @ResponseBody
    public void startListening() {
        twitterService.startListening();
    }

    @Override
    @RequestMapping(value = "/stop-listening", method = {RequestMethod.GET})
    @ResponseBody
    public void stopListening() {
        twitterService.stopListening();
    }


}