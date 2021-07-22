package com.yun.board.service;

import java.util.List;
import com.yun.board.domain.Notice;

public interface NoticeService {
  
  List<Notice> list(int pageNo, int pageSize);
  List<Notice> listByMeno(int pageNo, int pageSize, int meno);
  int add(Notice noti);
  Notice get(int no);
  int update(Notice noti);
  
  int remove(int no);

}
