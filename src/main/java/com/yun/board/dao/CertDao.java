package com.yun.board.dao;

import java.util.List;
import java.util.Map;
import com.yun.board.domain.Cert;

public interface CertDao {
  List<Cert> findAll();
  Cert findByNo(int no);
  
  List<Cert> findByMeno(Map<String, Object> params);
  
  int insertCert(Cert cert); // 마이페이지 - 클래스관리 - 멘토가 수료처리 : 수료증발급

}