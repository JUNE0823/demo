package com.example.demo.test.domain.comment;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommentRequestDTO {
  
  private String content;
  private int bbsId;

}
