package com.yun.board.service;

import java.util.List;
import com.yun.board.domain.ProductBakt;

public interface ProductBaktService {
 
  List<ProductBakt> list(int pageNo, int pageSize); 
  
  // 장바구니 번호로 조회
  ProductBakt get(int no); 
  
  // 공예품 번호로 조회
  List<ProductBakt> listByPtno(int pageNo, int pageSize, int ptno); 
  
  
  List<ProductBakt> listAllByMeno(int no);
  
  int add(ProductBakt productbakt);
  int update(ProductBakt productbakt);
  void delete(int pbno);
  
  List<ProductBakt> sumByMeno(int no);
  
}
