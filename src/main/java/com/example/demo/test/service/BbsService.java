package com.example.demo.test.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.test.domain.BbsRequestDTO;
import com.example.demo.test.domain.BbsResponseDTO;
import com.example.demo.test.domain.comment.CommentRequestDTO;
import com.example.demo.test.domain.comment.CommentResponseDTO;
import com.example.demo.test.mapper.BbsMapper;

@Service
public class BbsService {
  
  @Autowired
  public BbsMapper bbsmapper;

  public List<BbsResponseDTO> getList(){
    System.out.println("debug >>> service getList()");
    List<BbsResponseDTO> result = bbsmapper.selectRow();
    return result;
  }

  public Optional<BbsResponseDTO> selectData(Map<String, Integer> params){
    System.out.println("debug >>> service selectData()");
    
    Optional<BbsResponseDTO> data = bbsmapper.getRow(params);
    System.out.println("debug >>> bbs result " + data);
    ArrayList<CommentResponseDTO> list = bbsmapper.commentSelectRow(params);
    System.out.println("debug >>> comment result " + list);
    if(data.isPresent()) {
      data.get().setComments(list);
    }
    return data;
  }

  public void save(BbsRequestDTO params){
    System.out.println("debug >>> service save()" + bbsmapper);
    bbsmapper.saveRow(params);
  }

  public void update(BbsRequestDTO params){
    System.out.println("debug >>> service update()" + bbsmapper);
    bbsmapper.updateRow(params);
  }

  public void delete(Map<String, Integer> params){
    System.out.println("debug >>> service delete()" + params.get("id"));
    bbsmapper.deleteRow(params);
  }

  public void commentSave(CommentRequestDTO params) {
    System.out.println("debug >>> service commentSave()" + bbsmapper);
    bbsmapper.saveComment(params);
  }
}
