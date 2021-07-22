package com.yun.board.service;

import java.util.List;
import com.yun.board.domain.UserAccount;

public interface UserAccountService {
    UserAccount get(int no);
    UserAccount get(UserAccount userAccount);
    List<UserAccount> list();
    int update(UserAccount userAccount);
    int delete(UserAccount userAccount);
}
