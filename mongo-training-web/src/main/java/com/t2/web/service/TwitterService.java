package com.t2.web.service;


import java.util.List;

/**
 * User: sonic
 */
public interface TwitterService {

    void startListening();
    void stopListening();
    List nearSphere();
    List search(String searchText);
}
