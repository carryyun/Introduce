package com.yun.board.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main")
public class MainController {
    
    
    
    @GetMapping("main")
    public void main(Model model) {
        System.out.println("메인페이지");
    }
    @GetMapping("introduce")
    public void introduce(Model model) {
        System.out.println("소개페이지");
    }
}
