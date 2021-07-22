package com.yun.board.dao;

import java.util.List;
import java.util.Map;
import com.yun.board.domain.MentorLicense;

public interface MentorLicenseDao {
  List<MentorLicense> findAll(Map<String,Object> params);
  int insert(MentorLicense mlicn);
  List<MentorLicense> findByNo(int no);
  int delete(int no);
  int update(MentorLicense mlicn);

}
