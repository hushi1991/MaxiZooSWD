package com.example.demo.Model.Entities;

public class Card {

    private int cardId;
    private String cardValue;
    private String bStartDate;
    private String bEndDate;
    private String sStartDate;
    private String sEndDate;
    private String gStartDate;
    private String gEndDate;


    public Card() {

    }

    public Card(int cardId, String cardValue, String bStartDate, String bEndDate, String sStartDate, String sEndDate, String gStartDate, String gEndDate) {
        this.cardId = cardId;
        this.cardValue = cardValue;
        this.bStartDate = bStartDate;
        this.bEndDate = bEndDate;
        this.sStartDate = sStartDate;
        this.sEndDate = sEndDate;
        this.gStartDate = gStartDate;
        this.gEndDate = gEndDate;
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

    public String getbStartDate() {
        return bStartDate;
    }

    public void setbStartDate(String bStartDate) {
        this.bStartDate = bStartDate;
    }

    public String getbEndDate() {
        return bEndDate;
    }

    public void setbEndDate(String bEndDate) {
        this.bEndDate = bEndDate;
    }

    public String getsStartDate() {
        return sStartDate;
    }

    public void setsStartDate(String sStartDate) {
        this.sStartDate = sStartDate;
    }

    public String getsEndDate() {
        return sEndDate;
    }

    public void setsEndDate(String sEndDate) {
        this.sEndDate = sEndDate;
    }

    public String getgStartDate() {
        return gStartDate;
    }

    public void setgStartDate(String gStartDate) {
        this.gStartDate = gStartDate;
    }

    public String getgEndDate() {
        return gEndDate;
    }

    public void setgEndDate(String gEndDate) {
        this.gEndDate = gEndDate;
    }

}