package com.yun.board.service;

import java.util.List;
import com.yun.board.domain.ClassLike;

public interface ClassLikeService {
  List<ClassLike> classlikelist(int pageSize);
  int likeadd(ClassLike classlike);
  void likesub(int no);
  List<ClassLike> listByMeno(int meno);
  /*List<ClassLike> listByCno(int cno);*/
}
