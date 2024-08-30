package com.example.demo.test.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.test.domain.BbsRequestDTO;
import com.example.demo.test.domain.BbsResponseDTO;
import com.example.demo.test.domain.comment.CommentRequestDTO;
import com.example.demo.test.service.BbsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.PostMapping;




// user : http://localhost:7777/api/bbs
@RestController
@RequestMapping("api/bbs")
@Tag(name = "BBS API", description = "게시글 관련 API 목록")
public class BbsController {
  
  @Autowired
  private BbsService bbsService;

  /*
   * 파라미터로 전달되는 id에 해당하는 데이터를 삭제한다면?
   * user endpoint : http://localhost:7777/api/bbs/delete/2
   */
  @DeleteMapping("delete/{id}")
  @Operation(summary = "게시글 삭제", description = "게시글 키값을 가지고 삭제한다")
  public ResponseEntity<String> delete(@PathVariable Integer id) {
    System.out.println("debug >>> bbs controller client path /delete");
    System.out.println("debug >>> id param value" + id);
    Map<String, Integer> params = new HashMap();
    params.put("id", id);
    bbsService.delete(params);
    return new ResponseEntity<String>(id+" 번쨰 데이터 삭제", HttpStatus.OK);
  }

  @GetMapping("/list")
  public ResponseEntity<List<BbsResponseDTO>> getList() {
    System.out.println("debug >>> bbs controller client path /list");

    List<BbsResponseDTO> result = bbsService.getList();
    return new ResponseEntity<List<BbsResponseDTO>>(result, HttpStatus.OK);
  }
  
  @GetMapping("select/{id}")
  public ResponseEntity<Object> select(@PathVariable Integer id) {
    System.out.println("debug >>> bbs controller client path /select/{id}");
    Map<String, Integer> params = new HashMap();
    params.put("id", id);
    Optional<BbsResponseDTO> data = bbsService.selectData(params);
    if(data.isPresent()){
      return new ResponseEntity<>(data.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>("게시글이 존재하지 않습니다", HttpStatus.OK);
    }
  }

  /**
   * Bbs 새 글을 작성
   * user endpoint : http://localhost:7777/api/bbs/post?title=xxxx&content=xxxx
   */

  // @PostMapping("/post")
  // public ResponseEntity<String> save(@RequestParam("title") String title,
  //                                   @RequestParam("content") String content) {
    
  //   BbsRequestDTO params = BbsRequestDTO.builder()
  //                             .title(title)
  //                             .content(content)
  //                             .build();
  //   bbsService.save(params);
      
  //   return null;
  // }
  

  @PostMapping("/post")
  public ResponseEntity<BbsRequestDTO> save(BbsRequestDTO params) {
    System.out.println("debug >> bbs controller client path /post");
    System.out.println(">>>>>>>>>>>>>>>> request dto, " + params);

    bbsService.save(params);
    return new ResponseEntity<>(params, HttpStatus.OK);
  }
  


 /////////////----------- comment -----------/////////////
// comment 새 글ㅡㄹ 작성
// user endpoint : http://localhost:7777/api/bbs/comment/post?content=xxxx&bbsid=xxxx

  @PostMapping("/comment/post")
  public ResponseEntity<String> postComment(CommentRequestDTO params) {
    System.out.println("debug >> bbs controller client path /comment/post");
    System.out.println(">>>>>>>>>>>>>>>> request dto, " + params);
    
    bbsService.commentSave(params);

    return new ResponseEntity<String>(params.getBbsId()+"에 타임라인 등록완료!!", HttpStatus.OK);
  }
  
  @PatchMapping("update/{id}")
  public ResponseEntity<BbsRequestDTO> update(BbsRequestDTO params){
    bbsService.update(params);
    return new ResponseEntity<>(params, HttpStatus.OK);
  }
  


}
