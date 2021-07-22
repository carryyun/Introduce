package com.yun.board.dao;

import com.yun.board.domain.Member;

public interface MemberDao {
    int insert(Member member);
    int delete(int no);
}
