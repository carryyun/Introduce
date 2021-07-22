package com.yun.board.service;

import java.util.List;
import com.yun.board.domain.Coin;

public interface CoinService {
    List<Coin> list();
    int insert(Coin coin);
}
