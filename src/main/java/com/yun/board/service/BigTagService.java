package com.yun.board.service;

import java.util.List;
import com.yun.board.domain.BigTag;

public interface BigTagService {
 
  List<BigTag> list(); 
  
  BigTag get(int no);
  
  BigTag get(String name);
  
  List<BigTag> listByMono(int no); 
  
}
