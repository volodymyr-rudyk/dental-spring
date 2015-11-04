package com.dental.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vrudyk on 11/3/2015.
 */
@RestController
public class TestController {

  @RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Node> js() {
    return new ResponseEntity<Node>(new Node(), HttpStatus.OK);
  }

  @RequestMapping(value = "/test2", method = RequestMethod.GET, produces = "application/json")
  public Node js2() {
    return new Node();
  }

  @RequestMapping(value = "/test3", method = RequestMethod.GET)
  public Node js3() {
    return new Node();
  }


  private static class Node {
    private String s1 = "test1";
    private String s2 = "test2";
    private String s3 = "test3";

    public String getS1() {
      return s1;
    }

    public void setS1(String s1) {
      this.s1 = s1;
    }

    public String getS2() {
      return s2;
    }

    public void setS2(String s2) {
      this.s2 = s2;
    }

    public String getS3() {
      return s3;
    }

    public void setS3(String s3) {
      this.s3 = s3;
    }
  }

}
