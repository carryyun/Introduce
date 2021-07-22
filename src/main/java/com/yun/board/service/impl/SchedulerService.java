package com.yun.board.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.yun.board.dao.ClassDao;
import com.yun.board.dao.ClassOrderDao;
import com.yun.board.dao.ClassPopulDao;
import com.yun.board.dao.ClassRepDao;
import com.yun.board.dao.ProductDao;
import com.yun.board.dao.ProductOrderDao;
import com.yun.board.dao.ProductPopulDao;
import com.yun.board.dao.ProductRepDao;

import com.yun.board.domain.ClassRep;
import com.yun.board.domain.Classes;
import com.yun.board.domain.Product;
import com.yun.board.domain.ProductRep;

@Service
public class SchedulerService {

  @Autowired ProductDao productDao;
  @Autowired ProductRepDao productRepDao;
  @Autowired ClassDao classDao;
  @Autowired ClassRepDao classRepDao;
  @Autowired ClassOrderDao classOrderDao;
  @Autowired ClassPopulDao classPopulDao;
  @Autowired ProductOrderDao productOrderDao;
  @Autowired ProductPopulDao productPopulDao;

  //스케줄러 이용
  @Scheduled(fixedRate=6000000)
  public void StarSetter() {
    List<Classes> classesList = classDao.findAllStar();
    for(Classes classes : classesList) {
      Map<String, Object> params = new HashMap<>();
      params.put("rowNo", 0);
      params.put("size", 300);
      params.put("no", classes.getNo());
      int tot = 0;
      List<ClassRep> classesRepList = classRepDao.findAllStar(params);
      for(ClassRep classRep:classesRepList) {
        tot+=classRep.getStar();
      }
      if(tot>0) {
        int avg = tot/classesRepList.size();
        if(avg>0) {
          classes.setStar(avg);
          classDao.classupdate(classes);
        }else {
          classes.setStar(1);
          classDao.classupdate(classes);
        }
      }else {
        classes.setStar(0);
        classDao.classupdate(classes);
      }
    }
   
    
    
    // 상품
    List<Product> productList = productDao.findAllStar();
    for(Product product : productList) {
      Map<String, Object> params = new HashMap<>();
      params.put("rowNo", 0);
      params.put("size", 300);
      params.put("no", product.getNo());
      int tot = 0;
      List<ProductRep> productRepList = productRepDao.findAllStar(params);
      for(ProductRep productRep:productRepList) {
        tot+=productRep.getStar();
      }
      if(tot>0) {
        int avg = tot/productRepList.size();
        if(avg>0) {
          product.setStar(avg);
          productDao.update(product);
        }else {
          product.setStar(1);
          productDao.update(product);
        }
      }else {
        product.setStar(0);
        productDao.update(product);
      }
    }
    
    
    System.out.println("StarSetter Scheduled.(10분)");
  }
  
  // 인기예감 클래스로 변경 
  @Scheduled(fixedRate=6000000)
  public void popularityClass(){
    System.out.println("popularityClassSystem start");
    List<Integer> popularityClasslist = classOrderDao.selpopularityclass();
      classPopulDao.delete();
    for(int no : popularityClasslist) {
      classPopulDao.insert(no); 
    }
  }
  
  // 추천작품 1시간마다 리쉣
  @Scheduled(fixedRate=6000000)
  public void recommendProduct() {
    System.out.println("recommendProductSystem start");
    List<Integer> recommendProductlist = productOrderDao.selrecommendproduct();
      productPopulDao.delete(); 
    for(int no : recommendProductlist) {
      productPopulDao.insert(no);
    }
    
  }
}
