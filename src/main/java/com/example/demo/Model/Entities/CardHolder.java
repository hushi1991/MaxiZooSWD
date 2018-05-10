package com.example.demo.Model.Entities;

public class CardHolder {

    private int id;
    private Member member;
    private Card card;
    private String adress;
    private String phone;

    public CardHolder(){

    }

    public CardHolder(int id, Member member, Card card, String adress, String phone) {
        this.id = id;
        this.member = member;
        this.card = card;
        this.adress = adress;
        this.phone = phone;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
