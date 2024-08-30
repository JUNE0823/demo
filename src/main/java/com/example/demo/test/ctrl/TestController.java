package com.example.demo.test.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.test.domain.BbsResponseDTO;


// spring container는 TestController testController = new TestController();
@Controller
public class TestController {
  
  @RequestMapping("/index.kdt")
  public String index(Model model) {
    System.out.println("debug >> test controller index client path : /index.kdt");

    // model에 심는 건 request 심는 것과 같은 역할
    model.addAttribute("msg","처음으로 만나는 스프링 부트");
    return "index";
  }

  @RequestMapping(value = "/api/bbs/ctrl/test", method = RequestMethod.GET)
  @ResponseBody
  public BbsResponseDTO test() {
    // BbsResponseDTO response = BbsResponseDTO.builder()
    //   .id(1)
    //   .title("test")
    //   .content("test")
    //   .build();
    return null;
  }
  

  
}