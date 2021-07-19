package com.yun.board.web;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yun.board.domain.BoardVO;
import com.yun.board.service.BoardService;
import com.yun.board.service.UserService;

@Controller
@RequestMapping("/board")
public class BoardController {
    
    @Autowired
    BoardService boardService;
    @Autowired
    UserService userService;
    
    @GetMapping("/main")
    public void main(@RequestParam(defaultValue = "1") int pageNo,
            @RequestParam(defaultValue="5") int pageSize, 
            Model model) {
        List<BoardVO> list = boardService.list((pageNo-1)*pageSize,pageSize);
        System.out.println(list);
        model.addAttribute("list", list);
        
        int count = boardService.count();
        List<Integer> pageList= new ArrayList<Integer>();
        int limit = count/5;
        if(count%5 != 0) limit++;
        if(count>5) {
            for(int i=1;i<=limit;i++) {
                pageList.add(i);
            }
        }
        model.addAttribute("pageList", pageList);
    }
    @GetMapping("/write")
    public void write(Model model) {
    }
    
    @PostMapping("/write.do")
    public @ResponseBody void writedo(BoardVO boardVO) {
        
        boardService.add(boardVO);
        
    }
    
    @GetMapping("/detail")
    public void detail(int bno, Model model) {
        boardService.updateCnt(bno);
        model.addAttribute("item", boardService.get(bno));
    }
    
    @GetMapping("/edit")
    public void edit(int bno,Model model) {
        model.addAttribute("item", boardService.get(bno));
    }
    @PostMapping("/update.do")
    public @ResponseBody void updatedo(BoardVO boardVO, Model model) {
        boardService.update(boardVO);
    }
	
}
