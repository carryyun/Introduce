package com.yun.board.web;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yun.board.domain.ClassLike;
import com.yun.board.domain.ClassPopul;
import com.yun.board.domain.ClassRep;
import com.yun.board.domain.Classes;
import com.yun.board.domain.Mentee;
import com.yun.board.domain.ProductPopul;
import com.yun.board.domain.ProductRep;
import com.yun.board.service.ClassLikeService;
import com.yun.board.service.ClassPopulService;
import com.yun.board.service.ClassRepService;
import com.yun.board.service.ClassService;
import com.yun.board.service.ProductPopulService;
import com.yun.board.service.ProductRepService;

@Controller
@RequestMapping("/mainpage")
public class MainController {

  ProductPopulService productPopulService;
  ClassPopulService classPopulService;
  ClassLikeService classLikeService;
  ServletContext sc;
  
  ClassRepService classRepService;
  ProductRepService productRepService;
  
  ClassService classService;

  public MainController(ProductPopulService productPopulService,
      ClassPopulService classPopulService, ClassLikeService classLikeService,
      ClassRepService classRepService, ProductRepService productRepService,
      ClassService classService) {
    this.productPopulService = productPopulService;
    this.classPopulService = classPopulService;
    this.classLikeService = classLikeService;
    this.classRepService = classRepService;
    this.productRepService = productRepService;
    this.classService = classService;
    
    System.out.println("mainpage 컨트롤러 생성");
  }
  
  @GetMapping("mainpage")
  public void mainpage(Model model, HttpSession session) {
      //System.out.println("mainpage 컨트롤러 요청");
    List<ProductPopul> pp_list = productPopulService.list();
    List<ProductPopul> pp_product=new ArrayList<>();
    for (ProductPopul p: pp_list ) {
      pp_product.add(p);
    }
    ObjectMapper mapper = new ObjectMapper();
    String jsonTextPrdt="";
    try {
      jsonTextPrdt = mapper.writeValueAsString( pp_product );
      model.addAttribute("pp_list", jsonTextPrdt );
    } catch (JsonProcessingException e) {
      System.out.println(e.getMessage());
    }
    
    
    
    List<ClassPopul> cp_list = classPopulService.list();
    List<ClassPopul> cp_class=new ArrayList<>();
    for (ClassPopul c: cp_list ) {
      cp_class.add(c);
    }
    String jsonTextCls="";
    try {
      jsonTextCls = mapper.writeValueAsString( cp_class );
      model.addAttribute("cp_list", jsonTextCls );
    } catch (JsonProcessingException e) {
      System.out.println(e.getMessage());
    }
    
    Mentee loginUser = (Mentee) session.getAttribute("loginUser");
    if(loginUser != null) {
      List<ClassLike> clike_popul = classLikeService.listByMeno(loginUser.getNo());
      model.addAttribute("clike_popul", clike_popul);
/*      for(ClassLike c : clike_popul) {
        System.out.println(c.getCno());
      }*/
    }
    
    
    List<ClassRep> classRepList = classRepService.listbyRgdt();
    List<ProductRep> productRepList = productRepService.listbyRgdt();
    
    model.addAttribute("classRepList", classRepList);
    model.addAttribute("productRepList", productRepList);
    
    List<Classes> classRanking = classService.listByOrder(1, 7, 7);
    
    model.addAttribute("classRanking",classRanking);
    
    for(Classes c: classRanking) {
//      System.out.println(c.getTitl());
    }
  }
  
  
}


