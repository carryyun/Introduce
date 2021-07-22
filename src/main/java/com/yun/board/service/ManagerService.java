package com.yun.board.service;

import java.util.List;

import com.yun.board.domain.Manager;

public interface ManagerService {
    void add(Manager manager);
    List<Manager> list(int pageNo, int pageSize);
    Manager get(int no);
    void delete(int no);
}
