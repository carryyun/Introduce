package com.yun.board.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yun.board.dao.BigTagDao;

import com.yun.board.domain.BigTag;
import com.yun.board.service.BigTagService;
@Service
public class BigTagServiceImpl implements BigTagService {

  @Autowired BigTagDao bigtagDao;

  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)

  @Override
  public List<BigTag> list() {


    return bigtagDao.findAll();

  }

  @Override
  public BigTag get(int no) {

    return bigtagDao.findByNo(no);
  }

  @Override
  public BigTag get(String name) {

    return bigtagDao.findByName(name);
  }

  @Override
  public List<BigTag> listByMono(int no) {
    return bigtagDao.findByMono(no);
  }



}
