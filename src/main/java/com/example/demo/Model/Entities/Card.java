package com.example.demo.Model.Entities;

public class Card {

    private int cardId;
    private int bCardnumber;
    private int sCardNumber;
    private int gCardNumber;
    private String bStartDate;
    private String bEndDate;
    private String sStartDate;
    private String sEndDate;
    private String gStartDate;
    private String gEndDate;

    public Card() {


    }

    public Card(int cardId, int bCardnumber, int sCardNumber, int gCardNumber, String bStartDate, String bEndDate, String sStartDate, String sEndDate, String gStartDate, String gEndDate) {
        this.cardId = cardId;
        this.bCardnumber = bCardnumber;
        this.sCardNumber = sCardNumber;
        this.gCardNumber = gCardNumber;
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

    public int getbCardnumber() {
        return bCardnumber;
    }

    public void setbCardnumber(int bCardnumber) {
        this.bCardnumber = bCardnumber;
    }

    public int getsCardNumber() {
        return sCardNumber;
    }

    public void setsCardNumber(int sCardNumber) {
        this.sCardNumber = sCardNumber;
    }

    public int getgCardNumber() {
        return gCardNumber;
    }

    public void setgCardNumber(int gCardNumber) {
        this.gCardNumber = gCardNumber;
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