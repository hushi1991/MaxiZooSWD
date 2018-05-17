package com.example.demo.Model.Repositories;

import com.example.demo.Model.Entities.Card;
import com.example.demo.Model.Entities.CardHolder;

import java.util.ArrayList;

public interface ICardHolderRepo {

    public void deleteCardHolder(int id);

    public CardHolder readSpecificCardHolder(int id);

    public CardHolder read(int id);

    public void createCardHolder(CardHolder cardHolder, Card card, String mail, String empId);

    public CardHolder search(String phone);

    public void updateCardHolder(CardHolder ch);

}
