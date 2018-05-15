package com.example.demo.Model.Entities;

public class CardHolder {

    private int id;
    private Member member;
    private Card card;
    private String address;
    private String postalCode;
    private String phone;
    private Employee employee;


    public CardHolder() {

    }

    public CardHolder(int id, Member member, Card card, String address, String postalCode, String phone, Employee employee) {
        this.id = id;
        this.member = member;
        this.card = card;
        this.address = address;
        this.postalCode = postalCode;
        this.phone = phone;
        this.employee = employee;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}