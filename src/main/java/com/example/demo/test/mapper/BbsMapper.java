package com.example.demo.test.mapper;

import java.util.List;
import java.util.ArrayList;

import java.util.Map;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.test.domain.BbsRequestDTO;
import com.example.demo.test.domain.BbsResponseDTO;
import com.example.demo.test.domain.comment.CommentRequestDTO;
import com.example.demo.test.domain.comment.CommentResponseDTO;

/*
 * bbs_tbl과 CRUD 작업을 위한 추상 메서드 선언
 * Mapper는 기존 Dao와 동일한 작업 수행하는 역할
 */

@Mapper
public interface BbsMapper {
  public void saveRow(BbsRequestDTO params);

  public List<BbsResponseDTO> selectRow();

  public Optional<BbsResponseDTO> getRow(Map<String, Integer> params);

  public void deleteRow(Map<String, Integer> params);

  public void updateRow(BbsRequestDTO params);

  public void saveComment(CommentRequestDTO params);

  public ArrayList<CommentResponseDTO> commentSelectRow(Map<String, Integer> params);
}
