package com.example.demo.service;

import com.example.demo.entity.Card;

import java.util.List;

/**
 * FileName:CardService
 * Author: kaishen
 * Date: 2020/10/26 19:06
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
public interface CardService {
    public List<Card> findCardList();
    public Card findCardById(long id);
}
