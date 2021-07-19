package com.yun.board.dao;

import java.util.List;
import com.yun.board.domain.UserVO;

public interface UserDao {
    List<UserVO> findAll();
    UserVO findByNo(int uno);
}
