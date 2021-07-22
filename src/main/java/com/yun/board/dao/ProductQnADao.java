package com.yun.board.dao;

import java.util.List;
import java.util.Map;
import com.yun.board.domain.ProductQnA;

public interface ProductQnADao {
  
  // 전체조회
  List<ProductQnA> findAll(Map<String,Object> params); 

  // 질문번호 조회
  ProductQnA findByNo(int no); // 질문번호 조회
  
  // 질문자번호 조회
  List<ProductQnA> findAllByMeno(Map<String,Object> params); // 멘티번호로 조회해서 마이페이지에 
  
  List<ProductQnA> findAllByMeno2(Map<String,Object> params); // 판매자번호로 조회해서 마이페이지에 
  
  // 공예품번호 조회 
  List<ProductQnA> findAllByPtno(Map<String,Object> params); 
  
  // 질문 번호로 조회
  List<ProductQnA> findAllByQno(int no);
  
  // 삽입
  int insert(ProductQnA productQnA);
  
  // 갱신
  int update(ProductQnA productQnA);
  
  // 답변 갱신
 int updateAnser(ProductQnA productQnA);
  
  
}
