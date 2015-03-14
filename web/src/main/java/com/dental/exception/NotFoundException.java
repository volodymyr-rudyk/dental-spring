package com.dental.exception;

/**
 * Created by light on 3/14/2015.
 */
public class NotFoundException extends Exception {

    private String message;
    private String url;


    public NotFoundException(String url) {
        this.url = url;
        this.message = "URL not found";
    }

    public NotFoundException(String url, String message) {
        super(message);
        this.url = url;
        this.message = message;
    }

    public NotFoundException(String url, String message, Throwable throwable) {
        super(message, throwable);
        this.url = url;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
