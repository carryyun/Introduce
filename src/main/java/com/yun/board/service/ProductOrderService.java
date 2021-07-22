package com.yun.board.service;

import java.util.List;
import com.yun.board.domain.ProductOrder;

public interface ProductOrderService {

  List<ProductOrder> list(int pageNo, int pageSize);
  
  List<ProductOrder> listByMaster(int pageNo, int pageSize);
  List<ProductOrder> proPage(int pageNo, int pageSize);
  int countpro();

  // 주문 번호로 조회
  ProductOrder get(int no);

  // 주문자 번호로 조회
  List<ProductOrder> listByMeno(int meno,int pageNo, int pageSize);

  // 공예품 번호로 조회
  List<ProductOrder> listByPtno(int pageNo, int pageSize, int ptno);
  

  int add(ProductOrder productOrder);
  
  int adddeliveryinfo(ProductOrder productOrder);


}
