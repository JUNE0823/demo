package com.example.demo.test.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class BbsRequestDTO {
  private int id;
  private String title;
  private String content;  
}
