package com.yun.board.service;

import java.util.List;

import com.yun.board.domain.BoardVO;

public interface BoardService {
    List<BoardVO> list(int pageNo, int pageSize);
    int add(BoardVO boardVO);
    BoardVO get(int bno);
    int update(BoardVO boardVO);
    int updateCnt(int bno);
    
    int count();
}
