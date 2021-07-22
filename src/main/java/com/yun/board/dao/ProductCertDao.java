package com.yun.board.dao;

import java.util.List;
import java.util.Map;
import com.yun.board.domain.ProductCert;

public interface ProductCertDao {
  
  // 전체조회
  List<ProductCert> findAll(Map<String,Object> params);

  // 인증서번호 조회
  ProductCert findByNo(int no); 
  
  // 클래스번호 조회
  List<ProductCert> findAllByCno(Map<String,Object> params);
  
  // 멘티번호 조회
  List<ProductCert> findAllByMeno(Map<String,Object> params);
  
  int insert(ProductCert prct);
  int update(ProductCert prct);
  
  
}
