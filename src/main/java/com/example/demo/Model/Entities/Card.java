package com.example.demo.Model.Entities;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Card {

    private int cardId;
    private int bCardNumber;
    private int sCardNumber;
    private int gCardNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate bStartDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate bEndDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate sStartDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate sEndDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate gStartDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate gEndDate;

    public Card() {


    }

    public Card(int cardId, int bCardNumber, int sCardNumber, int gCardNumber, LocalDate bStartDate, LocalDate bEndDate, LocalDate sStartDate, LocalDate sEndDate, LocalDate gStartDate, LocalDate gEndDate) {
        this.cardId = cardId;
        this.bCardNumber = bCardNumber;
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

    public int getbCardNumber() {
        return bCardNumber;
    }

    public void setbCardNumber(int bCardNumber) {
        this.bCardNumber = bCardNumber;
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

    public LocalDate getbStartDate() {
        return bStartDate;
    }

    public void setbStartDate(LocalDate bStartDate) {
        this.bStartDate = bStartDate;
    }

    public LocalDate getbEndDate() {
        return bEndDate;
    }

    public void setbEndDate(LocalDate bEndDate) {
        this.bEndDate = bEndDate;
    }

    public LocalDate getsStartDate() {
        return sStartDate;
    }

    public void setsStartDate(LocalDate sStartDate) {
        this.sStartDate = sStartDate;
    }

    public LocalDate getsEndDate() {
        return sEndDate;
    }

    public void setsEndDate(LocalDate sEndDate) {
        this.sEndDate = sEndDate;
    }

    public LocalDate getgStartDate() {
        return gStartDate;
    }

    public void setgStartDate(LocalDate gStartDate) {
        this.gStartDate = gStartDate;
    }

    public LocalDate getgEndDate() {
        return gEndDate;
    }

    public void setgEndDate(LocalDate gEndDate) {
        this.gEndDate = gEndDate;
    }
}