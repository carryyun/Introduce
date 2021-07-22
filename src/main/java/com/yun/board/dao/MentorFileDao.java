package com.yun.board.dao;

import java.util.List;
import java.util.Map;
import com.yun.board.domain.MentorFile;

public interface MentorFileDao {
  List<MentorFile> findAll(Map<String,Object> params);
  int insert(MentorFile mfile);
  List<MentorFile> findByNo(int no);
  int delete(int no);
  int update(MentorFile mfile);

}
