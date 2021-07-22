package com.yun.board.service;

import java.util.List;
import com.yun.board.domain.SmallTag;

public interface SmallTagService {
 
  List<SmallTag> list(int pageNo, int pageSize); 
  
  SmallTag get(int no);
  
  SmallTag get(String name);
  
  List<SmallTag> listMtno(int pageNo, int pageSize, int mtno); 
  
  
}
