package com.yun.board.service;

import java.util.List;
import com.yun.board.domain.MentorLicense;

public interface MentorLicenseService {
  int add(MentorLicense mlicn);
  List<MentorLicense> list(int pageNo, int pageSize);
  List<MentorLicense> get(int no);
  void delete(int no);
  int update(MentorLicense mlicn);

}
