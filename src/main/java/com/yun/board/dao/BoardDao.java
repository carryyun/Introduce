package com.yun.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yun.board.domain.BoardVO;

public interface BoardDao {
    List<BoardVO> findAll(@Param("pageNo") int pageNo,@Param("pageSize") int pageSize);
    int insert(BoardVO boardVO);
    BoardVO findByNo(int bno);
    int update(BoardVO boardVO);
    int updateCnt(int bno);
    
    int count();
}
