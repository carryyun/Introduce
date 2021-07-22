package com.yun.board.dao;

import java.util.List;
import com.yun.board.domain.ProductPopul;

public interface ProductPopulDao {
  
  // 전체조회
  List<ProductPopul> findAll(); 
  
  int insert(int no);
  int delete();

}
