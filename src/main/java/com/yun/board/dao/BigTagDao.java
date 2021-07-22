package com.yun.board.dao;

import java.util.List;
import com.yun.board.domain.BigTag;

public interface BigTagDao {
  List<BigTag> findAll();
  List<BigTag> findByMono(int no);
  BigTag findByName(String name);
  BigTag findByNo(int no);
  BigTag insert(BigTag bigTag);
}
