package com.yun.board.dao;

import java.util.List;
import com.yun.board.domain.FavoriteCoin;

public interface FavoriteCoinDAO {
    List<String> findAllByNo(int no);
    
    int insert(FavoriteCoin favoriteCoin);
    int delete(FavoriteCoin favoriteCoin);
}
