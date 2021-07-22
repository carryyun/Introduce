package com.yun.board.dao;

import java.util.List;
import java.util.Map;
import com.yun.board.domain.Timetable;

public interface TimetableDao {
  List<Timetable> findAll(Map<String,Object> params);
  List<Timetable> findByCno(int cno);

  Timetable findByCtno(int no);
  int capaUpdate(int ttno);
  
  int insert(Timetable timetable);
  int delete(int ctno);
  int update(Timetable timetable);
}
