package com.yun.board.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yun.board.dao.ProductDao;

import com.yun.board.domain.Product;
import com.yun.board.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  ProductDao productDao;

  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)

  @Override
  public List<Product> list() {

    return productDao.findAll_list();

  }

  @Override
  public Product get(int no) {

    return productDao.findByNo(no);
  }
  
  @Override
  public List<Product> hotItemlist() {
    return productDao.hotItemlist();
  }


  @Override
  public List<Product> listByMeno(int pageNo, int pageSize, int meno) {
    HashMap<String, Object> params = new HashMap<>();
    params.put("rowNo", (pageNo - 1) * pageSize);
    params.put("size", pageSize);
    params.put("mentno", meno);

    return productDao.findAllByMeno(params);
  }


   
  
  // 마이페이지에서 판매자번호로조회
  @Override
  public List<Product> listBySeller(int meno,int pageNo, int pageSize) {
    HashMap<String, Object> params = new HashMap<>();
    params.put("rowNo", (pageNo - 1) * pageSize);
    params.put("size", pageSize);
    params.put("meno", meno);

    return productDao.findBySeller(params);
  }

  //마이페이지에서 판매자번호로조회2
  @Override
  public List<Product> listBySeller2(int pageNo, int pageSize, int ptno) {
   HashMap<String, Object> params = new HashMap<>();
   params.put("rowNo", (pageNo - 1) * pageSize);
   params.put("size", pageSize);
   params.put("ptno", ptno);

   return productDao.findBySeller2(params);
 }
  @Override
  public int add(Product product) {
    return productDao.insert(product);
  }

  @Override
  public int update(Product product) {

    return productDao.update(product);
  }
  @Override
  public int updatestat(Product product) {
    return productDao.updatestat(product);
  }


  @Override
  public List<Product> listByMtno(int pageNo, int pageSize, int mtno) {
    HashMap<String, Object> params = new HashMap<>();
    params.put("rowNo", (pageNo - 1) * pageSize);
    params.put("size", pageSize);
    params.put("mtno", mtno);

    return productDao.findAllByMtno(params);
  }
  
  @Override
  public List<Product> listByStno(int pageNo, int pageSize, int stno) {
    HashMap<String, Object> params = new HashMap<>();
    params.put("rowNo", (pageNo - 1) * pageSize);
    params.put("size", pageSize);
    params.put("smallno", stno);

    return productDao.findAllByStno(params);
  }

  @Override
  public List<Product> serchByTitl(int pageNo, int pageSize, String titl) {
    HashMap<String, Object> params = new HashMap<>();
    params.put("rowNo", (pageNo - 1) * pageSize);
    params.put("size", pageSize);
    params.put("titl", "%"+titl+"%");
    return productDao.serchByTitl(params);
  }

  @Override
  public List<Product> findAllByList(int pageNo, int pageSize) {
    HashMap<String, Object> params = new HashMap<>();
    params.put("pageNo", (pageNo -1 ) * pageSize);
    params.put("pageSize", pageSize);
    return productDao.findAllByList(params);
  }

  @Override
  public List<Product> pdalist(int pageNo, int pageSize) {
    HashMap<String, Object> params = new HashMap<>();
    params.put("pageNo", (pageNo -1 ) * pageSize);
    params.put("pageSize", pageSize);
    return productDao.pdalist(params);
  }

  @Override
  public int countpdall() {
    return productDao.countpdall();
  }

  @Override
  public List<Product> listForScroll(int pageNo, int pageSize) {
    HashMap<String, Object> params = new HashMap<>();
    params.put("rowNo", (pageNo -1 ) * pageSize);
    params.put("size", pageSize);
    return productDao.findAllForScroll(params);
  }

}
