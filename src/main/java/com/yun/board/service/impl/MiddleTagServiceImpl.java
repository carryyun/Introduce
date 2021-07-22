package com.yun.board.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yun.board.dao.MiddleTagDao;

import com.yun.board.domain.MiddleTag;
import com.yun.board.service.MiddleTagService;

@Service
public class MiddleTagServiceImpl implements MiddleTagService {

  //@Autowired BigTagDao bigtagDao;
  @Autowired
  MiddleTagDao middletagDao;

  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)

  @Override
  public List<MiddleTag> list() {

    return middletagDao.findAll();

  }

  @Override
  public MiddleTag get(int no) {

    return middletagDao.findByNo(no);
  }

  @Override
  public MiddleTag get(String name) {

    return middletagDao.findByName(name);
  }

  @Override
  public List<MiddleTag> listBtno(int pageNo, int pageSize, int btno) {
    HashMap<String, Object> params = new HashMap<>();
    params.put("rowNo", (pageNo - 1) * pageSize);
    params.put("size", pageSize);
    params.put("bigno", btno);

    return middletagDao.findAllByBtno(params);
  }



}
