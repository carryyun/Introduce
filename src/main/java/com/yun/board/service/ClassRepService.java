package com.yun.board.service;

import java.util.List;
import com.yun.board.domain.ClassRep;

public interface ClassRepService {
  int repAdd(ClassRep classRep);
  int repDelete(int no);
  int repupdate(ClassRep classRep);
  List<ClassRep> repList();
  List<ClassRep> listbycno(int cno , int pageNo , int pageSize);
  int countbycno(int cno);

  List<ClassRep> listbyRgdt();
  
  ClassRep get(int no);
  
  /*double countstar(int no);*/
}
