package com.yun.board.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yun.board.dao.MenteeDao;
import com.yun.board.dao.MentorDao;

import com.yun.board.domain.Mentor;
import com.yun.board.service.MentorService;

@Service
public class MentorServiceImpl implements MentorService {
  
  @Autowired MentorDao mentorDao;
  @Autowired MenteeDao menteeDao;

  
  
  @Override
  public int add(Mentor mentor) {
    return mentorDao.insert(mentor);
  }

  @Override
  public int delete(int no) {
    return 0;
  }
  
  @Override
  public int update(Mentor mentor) {
    return mentorDao.update(mentor);
  }

  @Override
  public List<Mentor> listByNick(int pageSize, String nick) {
    // TODO Auto-generated method stub
    return null;
  }
  @Override
  public List<Mentor> listByPhone(int pageSize, String phone) {
    // TODO Auto-generated method stub
    return null;
  }
  
  @Override
  public List<Mentor> list() {
//    Map<String,Object> params = new HashMap<>();
//    params.put("pagesize", pageSize);
//    params.put("no", no);
    return mentorDao.findAll();
  }

  @Override
  public Mentor get(int no) {
    return mentorDao.findByNo(no);
  }

  @Override
  public List<Mentor> listByEmail(int pageSize, String email) {
    // TODO Auto-generated method stub
    return null;
  }
  
  @Override
  public List<Mentor> listByMetoStat(int pageNo , int pageSize) {
    HashMap<String, Object> params = new HashMap<>();
    params.put("pageNo", (pageNo -1 ) * pageSize);
    params.put("pageSize", pageSize);
    
    return mentorDao.findMentorRequest(params);
  }

}
