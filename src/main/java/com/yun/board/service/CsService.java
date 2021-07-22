package com.yun.board.service;

import java.util.List;
import com.yun.board.domain.Cs;

public interface CsService {
  int add(Cs cs);
  List<Cs> list(int meno,int pageNo, int pageSize);
  Cs get(int no);
  void delete(int no);
  int update(Cs cs);
  List<Cs>findByMaster(int cspageNo, int cspageSize);
  List<Cs> pageMaster(int pageNo, int pageSize);
  int addQuestioninfo(Cs cs);
  int countByMaster();
  List<Cs> csPage(int cspageNo, int cspageSize);
  
}