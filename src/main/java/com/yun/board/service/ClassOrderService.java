package com.yun.board.service;

import java.util.List;
import com.yun.board.domain.ClassOrder;

public interface ClassOrderService {

  List<ClassOrder> listByMeno(int meno , int pageNo, int pageSize);

  void orderadd(ClassOrder classorder);

  List<ClassOrder> listByMaster(int pageNo, int pageSize); // 관리자- 클래스 조회

  int listByCno(int no , int meno);
  
  List<ClassOrder> findBycnoFormeno(int no);
  
  int countorderlist();
}
