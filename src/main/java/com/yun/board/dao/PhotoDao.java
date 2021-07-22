package com.yun.board.dao;

import java.util.Map;

public interface PhotoDao {
    int insert(Map<String,Object> params);
    int delete(int no);
}
