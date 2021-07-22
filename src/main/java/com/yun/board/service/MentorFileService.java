package com.yun.board.service;

import java.util.List;
import com.yun.board.domain.MentorFile;

public interface MentorFileService {
  int add(MentorFile mfile);
  List<MentorFile> list(int pageNo, int pageSize);
  List<MentorFile> get(int no);
  void delete(int no);
  int update(MentorFile mfile);

}
