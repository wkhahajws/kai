package com.example.demo.service.impl;

import com.example.demo.entity.Card;
import com.example.demo.repository.CardRepository;
import com.example.demo.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * FileName:CardServiceImpl
 * Author: kaishen
 * Date: 2020/10/26 19:06
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardRepository cardRepository;
    @Override
    public List<Card> findCardList() {
        List<Card> list = cardRepository.findAll();
        return list;
    }
    @Override
    public Card findCardById(long id) {
        Card card = cardRepository.findById(id).get();
        return card;
    }
}
