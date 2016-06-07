package com.t2.web.controller;

import java.util.List;

/**
 * User: sonic
 */
public interface SweetController {

    List search(String text);
    List nearSphere();
    void startListening();
    void stopListening();

}
