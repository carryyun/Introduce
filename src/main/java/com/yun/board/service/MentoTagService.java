package com.yun.board.service;

import java.util.List;
import com.yun.board.domain.MentorTag;

public interface MentoTagService {
 
  List<MentorTag> list(int pageNo, int pageSize); 
  
  // 멘토 번호로 조회
  List<MentorTag> listByMono(int pageNo, int pageSize, int mono); 
  
  // 대분류 번호로 조회
  List<MentorTag> listByBtno(int pageNo, int pageSize, int btno);
  
  // 입력(추가)
  int add(MentorTag mentorTag);
 
  // 삭제
  void delete(int no);
  
  int update(MentorTag mentorTag);
  
}
