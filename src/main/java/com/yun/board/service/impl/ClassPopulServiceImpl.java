package com.yun.board.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yun.board.dao.ClassPopulDao;

import com.yun.board.domain.ClassPopul;
import com.yun.board.service.ClassPopulService;

@Service
public class ClassPopulServiceImpl implements ClassPopulService {

  @Autowired
  ClassPopulDao classPopulDao;

  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)

  @Override
  public List<ClassPopul> list() {

    return classPopulDao.findAll();

  }

}
