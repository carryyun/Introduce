package com.yun.board.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yun.board.dao.CoinDAO;
import com.yun.board.domain.Coin;
import com.yun.board.service.CoinService;

@Service
public class CoinServiceImpl implements CoinService{

    @Autowired
    CoinDAO coinDAO;
    
    @Override
    public List<Coin> list() {
        return coinDAO.findAll();
    }

    @Override
    public int insert(Coin coin) {
        return coinDAO.insert(coin);
    }

}
