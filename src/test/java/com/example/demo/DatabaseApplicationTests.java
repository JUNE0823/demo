package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ibatis.session.SqlSessionFactory;

@SpringBootTest
class DatabaseApplicationTests {

  @Autowired
  private SqlSessionFactory factory ;

  @Test
  public void testByFactory() {
    try{
      System.out.println(">>>>>>>>>>>>>>>> factory");
      System.out.println(factory.toString());
      System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
      
    } catch(Exception e) {
      e.printStackTrace();
    }
  }


}