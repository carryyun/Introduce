package com.yun.board.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yun.board.dao.ProductRepDao;

import com.yun.board.domain.ProductRep;
import com.yun.board.service.ProductRepService;

@Service
public class ProductRepServiceImpl implements ProductRepService {

  @Autowired
  ProductRepDao productRepDao;

  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)

  @Override
  public List<ProductRep> listByPtno(int pageNo, int pageSize, int ptno) {
    HashMap<String, Object> params = new HashMap<>();
    params.put("rowNo", (pageNo - 1) * pageSize);
    params.put("size", pageSize);
    params.put("ptno", ptno);
    
    return productRepDao.findAllByPtno(params);
  }
  
  
  
  @Override
  public List<ProductRep> list(int pageNo, int pageSize) {

    HashMap<String, Object> params = new HashMap<>();
    params.put("rowNo", (pageNo - 1) * pageSize);
    params.put("size", pageSize);

    return productRepDao.findAll(params);

  }

  @Override
  public List<ProductRep> listByMeno(int pageNo, int pageSize, int meno) {
    HashMap<String, Object> params = new HashMap<>();
    params.put("rowNo", (pageNo - 1) * pageSize);
    params.put("size", pageSize);
    params.put("mentno", meno);

    return productRepDao.findAllByMeno(params);
  }


 

  @Override
  public int add(ProductRep productRep) {
    return productRepDao.insert(productRep);
  }

  @Override
  public int update(ProductRep productRep) {
    return productRepDao.update(productRep);
  }

  @Override
  public ProductRep get(int no) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int delete(int no) {
    return productRepDao.delete(no);
  }



  @Override
  public List<ProductRep> listbyRgdt() {
    return productRepDao.findAllByRgdt();
  }
  
}
