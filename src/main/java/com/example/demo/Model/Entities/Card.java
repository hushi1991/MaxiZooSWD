package com.example.demo.Model.Entities;

public class Card {

    private int cardId;
    private String cardValue;

    public Card(){

    }

    public Card(int cardId, String cardValue) {
        this.cardId = cardId;
        this.cardValue = cardValue;
    }


    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getCardValue() {
        return cardValue;
    }

    public void setCardValue(String cardValue) {
        this.cardValue = cardValue;
    }


}
