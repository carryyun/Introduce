package com.yun.board.dao;

import java.util.List;

import com.yun.board.domain.Coin;

public interface CoinDAO {
    List<Coin> findAll();
    int insert(Coin coin);
}
