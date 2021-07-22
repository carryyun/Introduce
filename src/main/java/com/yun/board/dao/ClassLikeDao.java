package com.yun.board.dao;

import java.util.List;
import java.util.Map;
import com.yun.board.domain.ClassLike;

public interface ClassLikeDao {
  List<ClassLike> likelist(Map<String, Object> params);
  
  int likeinsert(ClassLike classlike);
  int likedelete(int no);

  List<ClassLike> findAllByMeno(int no);
 /* List<ClassLike> findAllByCno(int no);*/
  
}
