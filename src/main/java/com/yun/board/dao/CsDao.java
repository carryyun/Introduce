package com.yun.board.dao;

import java.util.List;
import java.util.Map;
import com.yun.board.domain.Cs;

public interface CsDao {
  int insert(Cs cs);
  List<Cs> findAll(Map<String,Object> params); // 마이페이지 1:1문의
  Cs findByNo(int no);
  int delete(int no);
  int update(Cs cs);
  List<Cs> findByMaster(Map<String, Object> params);//마스터 페이지 문의
  List<Cs> pageMaster(Map<String, Object> params);
  int insertQuestion(Cs cs);
  int countByMaster();
  List<Cs> csPage(Map<String, Object> params);
  
}