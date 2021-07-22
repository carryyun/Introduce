
package com.yun.board.service;

import java.util.List;
import com.yun.board.domain.ProductRep;

public interface ProductRepService {

  // 공예품 번호로 조회
  List<ProductRep> listByPtno(int pageNo, int pageSize, int ptno);
  
  List<ProductRep> listbyRgdt();
  
  List<ProductRep> list(int pageNo, int pageSize);

  // 댓글 번호로 조회
  ProductRep get(int no);

  // 작성자 번호로 조회
  List<ProductRep> listByMeno(int pageNo, int pageSize, int meno);



  // 입력(추가)
  int add(ProductRep productRep);

  // 갱신
  int update(ProductRep productRep);
  
  // 삭제
  int delete(int no);

}
