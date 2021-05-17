package org.example.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.example.MyBean;

@ApplicationScoped
public class MyBeanService {
  @Inject
  MyBean myBean;

  public MyBean getMyBean() {
    return myBean;
  }
}
