package com.yun.board.service;

import java.util.List;
import com.yun.board.domain.ProductBlock;

public interface ProductBlockService {
 
  List<ProductBlock> list(int pageNo, int pageSize); 
  
  // 멘토 번호로 조회
  List<ProductBlock> listByMono(int pageNo, int pageSize, int mono); 
  
  // 멘티 번호로 조회
  List<ProductBlock> listByMeno(int pageNo, int pageSize, int meno);
  
  // 입력(추가)
  int add(ProductBlock productBlock);

  // 갱신
  int update(ProductBlock productBlock);
 
}
