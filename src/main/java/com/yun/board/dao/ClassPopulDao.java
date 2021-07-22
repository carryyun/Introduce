package com.yun.board.dao;

import java.util.List;
import com.yun.board.domain.ClassPopul;

public interface ClassPopulDao {
  
  // 전체조회
  List<ClassPopul> findAll(); 
  int insert(int no);
  int delete();
}
