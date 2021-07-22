package com.yun.board.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yun.board.dao.MentorTagDao;

import com.yun.board.domain.MentorTag;
import com.yun.board.service.MentoTagService;

@Service
public class MentoTagServiceImpl implements MentoTagService {

  @Autowired
  MentorTagDao mentoTagDao;

  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)

  @Override
  public List<MentorTag> list(int pageNo, int pageSize) {

    HashMap<String, Object> params = new HashMap<>();
    params.put("rowNo", (pageNo - 1) * pageSize);
    params.put("size", pageSize);

    return mentoTagDao.findAll(params);

  }


  @Override
  public List<MentorTag> listByMono(int pageNo, int pageSize, int mono) {
    HashMap<String, Object> params = new HashMap<>();
    params.put("rowNo", (pageNo - 1) * pageSize);
    params.put("size", pageSize);
    params.put("mentoNo", mono);

    return mentoTagDao.findAllByMono(params);
  }

  @Override
  public List<MentorTag> listByBtno(int pageNo, int pageSize, int btno) {
    HashMap<String, Object> params = new HashMap<>();
    params.put("rowNo", (pageNo - 1) * pageSize);
    params.put("size", pageSize);
    params.put("bigtagNo", btno);

    return mentoTagDao.findAllByBtno(params);
  }


  @Override
  public int add(MentorTag mentorTag) {
    return mentoTagDao.insert(mentorTag);
  }
  
  @Override
  public int update(MentorTag mentorTag) {
    return mentoTagDao.update(mentorTag);
  }

  @Transactional
  @Override
  public void delete(int no) {

    if (mentoTagDao.delete(no) == 0) {
      throw new RuntimeException("해당 번호의 데이터가 없습니다.");
    }
  }



}
