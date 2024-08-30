package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.test.domain.BbsRequestDTO;
import com.example.demo.test.domain.BbsResponseDTO;
import com.example.demo.test.mapper.BbsMapper;

@SpringBootTest
public class MybatisApplicationTest {

  @Autowired
  private BbsMapper bbsMapper;

  @Test
  public void saveTest() {
    System.out.println("debug mapper >>" + bbsMapper);
    BbsRequestDTO request = BbsRequestDTO.builder()
                                          .title("test")
                                          .content("asdflkjg").build();
    bbsMapper.saveRow(request);
    System.out.println("debug >>> save success!!");
  }

  @Test
  public void selectTest() {
    System.out.println("debug >>> " + bbsMapper);
    List<BbsResponseDTO> result = bbsMapper.selectRow();
    for(BbsResponseDTO dto : result) {
      System.out.println(dto.getTitle()+"\t"+dto.getContent());
    }
  }

  @Test
  public void selectOne() {
    System.out.println("debug mapper >>>>>> " + bbsMapper);
    Map<String, Integer> map = new HashMap();
    map.put("id", 1);
    Optional<BbsResponseDTO> response =  bbsMapper.getRow(map);
    System.out.println("debugg >> select One" + response.get());
  }

  @Test
  public void deleteOne() {
    System.out.println("debug mapper >>>>>> " + bbsMapper);
    Map<String, Integer> map = new HashMap();
    map.put("id", 1);
    bbsMapper.deleteRow(map);
    System.out.println("debugg >> delete success!!");
  }
  
}
