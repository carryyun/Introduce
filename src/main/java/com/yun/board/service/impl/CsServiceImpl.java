package com.yun.board.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yun.board.dao.CsDao;

import com.yun.board.domain.Cs;
import com.yun.board.service.CsService;

@Service
public class CsServiceImpl implements CsService {
  
  @Autowired CsDao csDao;
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  
  @Override
  public int add(Cs cs) {
    return csDao.insert(cs);
    
  }
  @Override
  public int addQuestioninfo(Cs cs) {
    return csDao.insertQuestion(cs);
  }
  

  @Override
  public List<Cs> list(int meno,int pageNo, int pageSize) {
    HashMap<String, Object> params = new HashMap<>();
    params.put("rowNo", pageNo);
    params.put("size", pageSize);
    params.put("meno", meno);
    
    return csDao.findAll(params);
    
  }

  @Override
  public Cs get(int no) {
    return csDao.findByNo(no);
  }

  @Override
  public void delete(int no) {
    if (csDao.delete(no) == 0) {
      throw new RuntimeException("해당 번호의 데이터가 없습니다");
    }
    csDao.delete(no);
    
  }


  @Override
  public int update(Cs cs) {
    return csDao.update(cs);
  }

  @Override
  public List<Cs> findByMaster(int cspageNo, int cspageSize) {
    HashMap<String, Object> params = new HashMap<>();
    params.put("cspageNo", (cspageNo - 1) * cspageSize);
    params.put("cspageSize", cspageSize);
    
    return csDao.findByMaster(params);
  }

  @Override
  public List<Cs> pageMaster(int cspageNo, int cspageSize) {
   HashMap<String, Object> params = new HashMap<>();
   params.put("cspageNo", (cspageNo - 1) * cspageSize);
   params.put("cspageSize", cspageSize);
   
   return csDao.pageMaster(params);
   
  }
  @Override
  public int countByMaster() {
    return csDao.countByMaster();
  }
  @Override
  public List<Cs> csPage(int cspageNo, int cspageSize) {
    HashMap<String, Object> params = new HashMap<>();
    params.put("cspageNo", (cspageNo-1) * cspageSize);
    params.put("cspageSize", cspageSize);
    
    return csDao.csPage(params);
  }
  
  
}