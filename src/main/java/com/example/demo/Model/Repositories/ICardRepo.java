package com.example.demo.Model.Repositories;

import com.example.demo.Model.Entities.Card;

public interface ICardRepo {

    public void createCard(Card card);

    public void deleteCard(int id);

    public void updateCard(Card card);
}
