package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.test.domain.BbsRequestDTO;
import com.example.demo.test.service.BbsService;

@SpringBootTest
public class ServiceApplicationTests {
  
  @Autowired
  public BbsService bbsService;

  @Test
  public void saveService() {
    System.out.println("debug  >> junit service save" + bbsService);

    BbsRequestDTO request = BbsRequestDTO.builder()
                                          .title("오늘은 쉽다")
                                          .content("진짜 이렇게 간단한거였어~~").build();
    bbsService.save(request);

    System.out.println("debug >> save OK!!");
  }

  @Test
  public void updateService() {

    System.out.println("debug  >> junit service save" + bbsService);

    BbsRequestDTO request = BbsRequestDTO.builder()
                                          .id(2)
                                          .title("업데이트 더미데이터 ")
                                          .content("더미~~").build();
    bbsService.update(request);

    System.out.println("debug >> update OK!!");
  }
}
