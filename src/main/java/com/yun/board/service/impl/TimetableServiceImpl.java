package com.yun.board.service.impl;


import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yun.board.dao.TimetableDao;

import com.yun.board.domain.Timetable;
import com.yun.board.service.TimetableService;

@Service
public class TimetableServiceImpl implements TimetableService {

  @Autowired TimetableDao timetableDao;

  @Transactional(rollbackFor=Exception.class)
  @Override
  public int add(Timetable timetable) {

    return timetableDao.insert(timetable);
  }
  
  @Override
  public int capaUpdate(int ttno) {
    return timetableDao.capaUpdate(ttno);
  }

  @Override
  public int update(Timetable timetable) {
    return timetableDao.update(timetable);
  }


  @Override
  public List<Timetable> list(int pageNo, int pageSize) {
    HashMap<String,Object> params = new HashMap<>();
    params.put("rowNo", (pageNo - 1) * pageSize);
    params.put("size", pageSize);

    return timetableDao.findAll(params);
  }

  @Override
  public Timetable get(int no) {
    return timetableDao.findByCtno(no);
  }

  @Override
  public List<Timetable> findByCno(int cno) {
    
    return timetableDao.findByCno(cno);
  }

  @Override
  public int delete(int ctno) {

    return timetableDao.delete(ctno);
  }


}
