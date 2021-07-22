package com.yun.board.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yun.board.dao.ClassFileDao;

import com.yun.board.domain.ClassFile;
import com.yun.board.service.ClassFileService;

@Service
public class ClassFileServiceImpl implements ClassFileService {
  
  @Autowired ClassFileDao cfileDao;
  
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)

  @Override
  public List<ClassFile> list(int pageNo, int pageSize) {
    HashMap<String, Object> params = new HashMap<>();
    params.put("rowNo", (pageNo-1) * pageSize);
    params.put("size", pageSize);
    
    return cfileDao.findAll(params);
  }

  @Override
  public ClassFile get(int no) {
    return cfileDao.findByNo(no);
  }

  @Override
  public void delete(int no) {
    if(cfileDao.delete(no) == 0) {
      throw new RuntimeException("해당 번호의 데이터가 없습니다");
    }
   cfileDao.delete(no);
    
  }


  @Override
  public int update(ClassFile cfile) {
    return cfileDao.update(cfile);
  }

  @Override
  public List<ClassFile> findByCno(int cno) {
    
    return cfileDao.findByCno(cno);
  }

}
