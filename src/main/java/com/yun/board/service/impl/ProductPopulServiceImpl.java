package com.yun.board.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yun.board.dao.ProductPopulDao;

import com.yun.board.domain.ProductPopul;
import com.yun.board.service.ProductPopulService;

@Service
public class ProductPopulServiceImpl implements ProductPopulService {

  @Autowired
  ProductPopulDao productPopulDao;

  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)

  @Override
  public List<ProductPopul> list() {

    return productPopulDao.findAll();

  }

}
