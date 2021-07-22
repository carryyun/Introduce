package com.yun.board.dao;

import java.util.List;
import java.util.Map;
import com.yun.board.domain.MiddleTag;

public interface MiddleTagDao {
  List<MiddleTag> findAll(); // 전체조회

  MiddleTag findByName(String name); // 중분류명
 
  MiddleTag findByNo(int no); // 중분류번호

  List<MiddleTag> findAllByBtno(Map<String,Object> params);
  
}
