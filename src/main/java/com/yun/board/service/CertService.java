package com.yun.board.service;

import java.util.List;
import com.yun.board.domain.Cert;

public interface CertService {
 
  List<Cert> listByMeno(int pageNo, int pageSize, int meno);
  
  int insertCert(Cert cert);

  
  Cert get(int no);
}
