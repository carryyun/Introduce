package com.yun.board.service;

import java.util.List;
import com.yun.board.domain.Report;

public interface ReportService {
  
  
  
  int add(Report report);
  List<Report> list(int pageNo, int pageSize);
  List<Report> finishlist(int pageNo, int pageSize);
  public List<Report> listByStat(int pageNo, int pageSize);
  public List<Report> listByMeno2(int pageNo, int pageSize,int meno2);
  Report get(int no);
  void update(Report report);
  
  int getMeno2Cnt(int no);
  
  int updateReptstat(Report report);

}
