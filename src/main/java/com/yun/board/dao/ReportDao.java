package com.yun.board.dao;

import java.util.List;
import java.util.Map;
import com.yun.board.domain.Report;

public interface ReportDao {

  
  List<Report> findAll(Map<String,Object> params);
  List<Report> findFinishAll(Map<String,Object> params);
  List<Report> findByStat(Map<String,Object> params);
  List<Report> findByMeno2(Map<String,Object> params);
  Report findByNo(int no);
  
  Report findByMeno(int no);
  int findByMeno2Cnt(int no);
  int insert(Report report);
  int update(Report report);
  int updateReptstat(Report report);
  
  
}
