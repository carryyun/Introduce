package com.yun.board.web;

import java.util.List;
import javax.servlet.ServletContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.yun.board.domain.ClassRep;
import com.yun.board.service.ClassRepService;

@Controller
@RequestMapping("/classdetail")
public class ClassRepController {
  
  ClassRepService classRepService;
  ServletContext sc;
  
  public ClassRepController(ClassRepService classRepService) {
    this.classRepService = classRepService;
    System.out.println("ClassRepController 호출");
  }
  
  @GetMapping("findAll")
  public void findAll() {
    System.out.println("findAll 호출");
    List<ClassRep> clist= classRepService.repList();

    for(ClassRep c : clist) {

      System.out.println(c.getTitl());
      System.out.println(c.getConts());
    }
  }
  
  
}

