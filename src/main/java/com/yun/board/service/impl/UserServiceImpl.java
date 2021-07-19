package com.yun.board.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yun.board.dao.UserDao;
import com.yun.board.domain.UserVO;
import com.yun.board.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<UserVO> list() {
        return userDao.findAll();
    }

    @Override
    public int add(UserVO userVO) {
        return 0;
    }

    @Override
    public UserVO get(int uno) {
        return userDao.findByNo(uno);
    }

    @Override
    public int update(UserVO userVO) {
        return 0;
    }
    
    
}
