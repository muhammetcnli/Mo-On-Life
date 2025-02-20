package com.atlas.Mo_on_Life.exception;

public class PostNotFoundException extends RuntimeException{

    public PostNotFoundException(String message){
        super(message); // Custom exception for post being empty
    }
}
