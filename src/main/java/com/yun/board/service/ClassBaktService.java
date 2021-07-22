package com.yun.board.service;

import java.util.List;
import com.yun.board.domain.ClassBakt;

public interface ClassBaktService {
  
  List<ClassBakt> list(int pageNo, int pageSize);
  
  int add(ClassBakt classbakt);
  
  int update(ClassBakt classbakt);
  
  void delete(int cbno);
  
  List<ClassBakt> listByMeno(int meno);
  
  List<ClassBakt> sumByMeno(int meno);
  
}
