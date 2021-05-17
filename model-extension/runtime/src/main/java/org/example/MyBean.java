package org.example;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MyBean {
  public String helloWorld(){
    return "Hello world!";
  }
}
