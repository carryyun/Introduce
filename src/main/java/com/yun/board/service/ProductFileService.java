package com.yun.board.service;

import java.util.List;
import com.yun.board.domain.ProductFile;

public interface ProductFileService {
 
  // 전체조회
  List<ProductFile> list(int pageNo, int pageSize); 
  
  // 공예품 번호로 조회
  List<ProductFile> listByPtno(int ptno);
  
  int add(ProductFile profile); // insert
  int update(ProductFile profile); // update
  
  int delete(ProductFile profile); // delete
  
}
