package com.yun.board.service;

import java.util.List;
import com.yun.board.domain.Mentor;

public interface MentorService {

  //전체 조회
 List<Mentor> list(); 
 
 // 멘티 번호로 조회
 Mentor get(int no); 
 
 // 이메일로 조회
 List<Mentor> listByEmail(int pageSize, String email); 
 
 // 닉네임으로 조회
 List<Mentor> listByNick(int pageSize, String nick);
 
 // 핸드폰으로 조회
 List<Mentor> listByPhone(int pageSize, String phone);
 
 int add(Mentor mentor); // insert
 
 int delete(int no);
 
 int update(Mentor mentor);
 
 // 멘토신청 회원번호 목록 
 List<Mentor> listByMetoStat(int pageNo , int pageSize);
 
}
