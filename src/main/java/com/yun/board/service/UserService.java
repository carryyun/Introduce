package com.yun.board.service;

import java.util.List;
import com.yun.board.domain.UserVO;

public interface UserService {
    List<UserVO> list();
    int add(UserVO userVO);
    UserVO get(int uno);
    int update(UserVO userVO);
}
