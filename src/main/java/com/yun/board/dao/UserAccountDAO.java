package com.yun.board.dao;

import java.util.List;
import com.yun.board.domain.UserAccount;

public interface UserAccountDAO {
    UserAccount findByNo(int no);
    UserAccount findById(UserAccount userAccount);
    List<UserAccount> findAll();
    
    UserAccount insert(UserAccount userAccount);
    int update(UserAccount userAccount);
    int delete(UserAccount userAccount);
}
