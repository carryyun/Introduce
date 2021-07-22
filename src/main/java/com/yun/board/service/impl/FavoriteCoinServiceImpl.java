package com.yun.board.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yun.board.dao.FavoriteCoinDAO;
import com.yun.board.domain.FavoriteCoin;
import com.yun.board.service.FavoriteCoinService;

@Service
public class FavoriteCoinServiceImpl implements FavoriteCoinService {

    @Autowired
    FavoriteCoinDAO favoriteCoinDAO; 
    
    @Override
    public List<String> listByNo(int no) {
        return favoriteCoinDAO.findAllByNo(no);
    }

    @Override
    public int insert(FavoriteCoin favoriteCoin) {
        return favoriteCoinDAO.insert(favoriteCoin);
    }

    @Override
    public int delete(FavoriteCoin favoriteCoin) {
        return favoriteCoinDAO.delete(favoriteCoin);
    }

}
