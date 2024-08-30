package com.example.demo.test.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

import com.example.demo.test.domain.comment.CommentResponseDTO;

@Setter
@Getter
@ToString
public class BbsResponseDTO {

  private int id;
  private String title;
  private String content;
  private ArrayList<CommentResponseDTO> comments;
}
