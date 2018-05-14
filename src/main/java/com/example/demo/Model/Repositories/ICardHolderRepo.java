package com.example.demo.Model.Repositories;

import com.example.demo.Model.Entities.CardHolder;

import java.util.ArrayList;

public interface ICardHolderRepo {

    public void createCardHolder(CardHolder cardHolder);

    public void deleteCardHolder(int id);

    public CardHolder readSpecificCardHolder(int id);

}
