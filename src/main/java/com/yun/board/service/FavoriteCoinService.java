package com.yun.board.service;

import java.util.List;
import com.yun.board.domain.FavoriteCoin;

public interface FavoriteCoinService {
    List<String> listByNo(int no);
    int insert(FavoriteCoin favoriteCoin);
    int delete(FavoriteCoin favoriteCoin);
}
