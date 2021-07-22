package com.yun.board.service;

import java.util.List;
import com.yun.board.domain.Timetable;

public interface TimetableService {
  List<Timetable> list(int pageNo, int pageSize);
  List<Timetable> findByCno(int cno);
  
  Timetable get(int no);
  int add(Timetable timetable);
  int delete(int ctno);
  int update(Timetable timetable);
  int capaUpdate(int ttno);
  
}
