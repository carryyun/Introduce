package com.yun.board.dao;

import java.util.List;
import java.util.Map;
import com.yun.board.domain.ClassFile;

public interface ClassFileDao {
  List<ClassFile> findAll(Map<String,Object> params);
  int insert(ClassFile classfile);
  ClassFile findByNo(int no);
  int delete(int no);
  int update(ClassFile cfile);
  List<ClassFile> findByCno(int cno);
}
