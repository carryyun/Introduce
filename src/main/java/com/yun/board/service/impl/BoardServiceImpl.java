package com.yun.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yun.board.dao.BoardDao;
import com.yun.board.domain.BoardVO;
import com.yun.board.domain.UserVO;
import com.yun.board.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardDao boardDao;
    
    @Override
    public List<BoardVO> list(int pageNo, int pageSize) {
        
        return boardDao.findAll(pageNo, pageSize);
    }

    @Override
    public int add(BoardVO boardVO) {
        UserVO userVO=new UserVO();
        userVO.setUno(1);
        boardVO.setUserVO(userVO);
        return boardDao.insert(boardVO);
    }

    @Override
    public BoardVO get(int bno) {
        return boardDao.findByNo(bno);
    }

    @Override
    public int update(BoardVO boardVO) {
        UserVO userVO=new UserVO();
        userVO.setUno(1);
        boardVO.setUserVO(userVO);
        return boardDao.update(boardVO);
    }
    @Override
    public int updateCnt(int bno) {
        return boardDao.updateCnt(bno);
    }

    @Override
    public int count() {
        return boardDao.count();
    }

    
 
  
}
