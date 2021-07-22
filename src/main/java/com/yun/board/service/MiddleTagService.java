package com.yun.board.service;

import java.util.List;
import com.yun.board.domain.MiddleTag;

public interface MiddleTagService {
 
  List<MiddleTag> list(); 
  
  MiddleTag get(int no);
  
  MiddleTag get(String name);
  
  List<MiddleTag> listBtno(int pageNo, int pageSize, int btno); 
  
  
}
