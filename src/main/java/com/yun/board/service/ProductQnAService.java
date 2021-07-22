package com.yun.board.service;

import java.util.List;
import com.yun.board.domain.ProductQnA;

public interface ProductQnAService {
 
  List<ProductQnA> list(int pageNo, int pageSize); 
  
  // 질문 번호로 조회
  ProductQnA get(int no); 
  
  // 질문자 번호로 조회
  List<ProductQnA> listByMeno(int meno,int pageNo, int pageSize);
  
  List<ProductQnA> listByMeno2(int meno,int pageNo, int pageSize);
  
  // 공예품 번호로 조회
  List<ProductQnA> listByPtno(int pageNo, int pageSize, int ptno); 
  
  // 질문 번호로 조회
  List<ProductQnA> listByQno(int no);
  
  // 입력(추가)
  int add(ProductQnA productQnA);

  // 갱신
  int update(ProductQnA productQnA);
  
  // 답변 갱신
  int updateAnser(ProductQnA productQnA);
  
  
}
