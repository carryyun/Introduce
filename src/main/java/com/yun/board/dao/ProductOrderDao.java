package com.yun.board.dao;

import java.util.List;
import java.util.Map;
import com.yun.board.domain.ProductOrder;

public interface ProductOrderDao {
  
  List<ProductOrder> findAll(Map<String,Object> params); // 전체조회 
  
  List<ProductOrder> findByMeno(Map<String,Object> params); // 마이페이지 상품결제내역

  List<ProductOrder> findAllMaster(Map<String, Object> params); // 관리자조회
  int countpro();
  List<ProductOrder> proPage(Map<String,Object> params);
  
  
  ProductOrder findByNo(int no); // 주문번호
  
  List<ProductOrder> findAllByMeno(Map<String,Object> params); // 주문자번호
  
  List<ProductOrder> findAllByPtno(Map<String,Object> params); // 공예품번호
  
  List<Integer> selrecommendproduct();
  
  // 삽입
  int insert(ProductOrder productOrder);
  
  int delInsert(ProductOrder productOrder);
  
  
}
