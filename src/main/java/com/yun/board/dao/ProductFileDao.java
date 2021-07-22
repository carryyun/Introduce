package com.yun.board.dao;

import java.util.List;
import java.util.Map;
import com.yun.board.domain.ProductFile;

public interface ProductFileDao {

  // 전체조회
  List<ProductFile> findAll(Map<String,Object> params);
  
  // 공예품 번호로 조회
  List<ProductFile> findAllByPtno(int ptno);
  
  // 일단 만들어 놨음
  int insert(ProductFile profile);
  int update(ProductFile profile);
  
  int delete(ProductFile profile);
  
  
}
